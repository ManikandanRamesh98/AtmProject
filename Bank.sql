create or replace package bank as
procedure getrole(username1 in usernamepassword.username%type,password1 in usernamepassword.password%type,role1 out usernamepassword.role%type);
procedure passchange(password1 in usernamepassword.password%type,username1 in usernamepassword.username%type,res out Integer);
procedure insertusernamepass(username1 in usernamepassword.username%type,password1 in usernamepassword.password%type,role1 in usernamepassword.role%type,res out Integer);
procedure removeuser(username1 in usernamepassword.username%type,res out Integer);
procedure getbal(username1 in userprofile.username%type,bal out Integer);
procedure updatebal(bal in userprofile.balance%type,username1 in userprofile.username%type,res out Integer);
procedure getaccno(username1 in userprofile.username%type,accno out userprofile.user_acc_no%type); 
procedure insertuserprofile(username1 in userprofile.username%type,accno in userprofile.user_acc_no%type,mobno in userprofile.mob_no%type,pin in userprofile.user_pin%type,res out Integer);
procedure removeuserprofile(accno in userprofile.user_acc_no%type,id1 in userprofile.id%type,res out Integer);
procedure getusermaxaccno(accno out userprofile.user_acc_no%type);
procedure getusermaxpin(pin out userprofile.user_pin%type);
procedure getuserpin(username1 in usernamepassword.username%type,pin out userprofile.user_pin%type); 
procedure moneytransferbal(username1 in usernamepassword.username%type,accno in userprofile.user_acc_no%type,bal out userprofile.balance%type);
procedure insertwithdraw(accno in withdraw.user_acc_no%type,amount in  withdraw.with_amount%type,moneytransfname in withdraw.money_transfer%type,res out Integer);
procedure removewithdraw(accno in withdraw.user_acc_no%type,res out Integer);
procedure insertdeposit(accno in deposit.user_acc_no%type,amount in  deposit.dep_amount%type,moneytransfname in deposit.money_transfer%type,res out Integer);
procedure removedeposit(accno in deposit.user_acc_no%type,res out Integer);
procedure removelogindetails(username1 in login.username%type,res out Integer);
procedure insertlogindetails(username1 in login.username%type,role1 in login.role%type,res out Integer);
procedure depositmoneyagent(moneydep in atm_money_management.money_deposited%type,moneybal in atm_money_management.money_deposited%type,agentname1 in atm_money_management.agent_name%type,res out Integer);
procedure previousbalagent(prevbal out Integer);
procedure updatebalagent(moneybal in atm_money_management.money_balance%type,res out integer);
procedure insertremovedusers(accno in removedusers.user_acc_no%type,username1 in removedusers.username%type,lastbal in removedusers.last_balance%type,mobno in removedusers.mob_no%type,pin in removedusers.user_pin%type,res out integer); 
end bank;
/

select * from withdraw;
select * from userprofile;
select * from usernamepassword;
select * from deposit;
select * from login;
select * from atm_money_management;
select * from removedusers;





--package body--
create or replace package body bank as
procedure getrole(username1 in usernamepassword.username%type,password1 in usernamepassword.password%type,role1  out usernamepassword.role%type) is
begin
select role into role1 
from usernamepassword 
where username in username1 and password in password1;

exception
when no_data_found then role1 := 'null'; 

end getrole;

--pinchange--
procedure passchange(password1 in usernamepassword.password%type,username1 in usernamepassword.username%type,res out Integer) is
begin
update usernamepassword set password = password1 where username in username1;

if sql%rowcount > 0 then 
res := sql%rowcount;
end if;
commit;
exception
when others then res := 0;
end passchange;


--insert username password--
procedure insertusernamepass(username1 in usernamepassword.username%type,password1 in usernamepassword.password%type,role1 in usernamepassword.role%type,res out Integer)is
begin
insert into usernamepassword(username,password,role) values(username1,password1,role1);
if sql%rowcount > 0 then
res := sql%rowcount;
end if;
commit;

