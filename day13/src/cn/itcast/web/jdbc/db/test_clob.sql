drop table if exists test_clob;
create table if not exists test_clob(
  id varchar(40) primary key,
  content mediumblob
);