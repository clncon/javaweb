drop table if exists person;
drop table if exists card;
create table if not exists person(
   id int primary key auto_increment,
   name varchar(40) not null
);
create table if not exists card(
 id int primary key auto_increment,
 location varchar(40) not null,
 pid int,
 constraint pid_FK foreign key(pid) references person(id)
);