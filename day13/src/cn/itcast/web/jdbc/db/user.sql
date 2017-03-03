drop table  if exists user;
create table if not exists user(
   id int primary key auto_increment,
   username varchar(40) not null,
   password varchar(6) not null,
   birthday Date not null,
   salary float(6,2) not null
);
insert into user(username,password,birthday,salary) values('jack','000000','2011-05-08',5000);
insert into user (username,password,birthday,salary)values('marry','111111','2011-04-06',3000);