exception
when others then res := 0;

end insertusernamepass;

--remove User--usernamepassword--

procedure removeuser(username1 in usernamepassword.username%type,res out Integer) is
begin
delete from usernamepassword where username in username1;

if sql%rowcount > 0 then
 res := sql%rowcount;
end if;
commit;

exception
when others then res := 0;

end removeuser;

--get bal userprofile---
procedure getbal(username1 in userprofile.username%type,bal out Integer) is
begin
select balance into bal 
from userprofile 
where username in username1;

exception
when others then bal := -1;

end getbal;

--update balance userprofile--
procedure updatebal(bal in userprofile.balance%type,username1 in userprofile.username%type,res out Integer) is
begin
update userprofile set balance = bal where username in username1;

if sql%rowcount > 0 then 
res := sql%rowcount;
end if;
commit;

exception
when others then res := 0;

end updatebal;


--get account number userprofile--
procedure getaccno(username1 in userprofile.username%type,accno out userprofile.user_acc_no%type) is
begin
select user_acc_no into accno
from userprofile 
where username in username1;

exception
when others then accno := -1;

end getaccno;

--insert userprofile data--
procedure insertuserprofile(username1 in userprofile.username%type,accno in userprofile.user_acc_no%type,mobno in userprofile.mob_no%type,pin in userprofile.user_pin%type,res out Integer) is
begin
insert into userprofile(username,user_acc_no,mob_no,user_pin) values(username1,accno,mobno,pin);

if sql%rowcount > 0 then 
res := sql%rowcount;
end if;
commit;
exception
when others then res := 0;

end insertuserprofile;

--Remove Account---Userprofile
procedure removeuserprofile(accno in userprofile.user_acc_no%type,id1 in userprofile.id%type,res out Integer)is
begin
delete from userprofile where user_acc_no in accno and id in id1;

if sql%rowcount > 0 then
res := sql%rowcount;
end if;

exception
when others then res := 0;

end removeuserprofile;

--get max accno--Userprofile--
procedure getusermaxaccno(accno out userprofile.user_acc_no%type) is
begin
select max(user_acc_no) into accno
from userprofile;

exception
when no_data_found then accno := -1;

end getusermaxaccno;

--get user max pin--Userprofile

procedure getusermaxpin(pin out userprofile.user_pin%type)is
begin
select max(user_pin) into pin
from userprofile;

exception 
when no_data_found then pin := -1;

end getusermaxpin;


--get userpin--Userprofile:

procedure getuserpin(username1 in usernamepassword.username%type,pin out userprofile.user_pin%type) is
begin
select user_pin Into pin
from userprofile 
where username in username1;

exception 
when no_data_found then pin := -1;

end getuserpin;

--moneytransfer getbal--Userprofile--
procedure moneytransferbal(username1 in usernamepassword.username%type,accno in userprofile.user_acc_no%type,bal out userprofile.balance%type)is
begin 
select balance into bal
from userprofile 
where username in username1 and user_acc_no in accno;

exception
when no_data_found then bal := -1;

end moneytransferbal;

--insert withdraw--Withdraw
procedure insertwithdraw(accno in withdraw.user_acc_no%type,amount in  withdraw.with_amount%type,moneytransfname in withdraw.money_transfer%type,res out Integer)is
begin
insert into withdraw(user_acc_no,with_amount,money_transfer) values(accno,amount,moneytransfname);

if sql%rowcount > 0 then
res := sql%rowcount;
end if;

exception 
when others then res := 0;

end insertwithdraw;

--remove account--Withdraw--
procedure removewithdraw(accno in withdraw.user_acc_no%type,res out Integer)is
begin
delete 
from withdraw 
where user_acc_no in accno;

if sql%rowcount > 0 then
res := sql%rowcount;
end if;

