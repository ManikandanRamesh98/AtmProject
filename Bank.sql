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
procedure removelogindetails(username1 login.username%type,res out Integer);
end bank;
/
select * from withdraw;
select * from userprofile;
select * from usernamepassword;
select * from deposit;
select * from login;
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


--remove deposit--Deposit 
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
procedure removelogindetails(username1 login.username%type,res out Integer) is
begin
delete from login where username in username1;

if sql%rowcount > 0 then
res := sql%rowcount;
end if;

exception
when others then res := 0;

end removelogindetails;
end;
/

select max(user_acc_no)
from userprofile;