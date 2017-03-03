use mydb3;
drop table if exists up;
create table if not exists up(
   id int primary key auto_increment,
   username varchar(20) not null,
   uuidFileName varchar(80) not null,
   fileRealName varchar(40) not null
);