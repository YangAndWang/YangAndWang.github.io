#!/bin/bash

name=$1
name=${name%.tex}
echo $name
echo $1
#echo "stat --format=%Y $1"
echo "监控 $1 自动生成pdf"
lastM=
nowM=

lastM=`stat --format=%Y $1`
while [ 1 -eq 1 ];do

  nowM=`stat --format=%Y $1`
  lastM=$(($lastM))
  nowM=$(($nowM))
  #echo "$lastM $nowM"
  if [ $lastM -lt $nowM ];then
      lastM=$nowM #`stat --format=%Y $1`
      #echo "$lastM $nowM"
      # 为了产生目录
      latex $name && dvipdfmx $name 
      latex $name && dvipdfmx $name 
  fi
  sleep 5;  
done
#latex $name && xdvipdfmx $name

