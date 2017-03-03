create database if not exists sys;
use sys;
drop table if exists equipment;
create table if not exists equipment(
   id int  primary key auto_increment,
   name varchar(20) not null,
   count int not null,
   function varchar(100) not null,
   position int not null

);
desc equipment;
insert into equipment(name,count,function,position)values("手套",20,"保护手，不被锐利的东西划伤",1);
insert into equipment(name,count,function,position)values("手机",30,"保证和外界的联系",2);
insert into equipment(name,count,function,position)values("棉毛裤",40,"保护下半身",3);
insert into equipment(name,count,function,position)values("棉衣",60,"保护上半身",4);
insert into equipment(name,count,function,position)values("帽子",50,"保护头部",5);
select * from equipment;
drop if exists table borrow ;
create table if not exists borrow(
   id int primary key auto_increment,
    name varchar(20) not null,
    count int not null,
   time timestamp not null
);
insert into borrow(name,count)values("手套",10);
insert into borrow(name,count)values("手机",30);
insert into borrow(name,count)values("棉毛裤",20);
insert into borrow(name,count)values("棉衣",14);
insert into borrow(name,count)values("帽子",34);
 select * from borrow;