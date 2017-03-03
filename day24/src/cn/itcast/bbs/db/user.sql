create table user(
 id int primary key auto_increment,
 username varchar(20) not null,
 password varchar(6) not null,
 gender varchar(6) not null,
 email varchar(30) not null
);
insert into user(username,password,gender,email)
values('jack','000000','male','jack@163.com');