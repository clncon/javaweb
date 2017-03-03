create table topic(
 id int primary key auto_increment,
 title varchar(50) not null unique, 
 name varchar(50) not null, 
 content varchar(200) not null,
 time timestamp not null,
 type_id int,
 constraint type_id_FK foreign key(type_id) references type(id) 
);
insert into topic(title,name,content,type_id) values('��������������','�ű�','����һ�������������й��г�ȫ�߼۸��½�30%������5����',1);
insert into topic(title,name,content,type_id) values('�����ͼ�������','��ƽ','�ܹ����ͼ۹�ϵ���й��г�ȫ���ͼ��ϵ�10%',1);
insert into topic(title,name,content,type_id) values('�ƶ�����','��Ԩ','΢����������ƶ����򣬿���ר�����ƶ�������˵���',2);
insert into topic(title,name,content,type_id) values('�����͸��˵���','�Դ�','ƻ̨�����������͸��˵��ԣ�������ͨ�ֱ��С',2);
insert into topic(title,name,content,type_id) values('������Ϸ������','��ƽ','��ʮһ��������Ϸ�����ˣ������7��',3);
insert into topic(title,name,content,type_id) values('����������Ϸ','�ϰ�','��ʮһ��������Ϸ���һ���ۻ�',3);
insert into topic(title,name,content,type_id) values('���ݷ���ƽ��','֣����','2011���ϰ��꣬�����·��۸�ƽ�ȣ��󸡽��۵Ŀռ䲻��',4);
insert into topic(title,name,content,type_id) values('���������½�����','֣����','�ܹ��ҵ��յ�Ӱ�죬����������¥�л����½�',4);
insert into topic(title,name,content,type_id) values('�й���ͨiPhone','̷��','����죬�й���ͨiPhone����10���ֻ��Ż�',5);
insert into topic(title,name,content,type_id) values('�й��ƶ�oPhone','��־','����죬�й��ƶ�oPhone�ֻ��Ż�20%����������',5);