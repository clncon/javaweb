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
values('�����������ڶ���Ǯѽ','С��','�����������ڶ���Ǯѽ',1);

insert into reply(title,name,content,topic_id) 
values('97������������','С��','97������������',2);

insert into reply(title,name,content,topic_id) 
values('���Ի����ƶ��ĺ�','С��','���Ի����ƶ��ĺ�',3);

insert into reply(title,name,content,topic_id) 
values('̫�˵��ԣ��Ҷ��쿴������','С��','̫�˵��ԣ��Ҷ��쿴������',4);