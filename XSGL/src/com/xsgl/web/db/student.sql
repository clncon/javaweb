use mydb3;
drop table if exists student;
create table if not exists student(
  Id int primary key not null,
  Name varchar(20) not null,
  Gender varchar(2) not null,
  myClass varchar(10) not null, 
  English int not null,
  Math int not null,
  Chinese int not null
);
insert into student(Id,Name,Gender,myClass,English,Math,Chinese)value(
12010101,"����","��","01��",80,90,80);  
insert into student(id,Name,Gender,myClass,English,Math,Chinese)value(
12010102,"�Ժ�","��","01��",70,90,59);  
insert into student(id,Name,Gender,myClass,English,Math,Chinese)value(
12010103,"������","Ů","01��",90,90,80);  
insert into student(id,Name,Gender,myClass,English,Math,Chinese)value(
12010104,"Ϳ��","Ů","01��",60,70,70);  
insert into student(id,Name,Gender,myClass,English,Math,Chinese)value(
12010105,"Ԭ����","��","01��",90,70,75);  
insert into student(id,Name,Gender,myClass,English,Math,Chinese)value(
12010201,"����","��","02��",65,85,71);  
insert into student(id,Name,Gender,myClass,English,Math,Chinese)value(
12010202,"����","Ů","02��",82,76,71);  
insert into student(id,Name,Gender,myClass,English,Math,Chinese)value(
12010203,"����","Ů","02��",87,84,83);  
insert into student(id,Name,Gender,myClass,English,Math,Chinese)value(
12010204,"����","��","02��",53,95,76);  
insert into student(id,Name,Gender,myClass,English,Math,Chinese)value(
12010205,"����","Ů","02��",69,85,64);  
insert into student(id,Name,Gender,myClass,English,Math,Chinese)value(
12010301,"��Сŷ","Ů","03��",66,71,80);  
insert into student(id,Name,Gender,myClass,English,Math,Chinese)value(
12010302,"������","","03��",86,64,73);  
insert into student(id,Name,Gender,myClass,English,Math,Chinese)value(
12010303,"���챦","��","03��",71,82,62);  
insert into student(id,Name,Gender,myClass,English,Math,Chinese)value(
12010304,"���γ�","��","03��",93,94,90);  
insert into student(id,Name,Gender,myClass,English,Math,Chinese)value(
12010305,"�ܺ���","��","03��",62,84,51);  
insert into student(id,Name,Gender,myClass,English,Math,Chinese)value(
12010401,"��·","��","04��",88,65,52);  
insert into student(id,Name,Gender,myClass,English,Math,Chinese)value(
12010402,"������","Ů","04��",68,54,84);  
insert into student(id,Name,Gender,myClass,English,Math,Chinese)value(
12010403,"�컪��","��","04��",54,32,65);  
insert into student(id,Name,Gender,myClass,English,Math,Chinese)value(
12010404,"������","��","04��",63,65,66);  
insert into student(id,Name,Gender,myClass,English,Math,Chinese)value(
12010405,"����","��","04��",66,85,76);  