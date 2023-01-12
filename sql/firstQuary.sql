USE cars;

ALTER TABLE Car ALTER driver SET DEFAULT "0";
ALTER TABLE Car ALTER car_shop SET DEFAULT "0";
ALTER TABLE Customer_car_shop ALTER customer_id SET DEFAULT 0;
ALTER TABLE Customer_car_shop ALTER car_shop_id SET DEFAULT 0;
ALTER TABLE Customer_service_centre ALTER customer_id SET DEFAULT 0;
ALTER TABLE Customer_service_centre ALTER service_centre_id SET DEFAULT 0;
ALTER TABLE Detail_details_shop RENAME COLUMN Detail_id TO detail_id;
ALTER TABLE Detail_details_shop RENAME COLUMN Details_shop_id TO details_shop_id;
ALTER TABLE Detail_details_shop ALTER detail_id SET DEFAULT 0;
ALTER TABLE Detail_details_shop ALTER details_shop_id SET DEFAULT 0;
ALTER TABLE Details_shop_service_centre ALTER details_shop_id SET DEFAULT 0;
ALTER TABLE Details_shop_service_centre ALTER service_centre_id SET DEFAULT 0;
ALTER TABLE Service_centre_order ALTER service_centre_id SET DEFAULT 0;
ALTER TABLE Service_centre_order ALTER car_id SET DEFAULT 0;


INSERT INTO Detail(type) VALUES('engine');
INSERT INTO Detail(type) VALUES('Fuel System');
INSERT INTO Detail(type) VALUES('Ignition System');
INSERT INTO Detail(type) VALUES('Electrical System');
INSERT INTO Detail(type) VALUES('Exhaust System');
INSERT INTO Detail(type) VALUES('Drive Train');

-- ALTER TABLE Details_shop MODIFY id int AUTO_INCREMENT;

INSERT INTO Details_shop(id,location, name) VALUES (2,'LA','BMW') ;
INSERT INTO Detail_details_shop(detail_id,details_shop_id,price) VALUES (12,1,2300);
INSERT INTO Detail_details_shop(detail_id,details_shop_id,price) VALUES (11,1,1200);
INSERT INTO Detail_details_shop(detail_id,details_shop_id,price) VALUES (10,1,4500);
INSERT INTO Detail_details_shop(detail_id,details_shop_id,price) VALUES (9,1,100);
INSERT INTO Detail_details_shop(detail_id,details_shop_id,price) VALUES (8,1,50);

UPDATE Detail SET type = 'Brake System.' WHERE id = 2 ;
UPDATE Detail SET type = 'Drive Train' WHERE id = 3  ;
UPDATE Detail SET type = 'Engine block' WHERE id = 5;
UPDATE Detail SET type = 'Crank Shaft' WHERE id = 6;
UPDATE Detail SET type = 'Battery' WHERE id = 1;
UPDATE Detail SET type = 'Transmission' WHERE id = 4;

UPDATE Detail_details_shop SET price = 123 WHERE detail_id = 2;
UPDATE Detail_details_shop SET price = 532 WHERE detail_id = 5;
UPDATE Detail_details_shop SET price = 124 WHERE detail_id = 4;
UPDATE Detail_details_shop SET price = 535 WHERE detail_id = 1;
UPDATE Detail_details_shop SET price = 535 WHERE detail_id = 3;

DELETE FROM Detail WHERE id = 1;
DELETE FROM Detail WHERE id = 2;
DELETE FROM Detail WHERE id = 3;
DELETE FROM Detail WHERE id = 4;
DELETE FROM Detail WHERE id = 5;

DELETE FROM Detail_details_shop WHERE details_shop_id = 2;
DELETE FROM Detail_details_shop WHERE details_shop_id = 1;
DELETE FROM Detail_details_shop WHERE details_shop_id = 2;
DELETE FROM Detail_details_shop WHERE details_shop_id = 1;
DELETE FROM Detail_details_shop WHERE details_shop_id = 2;


SELECT Detail.type, Detail_details_shop.price
FROM Detail
INNER JOIN Detail_details_shop ON Detail.id = Detail_details_shop.detail_id;

SELECT Detail.type, Detail_details_shop.price
FROM Detail
LEfT JOIN Detail_details_shop ON Detail.id = Detail_details_shop.detail_id;

SELECT Detail.type, Detail_details_shop.price
FROM Detail
RIGHT JOIN Detail_details_shop ON Detail.id = Detail_details_shop.detail_id;

SELECT Detail.type, Detail_details_shop.price
FROM Detail
CROSS JOIN Detail_details_shop;

SELECT Car.model,
	Car.vendor,
	Customer.first_name,
    Car_shop.location,
    Driver.first_name,
    Driver.last_name
    
	FROM Customer
	CROSS JOIN Car
    CROSS JOIN Car_shop
    CROSS JOIN Driver;
    
    
SELECT COUNT(type) FROM detail;
SELECT SUM(price) AS "All prices" FROM details_shop_service_centre; 
SELECT AVG(price) AS "Average price" FROM details_shop_service_centre; 
SELECT MIN(price) AS "Average price" FROM details_shop_service_centre; 
SELECT MAX(price) AS "Average price" FROM details_shop_service_centre;     
SELECT type FROM detail LIMIT 1;
SELECT type FROM detail ORDER BY id DESC LIMIT 1;    

SELECT COUNT(type) FROM detail HAVING COUNT(id) > 2;
SELECT SUM(price), details_shop_id AS "Details costing more than 100" FROM details_shop_service_centre GROUP BY details_shop_id  HAVING MIN(price) > 100;
SELECT AVG(price) AS "Average price" FROM details_shop_service_centre; 
SELECT MIN(price) AS "Average price" FROM details_shop_service_centre; 
SELECT MAX(price) AS "Average price" FROM details_shop_service_centre;     
SELECT type FROM detail LIMIT 1;
SELECT type FROM detail ORDER BY id DESC LIMIT 1;    
     
     
     
     
     
     
     

select * from Detail; 
select * from Detail_details_shop; 
