create database DATA_STUDENT;

use DATA_STUDENT;

create table STUDENT(
                        ID INT PRIMARY KEY,
                        NAME VARCHAR(50),
                        AGE INT,
                        CITY VARCHAR(50)
);

select * from STUDENT;