--Data for product
insert into product (name, price, stock) values ('ABC', 2300.00, 50);
insert into product (name, price, stock) values ('CVC', 1300.00, 50);
insert into product (name, price, stock) values ('DAS', 20000.00, 50);

--Joiin table for product & Company
insert into product_company (product_id, company_id) values (1, 1);
insert into product_company (product_id, company_id) values (2, 1);