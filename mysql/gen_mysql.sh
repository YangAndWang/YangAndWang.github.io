#!/bin/bash
if [[ $1 -ne '' ]];then
  port=$1
elif [[ $port -ne '' ]];then
  exit -1
  port=$port
else
  exit -1
  port=50826
fi

mkdir -p /learnwy/data/mysql-${port}
echo -e "#!/bin/bash\n\
#######################\n\
# 启动mysql ${port}\n\
######################\n\
mysqld_safe --defaults-file=/learnwy/etc/my-${port}.cnf & " > /learnwy/scripts/mysql-${port}.sh

echo -e "\
#!/bin/bash\n
mysql -uroot -P${port} -p --socket=/tmp/mysql-${port}.sock" > /learnwy/scripts/mysql-cli-${port}.sh


echo -e "\
[mysqld]\n
port=${port}\n\
socket=/tmp/mysql-${port}.sock\n\
basedir=/learnwy/app/mysql\n\
datadir=/learnwy/data/mysql-${port}\n\
pid-file=/learnwy/data/mysql-${port}/com.learnwy.mysql.pid\n\
character-set-server=utf8\n\
user=mysql\n\
\n\
[client]\n\
port=${port}\n\
socket=/tmp/mysql-${port}.sock" > /learnwy/etc/my-${port}.cnf
echo chown
sudo chown -R mysql /learnwy/data/mysql-${port}
#sudo chown -R mysql /learnwy/data
#sudo chmod -R g+rwx /learnwy/data/mysql-${port}
sudo chmod u+x /learnwy/scripts/mysql-${port}.sh
sudo chmod u+x /learnwy/scripts/mysql-cli-${port}.sh


export port

./mysql-init.sh
