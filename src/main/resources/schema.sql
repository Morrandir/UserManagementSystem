create table SYS_USER (
	user_id int not null,
	user_name varchar(64) not null,
	password varchar(256) not null,
	enabled boolean not null,
  online boolean not null,
	primary key (user_id)
);

create table SYS_USER_ROLE (
	role_id int not null,
  user_id int not null,
	role_name varchar(128) not null,
	primary key (role_id)
);

create table SYS_PREVILEDGES (
	previledge_id int not null,
	previledge_name varchar(128) not null,
	primary key (previledge_id)
);

create table ROLE_PREVILEDGES (
	role_id int not null,
	previledge_id int not null,
	primary key (role_id, previledge_id)
);

alter table SYS_USER_ROLE add constraint FK_SYS_USER_ROLE_ID foreign key (user_id) references SYS_USER (user_id);

insert into SYS_PREVILEDGES (previledge_id, previledge_name) values (1, 'PREVILEDGE_ALL');
insert into SYS_PREVILEDGES (previledge_id, previledge_name) values (2, 'PREVILEDGE_READ_ONLY');

insert into ROLE_PREVILEDGES (role_id, previledge_id) values (1, 1);
insert into ROLE_PREVILEDGES (role_id, previledge_id) values (2, 2);

insert into SYS_USER (user_id, user_name, password, enabled, online) values (1, 'Admin', 'test', true, false);
insert into SYS_USER (user_id, user_name, password, enabled, online) values (2, 'tester', 'test', true, false);

insert into SYS_USER_ROLE (role_id, user_id, role_name) values (1, 1, 'ROLE_ADMIN');
insert into SYS_USER_ROLE (role_id, user_id, role_name) values (2, 1, 'ROLE_VIEWER');
insert into SYS_USER_ROLE (role_id, user_id, role_name) values (3, 2, 'ROLE_VIEWER');