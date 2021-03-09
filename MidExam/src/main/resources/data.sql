--Insert roles-- 
insert into role (name) values ('ROLE_ADMIN');
insert into role (name) values ('ROLE_USER');

--Insert into User

--admin user1 --
insert into user (username, password, active, email) values ('admin1', '$2a$10$otMn8Xre2SYZm.cZwa4q8e7hq3Y7/gkGoD9FOMvVmRvPr75p3POLm', true, 'admin1@ait.asia');
insert into user_roles (users_id, roles_id) values (1, 1);

--admin user2
insert into user (username, password, active, email) values ('admin2', '$2a$10$otMn8Xre2SYZm.cZwa4q8e7hq3Y7/gkGoD9FOMvVmRvPr75p3POLm', true, 'admin2@ait.asia');
insert into user_roles (users_id, roles_id) values (2, 1);

-- normal user1 -- 
insert into user (username, password, active, email) values ('normal1', '$2a$10$otMn8Xre2SYZm.cZwa4q8e7hq3Y7/gkGoD9FOMvVmRvPr75p3POLm', true, 'normal1@ait.asia');
insert into user_roles (users_id, roles_id) values (3, 2);

-- normal user 2-- 
insert into user (username, password, active, email) values ('normal2', '$2a$10$otMn8Xre2SYZm.cZwa4q8e7hq3Y7/gkGoD9FOMvVmRvPr75p3POLm', true, 'normal2@ait.asia');
insert into user_roles (users_id, roles_id) values (4, 2);


---insert data to employee
insert into Employee (salary, birthday, Level, name, user_id) values (25000.00, parsedatetime('17-09-2000', 'dd-MM-yyyy'), 'C1' , 'Peter', 1);
insert into Employee (salary, birthday, Level, name, user_id) values (50000.00, parsedatetime('12-02-1992', 'dd-MM-yyyy'), 'C2' , 'Peter', 2);
insert into Employee (salary, birthday, Level, name, user_id) values (30000.00, parsedatetime('14-01-2002', 'dd-MM-yyyy'), 'C2' , 'Peter', 3);
insert into Employee (salary, birthday, Level, name, user_id) values (75000.00, parsedatetime('17-02-1996', 'dd-MM-yyyy'), 'C3' , 'Peter', 4);

--Insert into address
insert into address (city, house_no, zipcode, emp_user_id) values ('Bangkok', '12/6', '10220', 1);
insert into address (city, house_no, zipcode, emp_user_id) values ('London', '30/7', '12220', 2);