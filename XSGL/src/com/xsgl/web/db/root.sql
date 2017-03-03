use mydb3;
drop table if exists root;
create table if not exists root(
  rootId int primary key auto_increment,
  rootName varchar(20) not null,
  rootPassword varchar(20) not null
);
insert into root(rootName,rootPassword)value("root","root");