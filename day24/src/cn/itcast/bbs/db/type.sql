create table type(
 id int primary key auto_increment,
 title varchar(50) not null unique, 
 image varchar(50) not null unique, 
 click int not null default 0,
 constraint title_FK foreign key(title) references admin(title)
);
insert into type(title,image) values('����','image/car.jpg');
insert into type(title,image) values('����','image/computer.jpg');
insert into type(title,image) values('��Ϸ','image/game.jpg');
insert into type(title,image) values('����','image/house.jpg');
insert into type(title,image) values('�ֻ�','image/phone.jpg');
