drop database if exists soufang;
create database if not exists soufang;
use soufang;

drop table if exists fang;
create table if not exists fang(
  #���
  id int primary key auto_increment,
  #���� 
  area varchar(10) not null,
  #�ص� 
  address varchar(10) not null,
  #������ 
  space varchar(10) not null
);

insert into fang(area,address,space)
values('�����','����','��������');

insert into fang(area,address,space)
values('�����','����','��������');

insert into fang(area,address,space)
values('�����','����','��������');

insert into fang(area,address,space)
values('�����','����','��������');

insert into fang(area,address,space)
values('������','��ɳ','һ��һ��');

insert into fang(area,address,space)
values('������','��ɳ','һ��һ��');

insert into fang(area,address,space)
values('������','��ɳ','��������');

insert into fang(area,address,space)
values('������','��ɳ','��������');

select * from fang;



