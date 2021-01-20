
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


insert into warehouse(id, city, opening_hours, province, region, street) values (UUID_SHORT(),'Siem Reap',23,'OS','Bahamas','Johnson Street 35');
insert into warehouse(id, city, opening_hours, province, region, street) values (UUID_SHORT(),'Charlotte',17,'KA','Angola','Hodgson Street 123B');
insert into warehouse(id, city, opening_hours, province, region, street) values (UUID_SHORT(),'Mandurah',4,'MA','Belarus','Volkova Avenue 367U');
insert into warehouse(id, city, opening_hours, province, region, street) values (UUID_SHORT(),'Freetown',16,'PA','Caledonia','Marion Rue 46');
insert into warehouse(id, city, opening_hours, province, region, street) values (UUID_SHORT(),'Birkirkara',21,'HY','Faroe Islands','Koreon Street 98');
insert into warehouse(id, city, opening_hours, province, region, street) values (UUID_SHORT(),'Sri Jayawardenapura-Kotte',18,'NE','Jordan','Via Maestro 56');

insert into production_house(id, name) values (UUID_SHORT(),'Intel');
insert into production_house(id, name) values (UUID_SHORT(),'AMD');
insert into production_house(id, name) values (UUID_SHORT(),'Nvidia');
insert into production_house(id, name) values (UUID_SHORT(),'Asus');
insert into production_house(id, name) values (UUID_SHORT(),'Dell');
insert into production_house(id, name) values (UUID_SHORT(),'Samsung');
insert into production_house(id, name) values (UUID_SHORT(),'Sony');



insert into order_request(id, product_brand, product_model, product_quantity, production_house_id, warehouse_id) values (UUID_SHORT(),'NVidia GEForce','GTX 1080 Ti',24,99087800309121113,99087800309121105);
insert into order_request(id, product_brand, product_model, product_quantity, production_house_id, warehouse_id) values (UUID_SHORT(),'Intel','Core i7-4940MX',30,99087800309121111,99087800309121107);
insert into order_request(id, product_brand, product_model, product_quantity, production_house_id, warehouse_id) values (UUID_SHORT(),'AMD','Ryzen 5 1600',15,99087800309121112,99087800309121110);
insert into order_request(id, product_brand, product_model, product_quantity, production_house_id, warehouse_id) values (UUID_SHORT(),'NVidia GEForce','GTX 1080',12,99087800309121113,99087800309121105);
insert into order_request(id, product_brand, product_model, product_quantity, production_house_id, warehouse_id) values (UUID_SHORT(),'Intel','Core i7 8700K',28,99087800309121111,99087800309121106);



