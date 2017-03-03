create table topic(
 id int primary key auto_increment,
 title varchar(50) not null unique, 
 name varchar(50) not null, 
 content varchar(200) not null,
 time timestamp not null,
 type_id int,
 constraint type_id_FK foreign key(type_id) references type(id) 
);
insert into topic(title,name,content,type_id) values('大众汽车降价了','张兵','庆五一，大众汽车在中国市场全线价格下降30%，仅限5万辆',1);
insert into topic(title,name,content,type_id) values('汽车油价上涨了','何平','受国际油价关系，中国市场全线油价上调10%',1);
insert into topic(title,name,content,type_id) values('移动电脑','李渊','微软决定进军移动领域，开发专用于移动领域个人电脑',2);
insert into topic(title,name,content,type_id) values('迷你型个人电脑','赵达','苹台开发出迷你型个人电脑，仅有普通手表大小',2);
insert into topic(title,name,content,type_id) values('三国游戏上线了','河平','庆十一，三国游戏上线了，免费玩7天',3);
insert into topic(title,name,content,type_id) values('最新足球游戏','南安','庆十一，邀请游戏玩家一共聚会',3);
insert into topic(title,name,content,type_id) values('广州房价平横','郑海搏','2011年上半年，广州新房价格平稳，大浮降价的空间不大',4);
insert into topic(title,name,content,type_id) values('北京房价下降很慢','郑海搏','受国家调空的影响，北京二季度楼市缓慢下降',4);
insert into topic(title,name,content,type_id) values('中国联通iPhone','谭坤','庆国庆，中国联通iPhone仅限10万部手机优惠',5);
insert into topic(title,name,content,type_id) values('中国移动oPhone','刘志','庆国庆，中国移动oPhone手机优惠20%，欲购从速',5);