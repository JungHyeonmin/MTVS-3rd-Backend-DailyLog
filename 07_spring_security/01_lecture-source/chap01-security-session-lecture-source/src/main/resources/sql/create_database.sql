CREATE USER 'login'@'%' IDENTIFIED BY 'login';

show databases;

USE mysql;

show tables;

select * from user;

CREATE DATABASE login;
show databases;
GRANT ALL PRIVILEGES ON login.* TO 'login'@'%';

show grants for 'login'@'%';