insert into purchase_notice(id, collection_date, product_brand, product_model, quantity, customer_id, warehouse_id) values (UUID_SHORT(),'2020-03-31','NVidia GEForce','GTX 1080 Ti',99,99087800309121082,99087800309121105);
insert into purchase_notice(id, collection_date, product_brand, product_model, quantity, customer_id, warehouse_id) values (UUID_SHORT(),'2020-08-18','NVidia GEForce','GTX 1080 Ti',62,99087800309121083,99087800309121106);
insert into purchase_notice(id, collection_date, product_brand, product_model, quantity, customer_id, warehouse_id) values (UUID_SHORT(),'2020-04-05','NVidia GEForce','GTX 1080 Ti',35,99087800309121084,99087800309121107);
insert into purchase_notice(id, collection_date, product_brand, product_model, quantity, customer_id, warehouse_id) values (UUID_SHORT(),'2020-07-05','NVidia GEForce','GTX 1080 Ti',39,99087800309121085,99087800309121108);
insert into purchase_notice(id, collection_date, product_brand, product_model, quantity, customer_id, warehouse_id) values (UUID_SHORT(),'2020-03-13','NVidia GEForce','GTX 1080 Ti',68,99087800309121086,99087800309121109);
insert into purchase_notice(id, collection_date, product_brand, product_model, quantity, customer_id, warehouse_id) values (UUID_SHORT(),'2020-05-22','NVidia GEForce','GTX 1080 Ti',60,99087800309121087,99087800309121110);
insert into purchase_notice(id, collection_date, product_brand, product_model, quantity, customer_id, warehouse_id) values (UUID_SHORT(),'2020-10-07','NVidia GEForce','GTX 1080 Ti',81,99087800309121088,99087800309121105);
insert into purchase_notice(id, collection_date, product_brand, product_model, quantity, customer_id, warehouse_id) values (UUID_SHORT(),'2020-03-05','NVidia GEForce','GTX 1080 Ti',27,99087800309121089,99087800309121106);
insert into purchase_notice(id, collection_date, product_brand, product_model, quantity, customer_id, warehouse_id) values (UUID_SHORT(),'2020-01-04','NVidia GEForce','GTX 1080 Ti',62,99087800309121090,99087800309121107);
insert into purchase_notice(id, collection_date, product_brand, product_model, quantity, customer_id, warehouse_id) values (UUID_SHORT(),'2020-05-19','NVidia GEForce','GTX 1080 Ti',58,99087800309121091,99087800309121108);
insert into purchase_notice(id, collection_date, product_brand, product_model, quantity, customer_id, warehouse_id) values (UUID_SHORT(),'2020-07-22','Intel','Core i7-4940MX',96,99087800309121082,99087800309121109);
insert into purchase_notice(id, collection_date, product_brand, product_model, quantity, customer_id, warehouse_id) values (UUID_SHORT(),'2020-10-22','Intel','Core i7-4940MX',28,99087800309121083,99087800309121110);
insert into purchase_notice(id, collection_date, product_brand, product_model, quantity, customer_id, warehouse_id) values (UUID_SHORT(),'2020-06-01','Intel','Core i7-4940MX',83,99087800309121084,99087800309121105);
insert into purchase_notice(id, collection_date, product_brand, product_model, quantity, customer_id, warehouse_id) values (UUID_SHORT(),'2020-06-18','Intel','Core i7-4940MX',64,99087800309121085,99087800309121106);
insert into purchase_notice(id, collection_date, product_brand, product_model, quantity, customer_id, warehouse_id) values (UUID_SHORT(),'2020-10-06','Intel','Core i7-4940MX',66,99087800309121086,99087800309121107);
insert into purchase_notice(id, collection_date, product_brand, product_model, quantity, customer_id, warehouse_id) values (UUID_SHORT(),'2020-05-03','Intel','Core i7-4940MX',63,99087800309121087,99087800309121108);
insert into purchase_notice(id, collection_date, product_brand, product_model, quantity, customer_id, warehouse_id) values (UUID_SHORT(),'2020-06-10','Intel','Core i7-4940MX',67,99087800309121088,99087800309121109);
insert into purchase_notice(id, collection_date, product_brand, product_model, quantity, customer_id, warehouse_id) values (UUID_SHORT(),'2020-10-17','Intel','Core i7-4940MX',56,99087800309121089,99087800309121110);
insert into purchase_notice(id, collection_date, product_brand, product_model, quantity, customer_id, warehouse_id) values (UUID_SHORT(),'2020-02-27','Intel','Core i7-4940MX',36,99087800309121090,99087800309121105);
insert into purchase_notice(id, collection_date, product_brand, product_model, quantity, customer_id, warehouse_id) values (UUID_SHORT(),'2020-07-26','Intel','Core i7-4940MX',90,99087800309121091,99087800309121106);
insert into purchase_notice(id, collection_date, product_brand, product_model, quantity, customer_id, warehouse_id) values (UUID_SHORT(),'2020-04-25','Sandisk','SATA III',90,99087800309121082,99087800309121107);
insert into purchase_notice(id, collection_date, product_brand, product_model, quantity, customer_id, warehouse_id) values (UUID_SHORT(),'2020-03-24','Sandisk','SATA III',74,99087800309121083,99087800309121108);
insert into purchase_notice(id, collection_date, product_brand, product_model, quantity, customer_id, warehouse_id) values (UUID_SHORT(),'2020-01-23','Sandisk','SATA III',24,99087800309121084,99087800309121109);
insert into purchase_notice(id, collection_date, product_brand, product_model, quantity, customer_id, warehouse_id) values (UUID_SHORT(),'2020-10-12','Sandisk','SATA III',34,99087800309121085,99087800309121110);
insert into purchase_notice(id, collection_date, product_brand, product_model, quantity, customer_id, warehouse_id) values (UUID_SHORT(),'2020-10-31','Sandisk','SATA III',78,99087800309121086,99087800309121105);



