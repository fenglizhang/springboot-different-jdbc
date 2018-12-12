drop table  if exists user;
create table user(
id int primary key not null,
username char(20),
name char(20),
age INTEGER ,
balance DECIMAL(6,0)
)