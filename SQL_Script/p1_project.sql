CREATE TABLE roles (
	role_id serial PRIMARY KEY,
	 role_title TEXT 

);

CREATE TABLE reimbursement_types (
	reimb_type_id serial PRIMARY KEY,
	reimb_type TEXT 

);

CREATE TABLE reimbursement_status (
	reimb_status_id serial PRIMARY KEY,
	reimb_status TEXT

);


CREATE TABLE users(
	user_id serial PRIMARY KEY,
	user_name TEXT,
	pass_word TEXT,
	first_name TEXT,
	last_name TEXT,
	email TEXT,
	role_id_fk int REFERENCES roles(role_id)

);

CREATE TABLE reimbursements(
	reimb_id serial PRIMARY KEY,
	amount int,
	time_submitted timestamp,
	time_resolved timestamp,
	description TEXT,
	author int REFERENCES users(user_id),
	resolver int REFERENCES users(user_id),
	reimb_status_id int REFERENCES reimbursement_status(reimb_status_id),
	reimb_type_id int REFERENCES reimbursement_types(reimb_type_id)
	
);

		
DROP TABLE IF EXISTS ers_reimbursement CASCADE;
DROP TABLE ers_reimbursement ;
DROP TABLE ers_users;
DROP TABLE ers_user_roles;
DROP TABLE ers_reimbursement_status;
DROP TABLE ers_reimbursement_type ;

INSERT INTO reimbursement_types (reimb_type)
VALUES ('lodging'),
		('travel'),
		('food'),
		('other');
		
SELECT * FROM reimbursement_types ;

INSERT INTO roles(role_title)
VALUES	('Employee'),
		('Manager');

SELECT * FROM roles
1
INSERT INTO reimbursement_status (reimb_status)
VALUES 	('Pending'),
		('Approved'),
		('Denied');

SELECT * FROM reimbursement_status ;

INSERT INTO users(user_name, pass_word,first_name,last_name,email, role_id_fk)
	VALUES ('John_Doe','password', 'John', 'Doe', 'johndoe@revature.net', 1),
		   ('Jane_Doe','password', 'Jane', 'Doe', 'janedoe@revature.net', 2);
		  
		   
SELECT * FROM users;

INSERT INTO users(user_name, pass_word,first_name,last_name,email, role_id_fk)
	VALUES ('Adam_test','password', 'Adam', 'Test', 'adam@revature.net', 1),
		   ('admin','password', 'Admin', 'Manager', 'admin@revature.net', 2);

SELECT * FROM reimbursements;