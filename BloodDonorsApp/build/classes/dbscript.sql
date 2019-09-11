

Create table BloodDonors(Login_ID Varchar2(20) Primary Key,Password Varchar2(15),MobileNo number(10),BloodGroup varchar2(10));

Create Table Address(Donor_ID Varchar2(20) references  BloodDonors(Login_ID), State Varchar2(10),City  Varchar2(10));

Insert into BloodDonors(Login_ID,Password,MobileNo,BloodGroup) values('Akash','123',9666381576,'B+');
Insert into BloodDonors(Login_ID,Password,MobileNo,BloodGroup) values('Sai','123',9666381577,'O+');
Insert into BloodDonors(Login_ID,Password,MobileNo,BloodGroup) values('Kiran','123',9666381578,'AB+');
Insert into BloodDonors(Login_ID,Password,MobileNo,BloodGroup) values('Srinu','123',9666381579,'A+');

Insert into Address(Donor_ID,State,City) values('Akash','TG','Hyderabad');
Insert into Address(Donor_ID,State,City) values('Sai','TG','Hyderabad');
Insert into Address(Donor_ID,State,City) values('Kiran','Karnataka','Banglore');
Insert into Address(Donor_ID,State,City) values('Srinu','Karnataka','Banglore');

commit;

