create table address(
 id int primary key auto_increment,
 ip varchar(20) not null,
 location varchar(20) not null
);
insert into address(ip,location) values('127.0.0.1','π„÷›');