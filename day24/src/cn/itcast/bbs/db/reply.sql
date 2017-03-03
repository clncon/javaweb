create table reply(
 id int primary key auto_increment,
 title varchar(50) not null unique, 
 name varchar(20) not null, 
 content varchar(200) not null,
 time timestamp not null,
 topic_id int,
 constraint topic_id_FK foreign key(topic_id) references topic(id) 
);
insert into reply(title,name,content,topic_id) 
values('大众汽车现在多少钱呀','小雨','大众汽车现在多少钱呀',1);

insert into reply(title,name,content,topic_id) 
values('97号汽油涨了吗','小雨','97号汽油涨了吗',2);

insert into reply(title,name,content,topic_id) 
values('电脑还是移动的好','小雨','电脑还是移动的好',3);

insert into reply(title,name,content,topic_id) 
values('太了电脑，我都快看不清了','小清','太了电脑，我都快看不清了',4);