use mydb3;
drop table if exists city;
create table if not exists city(
	id int primary key auto_increment,
	city_name varchar(10) not null,
	province_name varchar(10) not null
);
insert into city(city_name,province_name) values('����','����ʡ');
insert into city(city_name,province_name) values('������','����ʡ');
insert into city(city_name,province_name) values('��ԭ','����ʡ');
insert into city(city_name,province_name) values('ͨ��','����ʡ');

insert into city(city_name,province_name) values('����','����ʡ');
insert into city(city_name,province_name) values('����','����ʡ');
insert into city(city_name,province_name) values('��ɽ','����ʡ');
insert into city(city_name,province_name) values('��˳','����ʡ');
insert into city(city_name,province_name) values('����','����ʡ');

insert into city(city_name,province_name) values('����','ɽ��ʡ');
insert into city(city_name,province_name) values('�ൺ','ɽ��ʡ');
insert into city(city_name,province_name) values('����','ɽ��ʡ');

insert into city(city_name,province_name) values('��ɳ','����ʡ');
insert into city(city_name,province_name) values('����','����ʡ');

select * from city;
