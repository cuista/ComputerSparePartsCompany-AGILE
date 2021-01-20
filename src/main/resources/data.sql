insert into category(id, name)  values (UUID_SHORT(),'dummy_category');
insert into category(id, name)  values (UUID_SHORT(),'CPU');
insert into category(id, name)  values (UUID_SHORT(),'Graphic Card');
insert into category(id, name)  values (UUID_SHORT(),'RAM memory');
insert into category(id, name)  values (UUID_SHORT(),'Monitor');
insert into category(id, name)  values (UUID_SHORT(),'Case');
insert into category(id, name)  values (UUID_SHORT(),'Motherboard');
insert into category(id, name)  values (UUID_SHORT(),'Power Supply');
insert into category(id, name)  values (UUID_SHORT(),'HDD-SDD');
insert into category(id, name)  values (UUID_SHORT(),'Optical Drives');
insert into category(id, name)  values (UUID_SHORT(),'Input and Output Devices');


insert into customer(id, vat_id, email, name, password, phone_number, surname, username) values (UUID_SHORT(),28765246203,'Marti.Brunell@mail.com','Marti','Brunell','2103761416','Brunell','Marti');
insert into customer(id, vat_id, email, name, password, phone_number, surname, username) values (UUID_SHORT(),39128838671,'Tilly.Pelagias@mail.com','Tilly','Pelagias','1306200590','Pelagias','Tilly');
insert into customer(id, vat_id, email, name, password, phone_number, surname, username) values (UUID_SHORT(),26206678071,'Fanny.Simmonds@mail.com','Fanny','Simmonds','1749034222','Simmonds','Fanny');
insert into customer(id, vat_id, email, name, password, phone_number, surname, username) values (UUID_SHORT(),16946233236,'Mary.Cavan@mail.com','Mary','Cavan','2056287007','Cavan','Mary');
insert into customer(id, vat_id, email, name, password, phone_number, surname, username) values (UUID_SHORT(),19910856197,'Kimberley.Lilybelle@mail.com','Kimberley','Lilybelle','1644772896','Lilybelle','Kimberley');
insert into customer(id, vat_id, email, name, password, phone_number, surname, username) values (UUID_SHORT(),24068395699,'Ebonee.Ackerley@mail.com','Ebonee','Ackerley','1459955813','Ackerley','Ebonee');
insert into customer(id, vat_id, email, name, password, phone_number, surname, username) values (UUID_SHORT(),20780218656,'Donnie.Cristi@mail.com','Donnie','Cristi','1815289551','Cristi','Donnie');
insert into customer(id, vat_id, email, name, password, phone_number, surname, username) values (UUID_SHORT(),17634720451,'Arlina.Ethban@mail.com','Arlina','Ethban','1387989156','Ethban','Arlina');
insert into customer(id, vat_id, email, name, password, phone_number, surname, username) values (UUID_SHORT(),28938763185,'Tomasina.Charmine@mail.com','Tomasina','Charmine','2111813135','Charmine','Tomasina');
insert into customer(id, vat_id, email, name, password, phone_number, surname, username) values (UUID_SHORT(),15086351396,'Genevra.Munn@mail.com','Genevra','Munn','1246746549','Munn','Genevra');


insert into employee(id, email, firstname, hiring_date, lastname, password, telephone_number, username) values (UUID_SHORT(),'Rubie.Mitzi@mail.com','Rubie','1993-05-09','Mitzi','Mitzi','1796853502','Rubie');
insert into employee(id, email, firstname, hiring_date, lastname, password, telephone_number, username) values (UUID_SHORT(),'Aryn.Darbie@mail.com','Aryn','2001-01-30','Darbie','Darbie','1743013650','Aryn');
insert into employee(id, email, firstname, hiring_date, lastname, password, telephone_number, username) values (UUID_SHORT(),'Ricky.Garlinda@mail.com','Ricky','1996-07-16','Garlinda','Garlinda','2100490054','Ricky');
insert into employee(id, email, firstname, hiring_date, lastname, password, telephone_number, username) values (UUID_SHORT(),'Kristan.Orelee@mail.com','Kristan','1993-01-17','Orelee','Orelee','1542185787','Kristan');
insert into employee(id, email, firstname, hiring_date, lastname, password, telephone_number, username) values (UUID_SHORT(),'Jasmina.Tybald@mail.com','Jasmina','2011-05-01','Tybald','Tybald','1911160492','Jasmina');
insert into employee(id, email, firstname, hiring_date, lastname, password, telephone_number, username) values (UUID_SHORT(),'Shannah.Arley@mail.com','Shannah','2019-10-10','Arley','Arley','1358872900','Shannah');
insert into employee(id, email, firstname, hiring_date, lastname, password, telephone_number, username) values (UUID_SHORT(),'Harmonia.Janene@mail.com','Harmonia','2015-06-20','Janene','Janene','1673544265','Harmonia');
insert into employee(id, email, firstname, hiring_date, lastname, password, telephone_number, username) values (UUID_SHORT(),'Kial.Byrne@mail.com','Kial','2009-01-04','Byrne','Byrne','1614827388','Kial');
insert into employee(id, email, firstname, hiring_date, lastname, password, telephone_number, username) values (UUID_SHORT(),'Melisent.Kevon@mail.com','Melisent','2015-12-04','Kevon','Kevon','1937238905','Melisent');
insert into employee(id, email, firstname, hiring_date, lastname, password, telephone_number, username) values (UUID_SHORT(),'Maryellen.Sandye@mail.com','Maryellen','2015-04-01','Sandye','Sandye','1946634719','Maryellen');


