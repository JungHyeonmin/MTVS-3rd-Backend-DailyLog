create database ohgiraffers;

create user ohgiraffers@'%' identified by 'ohgiraffers';

grant all privileges on ohgiraffers.* to ohgiraffers@'%';

use ohgiraffers;

show tables ;