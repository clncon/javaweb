drop database if exists soufang;
create database if not exists soufang;
use soufang;

drop table if exists fang;
create table if not exists fang(
  #编号
  id int primary key auto_increment,
  #区域 
  area varchar(10) not null,
  #地点 
  address varchar(10) not null,
  #房间数 
  space varchar(10) not null
);

insert into fang(area,address,space)
values('天河区','东圃','三房二厅');

insert into fang(area,address,space)
values('天河区','东圃','三房二厅');

insert into fang(area,address,space)
values('天河区','东圃','二房二厅');

insert into fang(area,address,space)
values('天河区','东圃','二房二厅');

insert into fang(area,address,space)
values('黄埔区','下沙','一房一厅');

insert into fang(area,address,space)
values('黄埔区','下沙','一房一厅');

insert into fang(area,address,space)
values('黄埔区','下沙','二房二厅');

insert into fang(area,address,space)
values('黄埔区','下沙','三房二厅');

select * from fang;



