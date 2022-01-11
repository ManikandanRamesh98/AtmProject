--user list--username and password
drop table usernamepass;
create table usernamepass(
id int GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
username varchar(80) not null,
password varchar(80) not null
);
alter table usernamepass add created_at timestamp  default current_timestamp not null;
alter table usernamepass add constraint pk_user primary key(username);
alter table usernamepass add role varchar(80) not null;
select * from usernamepass;
desc usernamepass;
delete from usernamepass;
insert into usernamepass(username,password,role) values('Hari','hari@123','admin');

--profilebank--unique yet
create table userprofile(
id int GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
username varchar(80) not null,
user_acc_no int not null,
balance number(20,2) not null,
mob_no int not null);
alter table userprofile drop column mob_no;
commit;
alter table userprofile add constraint fk_user foreign key(username) references usernamepass(username);
alter table userprofile add constraint pk_useracc primary key(user_acc_no);
alter table userprofile modify acc_created_at not null;
alter table userprofile add acc_created_at timestamp default current_timestamp;
alter table userprofile modify balance default 500;
desc userprofile;
select * from userprofile;
insert into userprofile(username,user_acc_no,mob_no,user_pin) values('Hari',12345678902,9789674836,1235);

--deposit table--
create table deposit(
id int GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
user_acc_no int not null,
dep_amount number(20,2) not null);

alter table deposit add dep_at timestamp default current_timestamp;
alter table deposit add constraint fk_userdep foreign key(user_acc_no) references userprofile(user_acc_no);

delete from deposit;
--withdraw table--
create table withdraw(
id int GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
user_acc_no int not null,
with_amount number(20,2) not null);
alter table withdraw modify withdraw_at timestamp default current_timestamp not null;
alter table withdraw add constraint fk_userwith foreign key(user_acc_no) references userprofile(user_acc_no);
desc withdraw; 
delete from withdraw;

--login table--
create table login(
id int generated always as identity(start with 1 increment by 1),
username varchar(80),
logged_at timestamp default current_timestamp);

alter table login add constraint fk_userlogin foreign key(username) references usernamepass(username);
delete from login;
--insert usernamepass--
select * from usernamepass;
desc usernamepass;

commit;
--update usernamepass
--set role = 'admin'
--where id in 3;
--select role from usernamepass where username in 'suresh';
--select * from login;
--alter table login add role varchar(80);
--delete 
--from login;

desc userprofile;
select * from userprofile;
insert into usernamepass(username,password,role) values('Hari','hari@123','admin');
insert into userprofile(username,user_acc_no,balance,mob_no) values('Hari',1234567,1234,978967);
commit;
select * from withdraw;
desc deposit;
select * from deposit;
desc usernamepass;
select with_amount trans,withdraw_at trans_at from withdraw where user_acc_no in 123456 union all select dep_amount trans,dep_at trans_at from deposit where user_acc_no in 123456;
rollback;
select * from usernamepass;
select * from userprofile;
delete from usernamepass where id in 37;
commit;
update usernamepass
set role = 'user'
where id in 23;
select * from login;
select max(user_acc_no) from userprofile;
select max(user_pin) from userprofile;
select with_amount trans,withdraw_at trans_at from withdraw where user_acc_no in 12345678903 union all select dep_amount trans,dep_at trans_at from deposit where user_acc_no in 12345678903 order by trans_at desc;

select * from usernamepassword; 
select * from userprofile;
select * from withdraw;
select * from deposit;
select * from login;
select * from removedusers;
alter table deposit add money_transfer varchar(80);
desc  usernamepassword;
desc userprofile;
desc withdraw;
desc deposit;
desc login;
desc removedusers;

insert into userprofile(username,user_acc_no,mob_no,user_pin) values('Mani',12345678901,9789674835,1234);
commit;
insert into usernamepassword(username,password,role) values('Suresh','suresh@123','agent');
update userprofile
set balance = 500
where id in 24;
commit;
select * from userprofile;
select * from withdraw;
commit;
select *from(select with_amount trans,withdraw_at trans_at from withdraw where user_acc_no in 12345678901 union all select dep_amount trans,dep_at trans_at from deposit where user_acc_no in 12345678901  order by trans_at desc)where rownum <8;
   
create table removedusers(
id int generated always as identity(start with 1 increment by 1),
user_acc_no number(11) not null,
username varchar(80) not null,
last_balance number(20,2) not null,
mob_no number(10) not null,
user_pin number(4) not null,
acc_removed_at timestamp default current_timestamp);

select * from removedusers;
delete from removedusers;
commit;
drop table removedusers;


--Atm money table--

create table atm_money_management(
id int generated always as identity(start with 1 increment by 1),
money_deposited number(15,2) not null,
money_balance number(15,2) not null,
deposited_at timestamp default current_timestamp,
agent_name varchar(80) not null);

insert into atm_money_management(money_deposited,money_balance,agent_name) values(100000,88000,'suresh');
commit;

update atm_money_management
set money_balance = 200
where id in 84;

select * from atm_money_management;
select * from usernamepassword;


select * from usernamepassword; 
select * from userprofile;
select * from withdraw;
select * from deposit;
select * from login;
select * from removedusers;
select * from atm_money_management;


desc  usernamepassword;
desc userprofile;
desc withdraw;
desc deposit;
desc login;
desc removedusers;
desc atm_money_management;

select * from Alien;
                           
select substr(withdraw_at,1,17)
from withdraw;
                           
select * from userprofile;                  
                           
                           
   select * from userprofile where mob_no in 9789674835;                        
         



--account lock table--
create table invalidpinlock(
id int generated always as identity(start with 1 increment by 1),
username varchar2(80) not null,
acc_lockedat timestamp default current_timestamp,
acc_retriveat timestamp not null);

select * from invalidpinlock;
select substr(acc_created_at,13,2)from userprofile;

desc invalidpinlock;
select current_timestamp-acc_created_at from userprofile;
commit;
alter table invalidpinlock drop column acc_retriveat;
insert into invalidpinlock(username) values('Mani');
select (current_timestamp-acc_lockedat) from invalidpinlock where username in 'Mani';
select substr((current_timestamp-acc_lockedat),-12,2) from invalidpinlock where username in 'Mani';

delete
from invalidpinlock
where username in 'Mani';
commit;

select * from timestampdemo;
create table timestampdemo(
times timestamp not null);
insert into timestampdemo values('12-10-2021 02:03');
select times + (00000000000002) from timestampdemo;

select * from invalidpinlock;

select substr((current_timestamp),1,14) from dual;
select substr((current_timestamp),1,14)-substr((times),1,14) from timestampdemo; 
select substr((current_timestamp-acc_lockedat),-12,2) from invalidpinlock where username in 'Mani';

select current_timestamp-acc_lockedat from invalidpinlock;
select substr((current_timestamp-acc_lockedat),2,2) from invalidpinlock where username in 'Mani';
select substr((current_timestamp-acc_lockedat),5,2) from invalidpinlock where username in 'Mani';
select current_timestamp from dual;
select substr(current_timestamp,10,2) from dual;

select * from usernamepassword;
select * from atm_money_management;
select * from userprofile;
select * from withdraw;
select * from deposit;

select sum(dep_amount) from deposit where dep_at like '11-01-22%' and user_acc_no in 12345678901;
select sum(abs(with_amount)) from withdraw where withdraw_at like '11-01-22%' and user_acc_no in 12345678901;
select sysdate from dual;

select * from removedusers;
select sysdate from dual;
select sum(abs(with_amount)) from withdraw where withdraw_at like '11-01-22%' and user_acc_no in 12345678901;
select sysdate from dual;
select current_timestamp from dual;