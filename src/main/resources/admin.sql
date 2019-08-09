create table dd_admin(
	id varchar2(32) primary key,
	username varchar2(50),
	password varchar2(50)
)
select * from dd_admin
insert into dd_admin values('1','admin','admin')