insert into error_message(id, description, email, title, username) values (UUID_SHORT(),'Somedescription','Marti.Brunell@mail.com','Something','Marti');

insert into faq(id,title, description) values(UUID_SHORT(),'GenericTitle','blablabla');

insert into job_request(id, date, description, email, position, title, username) values(UUID_SHORT(),'2019-11-11','shish','job@email.com','Yyy','JobTitle','X');

/* TODO
insert into order_request(id, product_brand, product_model, product_quantity, production_house_id, warehouse_id) values (UUID_SHORT(),);
insert into order_request(id, product_brand, product_model, product_quantity, production_house_id, warehouse_id) values (UUID_SHORT(),);
insert into order_request(id, product_brand, product_model, product_quantity, production_house_id, warehouse_id) values (UUID_SHORT(),);
insert into order_request(id, product_brand, product_model, product_quantity, production_house_id, warehouse_id) values (UUID_SHORT(),);
insert into order_request(id, product_brand, product_model, product_quantity, production_house_id, warehouse_id) values (UUID_SHORT(),);
*/

insert into production_house(id, name) values (UUID_SHORT(),'Intel');
insert into production_house(id, name) values (UUID_SHORT(),'AMD');
insert into production_house(id, name) values (UUID_SHORT(),'Nvidia');
insert into production_house(id, name) values (UUID_SHORT(),'Asus');
insert into production_house(id, name) values (UUID_SHORT(),'Dell');
insert into production_house(id, name) values (UUID_SHORT(),'Samsung');
insert into production_house(id, name) values (UUID_SHORT(),'Sony');

