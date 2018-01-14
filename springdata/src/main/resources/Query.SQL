CREATE SCHEMA PAYROLL;

 

create table PAYROLL.Location(ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),

                        STATE varchar(20), COUNTRY varchar(20), PRIMARY KEY(ID) )

                      

 create table PAYROLL.Manufacturer(ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),

                        name varchar(20), foundedDate DATE, averageYearlySales DOUBLE, LOCATION_ID INTEGER not null, PRIMARY KEY(ID),

                       FOREIGN KEY(LOCATION_ID)

                        REFERENCES PAYROLL.LOCATION(ID))

                      

 create table PAYROLL.MODELTYPE(ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),

                        name varchar(20), PRIMARY KEY(ID))

          

 create table PAYROLL.MODEL(ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),

                        name varchar(20), price DOUBLE, frets INTEGER, woodType VARCHAR(20), yearFirstMade DATE, PRIMARY KEY(ID),

                       status varchar(10),

                       create_by varchar(20),

                       created_date timestamp,

                       updated_by varchar(20),

                       updated_date timestamp,

                       MANUFACTURER_ID INTEGER not null,

                       FOREIGN KEY(MANUFACTURER_ID) REFERENCES PAYROLL.Manufacturer(ID),

                       MODELTYPE_ID INTEGER not null,

                       FOREIGN KEY(MODELTYPE_ID) REFERENCES PAYROLL.MODELTYPE(ID))

                      

 drop table PAYROLL.MODEL

 

--delete from PAYROLL.MANUFACTURER;

--delete from PAYROLL.MODEL;

--delete from payroll.location;

--delete from PAYROLL.MODELTYPE;

 

--insert into payroll.location(state, country) values(null, 'India')

--insert into payroll.location(state, country) values('Rajesthan', 'India')

--insert into payroll.MODELTYPE(name) values('Electric')

 

--update PAYROLL.MODEL set MODELTYPE_ID=5 where id=9

 

 

select * from payroll.location

select * from PAYROLL.MANUFACTURER

select * from PAYROLL.MODEL

select * from PAYROLL.MODELTYPE

 

 

 

--update PAYROLL.LOCATION set State='Delhi' where id=11

 

--update PAYROLL.MANUFACTURER set Location_ID=12 where id=8