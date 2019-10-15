
CREATE DATABASE IF NOT EXISTS COMP3095;
USE COMP3095;
grant all on COMP3095.* to 'app'@'localhost' identified by 'pw123'; 

CREATE TABLE USERS 
( 
	id int(11) AUTO_INCREMENT PRIMARY KEY, 
	firstname varchar(255),
	lastname varchar(255),
	email varchar(255), 
    address varchar(255),
	role varchar(20),
	created timestamp default current_timestamp,
	passwordhash varchar(128),
    salt varchar(128)
);

INSERT INTO `USERS` (`firstname`, `lastname`, `email`, `role`, `password`) VALUES
('Blog', 'Blogson', `admin@domain.ca`, '123 Street', `P@ssword1`, 'xxxxx');
