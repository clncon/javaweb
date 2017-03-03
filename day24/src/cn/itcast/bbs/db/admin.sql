create table admin(
 id int primary key auto_increment,
 name varchar(20) not null,
 title varchar(50) not null unique 
);
insert into admin(name,title) values('王强','汽车');
insert into admin(name,title) values('王强','电脑');
insert into admin(name,title) values('李渊','游戏');
insert into admin(name,title) values('李渊','房子');
insert into admin(name,title) values('何梅','手机');
