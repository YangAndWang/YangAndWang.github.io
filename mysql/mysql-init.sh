#!/bin/bash

mysqld --initialize --basedir=/learnwy/local/mysql --datadir=/learnwy/data/mysql-${port} --user=mysql

mysql_ssl_rsa_setup --datadir=/learnwy/data/mysql-${port}
