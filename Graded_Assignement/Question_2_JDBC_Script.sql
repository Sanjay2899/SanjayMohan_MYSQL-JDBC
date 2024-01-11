create database GL;
use GL;
create table employee(Id int primary key,
Name varchar(50) NOT NULL,
Email_Id varchar(50) NOT NULL,
Phone_Number varchar(10));
desc employee;
ALTER TABLE employee
MODIFY Email_Id VARCHAR(50) NOT NULL;
select * from employee;