exception
when others then res := 0;

end removewithdraw;

--insert deposit data---
procedure insertdeposit(accno in deposit.user_acc_no%type,amount in  deposit.dep_amount%type,moneytransfname in deposit.money_transfer%type,res out Integer)is
begin
insert into deposit(user_acc_no,dep_amount,money_transfer) values(accno,amount,moneytransfname);

if sql%rowcount > 0 then 
res := sql%rowcount;
end if;

exception
when others then res := 0;

end insertdeposit;


--remove deposit--Deposit --

procedure removedeposit(accno in deposit.user_acc_no%type,res out Integer)is
begin
delete from deposit where user_acc_no in accno;

if sql%rowcount > 0 then
res := sql%rowcount;
end if;

exception
when others then res := 0;

end removedeposit;

--remove login details--Login table
procedure removelogindetails(username1 in login.username%type,res out Integer) is
begin
delete from login where username in username1;

if sql%rowcount > 0 then
res := sql%rowcount;
end if;

exception
when others then res := 0;

end removelogindetails;

--insert login details--Login
procedure insertlogindetails(username1 in login.username%type,role1 in login.role%type,res out Integer)is
begin
insert into login(username,role) values(username1,role1);

if sql%rowcount > 0 then
res := sql%rowcount;
end if;

exception
when others then res := 0;

end insertlogindetails;

--deposit money agent -- Atm money management
procedure depositmoneyagent(moneydep in atm_money_management.money_deposited%type,moneybal in atm_money_management.money_deposited%type,agentname1 in atm_money_management.agent_name%type,res out Integer)is
begin
insert into atm_money_management(money_deposited,money_balance,agent_name) values(moneydep,moneybal,agentname1);

if sql%rowcount > 0 then
res := sql%rowcount;
end if;

exception
when others then res := 0;

end depositmoneyagent;

--previous balance--atm money management--
procedure previousbalagent(prevbal out Integer)is
begin
select money_balance into prevbal
from atm_money_management
where id in (select max(id) from atm_money_management);

exception
when others then prevbal := -1;

end previousbalagent;

--update balance agent--atm_money_management
procedure updatebalagent(moneybal in atm_money_management.money_balance%type,res out integer) is
begin
update atm_money_management set money_balance = moneybal where id in (select max(id) from atm_money_management);

if sql%rowcount > 0 then 
res := sql%rowcount;
end if;

commit;

exception
when others then res := 0;

end updatebalagent;

--insert removed users---Removed Users
procedure insertremovedusers(accno in removedusers.user_acc_no%type,username1 in removedusers.username%type,lastbal in removedusers.last_balance%type,mobno in removedusers.mob_no%type,pin in removedusers.user_pin%type,res out integer)is
begin
insert into removedusers(user_acc_no,username,last_balance,mob_no,user_pin) values(accno,username1,lastbal,mobno,pin);

if sql%rowcount > 0 then
res := sql%rowcount;
end if;

exception
when others then res := 0;

end insertremovedusers;
end;
/



select * from atm_money_management;
desc atm_money_management;

update atm_money_management
set money_balance = 1500
where id in 21;

commit;

set serveroutput on;
declare 
res integer;
begin
bank.previousbalagent(res);
dbms_output.put_line(res);
end;
/

create table balancedemo(
id int generated always as identity(start with 1 increment by 1),
bal int);


create table transcdemo(
id int generated always as identity(start with 1 increment by 1),
trans int);

--triggers--

create or replace trigger baltrigger 
after update on balancedemo for each row
declare
transi integer;
begin
 transi := (:new.bal - :old.bal); 
insert into transcdemo(trans) values(transi);
end;
/

insert into balancedemo(bal) values(200);
insert into balancedemo(bal) values(400);

commit;
delete 
from transcdemo;
update balancedemo
set bal = 300
where id in 1;
select * from balancedemo;
select * from transcdemo;