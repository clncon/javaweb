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
12010101,"ÀîÀÖ","ÄĞ","01°à",80,90,80);  
insert into student(id,Name,Gender,myClass,English,Math,Chinese)value(
12010102,"ÕÔºÆ","ÄĞ","01°à",70,90,59);  
insert into student(id,Name,Gender,myClass,English,Math,Chinese)value(
12010103,"ÕÅÃÈÃÈ","Å®","01°à",90,90,80);  
insert into student(id,Name,Gender,myClass,English,Math,Chinese)value(
12010104,"Í¿ÇÙ","Å®","01°à",60,70,70);  
insert into student(id,Name,Gender,myClass,English,Math,Chinese)value(
12010105,"Ô¬ºÆÀÚ","ÄĞ","01°à",90,70,75);  
insert into student(id,Name,Gender,myClass,English,Math,Chinese)value(
12010201,"ÁõÃ÷","ÄĞ","02°à",65,85,71);  
insert into student(id,Name,Gender,myClass,English,Math,Chinese)value(
12010202,"ºúµû","Å®","02°à",82,76,71);  
insert into student(id,Name,Gender,myClass,English,Math,Chinese)value(
12010203,"ÂÀÑà","Å®","02°à",87,84,83);  
insert into student(id,Name,Gender,myClass,English,Math,Chinese)value(
12010204,"ÉòÃ÷","ÄĞ","02°à",53,95,76);  
insert into student(id,Name,Gender,myClass,English,Math,Chinese)value(
12010205,"ÓÚÇÙ","Å®","02°à",69,85,64);  
insert into student(id,Name,Gender,myClass,English,Math,Chinese)value(
12010301,"ÍõĞ¡Å·","Å®","03°à",66,71,80);  
insert into student(id,Name,Gender,myClass,English,Math,Chinese)value(
12010302,"ÂíÈü¿Ë","","03°à",86,64,73);  
insert into student(id,Name,Gender,myClass,English,Math,Chinese)value(
12010303,"¸ßÌì±¦","ÄĞ","03°à",71,82,62);  
insert into student(id,Name,Gender,myClass,English,Math,Chinese)value(
12010304,"ÖÜÃÎ³¿","ÄĞ","03°à",93,94,90);  
insert into student(id,Name,Gender,myClass,English,Math,Chinese)value(
12010305,"ÖÜº²Áú","ÄĞ","03°à",62,84,51);  
insert into student(id,Name,Gender,myClass,English,Math,Chinese)value(
12010401,"ÑÕÂ·","ÄĞ","04°à",88,65,52);  
insert into student(id,Name,Gender,myClass,English,Math,Chinese)value(
12010402,"ÕÅÕıÄİ","Å®","04°à",68,54,84);  
insert into student(id,Name,Gender,myClass,English,Math,Chinese)value(
12010403,"Ğì»ª»ª","ÄĞ","04°à",54,32,65);  
insert into student(id,Name,Gender,myClass,English,Math,Chinese)value(
12010404,"ÎâÓîÏè","ÄĞ","04°à",63,65,66);  
insert into student(id,Name,Gender,myClass,English,Math,Chinese)value(
12010405,"ÕÅÀÚ","ÄĞ","04°à",66,85,76);  