create table type(
 id int primary key auto_increment,
 title varchar(50) not null unique, 
 image varchar(50) not null unique, 
 click int not null default 0,
 constraint title_FK foreign key(title) references admin(title)
);
insert into type(title,image) values('汽车','image/car.jpg');
insert into type(title,image) values('电脑','image/computer.jpg');
insert into type(title,image) values('游戏','image/game.jpg');
insert into type(title,image) values('房子','image/house.jpg');
insert into type(title,image) values('手机','image/phone.jpg');