insert into purchase(id, date, total_price, customer_id, warehouse_id) values (UUID_SHORT(),'2019-09-25',420.58,99087800309121082,99087800309121105);
insert into purchase(id, date, total_price, customer_id, warehouse_id) values (UUID_SHORT(),'2013-06-11',20.24,99087800309121083,99087800309121106);
insert into purchase(id, date, total_price, customer_id, warehouse_id) values (UUID_SHORT(),'2013-08-31',325.3,99087800309121084,99087800309121107);
insert into purchase(id, date, total_price, customer_id, warehouse_id) values (UUID_SHORT(),'2008-11-19',939.99,99087800309121085,99087800309121108);
insert into purchase(id, date, total_price, customer_id, warehouse_id) values (UUID_SHORT(),'2000-07-23',594.48,99087800309121086,99087800309121109);
insert into purchase(id, date, total_price, customer_id, warehouse_id) values (UUID_SHORT(),'2000-07-25',882.29,99087800309121087,99087800309121110);
insert into purchase(id, date, total_price, customer_id, warehouse_id) values (UUID_SHORT(),'2005-02-28',546.4,99087800309121088,99087800309121105);
insert into purchase(id, date, total_price, customer_id, warehouse_id) values (UUID_SHORT(),'2002-06-27',930.92,99087800309121089,99087800309121106);
insert into purchase(id, date, total_price, customer_id, warehouse_id) values (UUID_SHORT(),'2015-09-19',657.79,99087800309121090,99087800309121107);
insert into purchase(id, date, total_price, customer_id, warehouse_id) values (UUID_SHORT(),'2014-06-01',734.22,99087800309121091,99087800309121108);
insert into purchase(id, date, total_price, customer_id, warehouse_id) values (UUID_SHORT(),'2001-07-02',177.67,99087800309121082,99087800309121109);
insert into purchase(id, date, total_price, customer_id, warehouse_id) values (UUID_SHORT(),'2016-02-09',842.98,99087800309121083,99087800309121110);
insert into purchase(id, date, total_price, customer_id, warehouse_id) values (UUID_SHORT(),'2002-02-13',633.76,99087800309121084,99087800309121105);
insert into purchase(id, date, total_price, customer_id, warehouse_id) values (UUID_SHORT(),'2019-05-03',534.31,99087800309121085,99087800309121106);
insert into purchase(id, date, total_price, customer_id, warehouse_id) values (UUID_SHORT(),'2007-07-26',103.49,99087800309121086,99087800309121107);
insert into purchase(id, date, total_price, customer_id, warehouse_id) values (UUID_SHORT(),'2007-06-13',113.56,99087800309121087,99087800309121108);
insert into purchase(id, date, total_price, customer_id, warehouse_id) values (UUID_SHORT(),'2009-05-06',130.78,99087800309121088,99087800309121109);
insert into purchase(id, date, total_price, customer_id, warehouse_id) values (UUID_SHORT(),'2008-03-09',101.23,99087800309121089,99087800309121110);
insert into purchase(id, date, total_price, customer_id, warehouse_id) values (UUID_SHORT(),'2004-08-09',129.78,99087800309121090,99087800309121105);
insert into purchase(id, date, total_price, customer_id, warehouse_id) values (UUID_SHORT(),'2010-06-04',111.23,99087800309121091,99087800309121106);



insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),'NVidia GEForce','Nvidia graphic card','https://images-na.ssl-images-amazon.com/images/I/71sN1G2-16L._AC_SX466_.jpg','GTX 1080 Ti',181.46,99087800309121073,99087800309121123,99087800309121153,99087800309121105);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),'NVidia GEForce','Nvidia graphic card','https://images-na.ssl-images-amazon.com/images/I/71sN1G2-16L._AC_SX466_.jpg','GTX 1080 Ti',181.46,99087800309121073,null,99087800309121156,99087800309121105);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),'NVidia GEForce','Nvidia graphic card','https://images-na.ssl-images-amazon.com/images/I/71sN1G2-16L._AC_SX466_.jpg','GTX 1080 Ti',181.46,99087800309121073,99087800309121123,null,99087800309121105);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),'NVidia GEForce','Nvidia graphic card','https://images-na.ssl-images-amazon.com/images/I/71sN1G2-16L._AC_SX466_.jpg','GTX 1080 Ti',181.46,99087800309121073,null,99087800309121156,99087800309121105);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),'NVidia GEForce','Nvidia graphic card','https://images-na.ssl-images-amazon.com/images/I/71sN1G2-16L._AC_SX466_.jpg','GTX 1080 Ti',181.46,99087800309121073,99087800309121123,99087800309121153,99087800309121105);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),'NVidia GEForce','Nvidia graphic card','https://images-na.ssl-images-amazon.com/images/I/71sN1G2-16L._AC_SX466_.jpg','GTX 1080 Ti',181.46,99087800309121073,null,99087800309121156,99087800309121105);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),'NVidia GEForce','Nvidia graphic card','https://images-na.ssl-images-amazon.com/images/I/71sN1G2-16L._AC_SX466_.jpg','GTX 1080 Ti',181.46,99087800309121073,99087800309121123,99087800309121153,99087800309121105);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),'NVidia GEForce','Nvidia graphic card','https://images-na.ssl-images-amazon.com/images/I/71sN1G2-16L._AC_SX466_.jpg','GTX 1080 Ti',181.46,99087800309121073,null,99087800309121156,99087800309121105);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),'NVidia GEForce','Nvidia graphic card','https://images-na.ssl-images-amazon.com/images/I/71sN1G2-16L._AC_SX466_.jpg','GTX 1080 Ti',181.46,99087800309121073,99087800309121123,99087800309121153,99087800309121105);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),'NVidia GEForce','Nvidia graphic card','https://images-na.ssl-images-amazon.com/images/I/71sN1G2-16L._AC_SX466_.jpg','GTX 1080 Ti',181.46,99087800309121073,null,99087800309121156,99087800309121105);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),'Intel','Intel Core i7-4940MX Processor','https://www.tomshw.it/files/2014/01/immagini_contenuti/52614/core-i7_t.jpg','Core i7-4940MX',790.24,99087800309121072,99087800309121124,99087800309121157,99087800309121107);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),'Intel','Intel Core i7-4940MX Processor','https://www.tomshw.it/files/2014/01/immagini_contenuti/52614/core-i7_t.jpg','Core i7-4940MX',790.24,99087800309121072,99087800309121124,null,99087800309121107);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),'Intel','Intel Core i7-4940MX Processor','https://www.tomshw.it/files/2014/01/immagini_contenuti/52614/core-i7_t.jpg','Core i7-4940MX',790.24,99087800309121072,99087800309121124,99087800309121157,99087800309121107);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),'Intel','Intel Core i7-4940MX Processor','https://www.tomshw.it/files/2014/01/immagini_contenuti/52614/core-i7_t.jpg','Core i7-4940MX',790.24,99087800309121072,99087800309121124,null,99087800309121107);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),'Intel','Intel Core i7-4940MX Processor','https://www.tomshw.it/files/2014/01/immagini_contenuti/52614/core-i7_t.jpg','Core i7-4940MX',790.24,99087800309121072,null,99087800309121158,99087800309121107);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),'Intel','Intel Core i7-4940MX Processor','https://www.tomshw.it/files/2014/01/immagini_contenuti/52614/core-i7_t.jpg','Core i7-4940MX',790.24,99087800309121072,99087800309121124,99087800309121157,99087800309121107);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),'Intel','Intel Core i7-4940MX Processor','https://www.tomshw.it/files/2014/01/immagini_contenuti/52614/core-i7_t.jpg','Core i7-4940MX',790.24,99087800309121072,null,99087800309121158,99087800309121107);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),'Intel','Intel Core i7-4940MX Processor','https://www.tomshw.it/files/2014/01/immagini_contenuti/52614/core-i7_t.jpg','Core i7-4940MX',790.24,99087800309121072,99087800309121124,99087800309121157,99087800309121107);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),'Intel','Intel Core i7-4940MX Processor','https://www.tomshw.it/files/2014/01/immagini_contenuti/52614/core-i7_t.jpg','Core i7-4940MX',790.24,99087800309121072,null,99087800309121158,99087800309121107);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),'Sandisk','240 GB SSD','https://images.eprice.it/nobrand/0/Lightbox/424/201864424/2420EU125216PRDID.2.jpg','SATA III',306.57,99087800309121079,null,99087800309121172,99087800309121108);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),'Sandisk','240 GB SSD','https://images.eprice.it/nobrand/0/Lightbox/424/201864424/2420EU125216PRDID.2.jpg','SATA III',306.57,99087800309121079,null,null,99087800309121108);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),'Sandisk','240 GB SSD','https://images.eprice.it/nobrand/0/Lightbox/424/201864424/2420EU125216PRDID.2.jpg','SATA III',306.57,99087800309121079,null,99087800309121172,99087800309121108);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),'Sandisk','240 GB SSD','https://images.eprice.it/nobrand/0/Lightbox/424/201864424/2420EU125216PRDID.2.jpg','SATA III',306.57,99087800309121079,null,null,99087800309121108);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),'Sandisk','240 GB SSD','https://images.eprice.it/nobrand/0/Lightbox/424/201864424/2420EU125216PRDID.2.jpg','SATA III',306.57,99087800309121079,null,99087800309121170,99087800309121108);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),'Sandisk','240 GB SSD','https://images.eprice.it/nobrand/0/Lightbox/424/201864424/2420EU125216PRDID.2.jpg','SATA III',306.57,99087800309121079,null,99087800309121170,99087800309121108);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),'Sandisk','240 GB SSD','https://images.eprice.it/nobrand/0/Lightbox/424/201864424/2420EU125216PRDID.2.jpg','SATA III',306.57,99087800309121079,null,99087800309121169,99087800309121108);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),'Sandisk','240 GB SSD','https://images.eprice.it/nobrand/0/Lightbox/424/201864424/2420EU125216PRDID.2.jpg','SATA III',306.57,99087800309121079,null,null,99087800309121108);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),'Sandisk','240 GB SSD','https://images.eprice.it/nobrand/0/Lightbox/424/201864424/2420EU125216PRDID.2.jpg','SATA III',306.57,99087800309121079,null,99087800309121169,99087800309121108);
insert into product(id, brand, description, image_url, model, price, category_id, order_id, purchase_id, warehouse_id) values (UUID_SHORT(),'Sandisk','240 GB SSD','https://images.eprice.it/nobrand/0/Lightbox/424/201864424/2420EU125216PRDID.2.jpg','SATA III',306.57,99087800309121079,null,99087800309121169,99087800309121108);



insert into review(id, brand, model, rate, text, title, customer_id) values (UUID_SHORT(),'NVidia GEForce','GTX 1080 Ti',5,'Excellent good','Excellent',99087800309121082);


