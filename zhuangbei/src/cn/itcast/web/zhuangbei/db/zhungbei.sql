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
insert into equipment(name,count,function,position)values("����",20,"�����֣����������Ķ�������",1);
insert into equipment(name,count,function,position)values("�ֻ�",30,"��֤��������ϵ",2);
insert into equipment(name,count,function,position)values("��ë��",40,"�����°���",3);
insert into equipment(name,count,function,position)values("����",60,"�����ϰ���",4);
insert into equipment(name,count,function,position)values("ñ��",50,"����ͷ��",5);
select * from equipment;
drop if exists table borrow ;
create table if not exists borrow(
   id int primary key auto_increment,
    name varchar(20) not null,
    count int not null,
   time timestamp not null
);
insert into borrow(name,count)values("����",10);
insert into borrow(name,count)values("�ֻ�",30);
insert into borrow(name,count)values("��ë��",20);
insert into borrow(name,count)values("����",14);
insert into borrow(name,count)values("ñ��",34);
 select * from borrow;