/* TODO
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),);


insert into purchase_notice(id, collection_date, product_brand, product_model, quantity, customer_id, warehouse_id) values (UUID_SHORT(),);
insert into purchase_notice(id, collection_date, product_brand, product_model, quantity, customer_id, warehouse_id) values (UUID_SHORT(),);
insert into purchase_notice(id, collection_date, product_brand, product_model, quantity, customer_id, warehouse_id) values (UUID_SHORT(),);
insert into purchase_notice(id, collection_date, product_brand, product_model, quantity, customer_id, warehouse_id) values (UUID_SHORT(),);
insert into purchase_notice(id, collection_date, product_brand, product_model, quantity, customer_id, warehouse_id) values (UUID_SHORT(),);
insert into purchase_notice(id, collection_date, product_brand, product_model, quantity, customer_id, warehouse_id) values (UUID_SHORT(),);
insert into purchase_notice(id, collection_date, product_brand, product_model, quantity, customer_id, warehouse_id) values (UUID_SHORT(),);
insert into purchase_notice(id, collection_date, product_brand, product_model, quantity, customer_id, warehouse_id) values (UUID_SHORT(),);
insert into purchase_notice(id, collection_date, product_brand, product_model, quantity, customer_id, warehouse_id) values (UUID_SHORT(),);
insert into purchase_notice(id, collection_date, product_brand, product_model, quantity, customer_id, warehouse_id) values (UUID_SHORT(),);
insert into purchase_notice(id, collection_date, product_brand, product_model, quantity, customer_id, warehouse_id) values (UUID_SHORT(),);
insert into purchase_notice(id, collection_date, product_brand, product_model, quantity, customer_id, warehouse_id) values (UUID_SHORT(),);
insert into purchase_notice(id, collection_date, product_brand, product_model, quantity, customer_id, warehouse_id) values (UUID_SHORT(),);
insert into purchase_notice(id, collection_date, product_brand, product_model, quantity, customer_id, warehouse_id) values (UUID_SHORT(),);
insert into purchase_notice(id, collection_date, product_brand, product_model, quantity, customer_id, warehouse_id) values (UUID_SHORT(),);
insert into purchase_notice(id, collection_date, product_brand, product_model, quantity, customer_id, warehouse_id) values (UUID_SHORT(),);
insert into purchase_notice(id, collection_date, product_brand, product_model, quantity, customer_id, warehouse_id) values (UUID_SHORT(),);
insert into purchase_notice(id, collection_date, product_brand, product_model, quantity, customer_id, warehouse_id) values (UUID_SHORT(),);
insert into purchase_notice(id, collection_date, product_brand, product_model, quantity, customer_id, warehouse_id) values (UUID_SHORT(),);
insert into purchase_notice(id, collection_date, product_brand, product_model, quantity, customer_id, warehouse_id) values (UUID_SHORT(),);
insert into purchase_notice(id, collection_date, product_brand, product_model, quantity, customer_id, warehouse_id) values (UUID_SHORT(),);
insert into purchase_notice(id, collection_date, product_brand, product_model, quantity, customer_id, warehouse_id) values (UUID_SHORT(),);
insert into purchase_notice(id, collection_date, product_brand, product_model, quantity, customer_id, warehouse_id) values (UUID_SHORT(),);
insert into purchase_notice(id, collection_date, product_brand, product_model, quantity, customer_id, warehouse_id) values (UUID_SHORT(),);
insert into purchase_notice(id, collection_date, product_brand, product_model, quantity, customer_id, warehouse_id) values (UUID_SHORT(),);


insert into purchase(id, date, total_price, customer_id, warehouse_id) values (UUID_SHORT(),);
insert into purchase(id, date, total_price, customer_id, warehouse_id) values (UUID_SHORT(),);
insert into purchase(id, date, total_price, customer_id, warehouse_id) values (UUID_SHORT(),);
insert into purchase(id, date, total_price, customer_id, warehouse_id) values (UUID_SHORT(),);
insert into purchase(id, date, total_price, customer_id, warehouse_id) values (UUID_SHORT(),);
insert into purchase(id, date, total_price, customer_id, warehouse_id) values (UUID_SHORT(),);
insert into purchase(id, date, total_price, customer_id, warehouse_id) values (UUID_SHORT(),);
insert into purchase(id, date, total_price, customer_id, warehouse_id) values (UUID_SHORT(),);
insert into purchase(id, date, total_price, customer_id, warehouse_id) values (UUID_SHORT(),);
insert into purchase(id, date, total_price, customer_id, warehouse_id) values (UUID_SHORT(),);
insert into purchase(id, date, total_price, customer_id, warehouse_id) values (UUID_SHORT(),);
insert into purchase(id, date, total_price, customer_id, warehouse_id) values (UUID_SHORT(),);
insert into purchase(id, date, total_price, customer_id, warehouse_id) values (UUID_SHORT(),);
insert into purchase(id, date, total_price, customer_id, warehouse_id) values (UUID_SHORT(),);
insert into purchase(id, date, total_price, customer_id, warehouse_id) values (UUID_SHORT(),);
insert into purchase(id, date, total_price, customer_id, warehouse_id) values (UUID_SHORT(),);
insert into purchase(id, date, total_price, customer_id, warehouse_id) values (UUID_SHORT(),);
insert into purchase(id, date, total_price, customer_id, warehouse_id) values (UUID_SHORT(),);
insert into purchase(id, date, total_price, customer_id, warehouse_id) values (UUID_SHORT(),);
insert into purchase(id, date, total_price, customer_id, warehouse_id) values (UUID_SHORT(),);


insert into review(id, brand, model, rate, text, title, customer_id) values (UUID_SHORT(),);
*/

insert into warehouse(id, city, opening_hours, province, region, street) values (UUID_SHORT(),'Siem Reap',23,'OS','Bahamas','Johnson Street 35');
insert into warehouse(id, city, opening_hours, province, region, street) values (UUID_SHORT(),'Charlotte',17,'KA','Angola','Hodgson Street 123B');
insert into warehouse(id, city, opening_hours, province, region, street) values (UUID_SHORT(),'Mandurah',4,'MA','Belarus','Volkova Avenue 367U');
insert into warehouse(id, city, opening_hours, province, region, street) values (UUID_SHORT(),'Freetown',16,'PA','Caledonia','Marion Rue 46');
insert into warehouse(id, city, opening_hours, province, region, street) values (UUID_SHORT(),'Birkirkara',21,'HY','Faroe Islands','Koreon Street 98');
insert into warehouse(id, city, opening_hours, province, region, street) values (UUID_SHORT(),'Sri Jayawardenapura-Kotte',18,'NE','Jordan','Via Maestro 56');