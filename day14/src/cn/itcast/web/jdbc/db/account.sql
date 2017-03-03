drop table if exists account;
create table account(
 id int primary key auto_increment,
 name varchar(20) not null,
 salary float
);
insert into account(name,salary)values('aaa',3000);
insert into account(name,salary)values('bbb',3000);