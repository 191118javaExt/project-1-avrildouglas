--DROP SCHEMA IF EXISTS reimbursedb;
--CREATE SCHEMA reimbursedb;

DROP TABLE IF EXISTS reimbursedb.employee CASCADE;

CREATE TABLE reimbursedb.employee (
	emp_id SERIAL PRIMARY KEY,
	first_name VARCHAR NOT NULL,
	last_name VARCHAR NOT NULL,
	user_name VARCHAR NOT NULL,
	pass_word VARCHAR NOT NULL,
	birth_date DATE NOT NULL,   --posting_date DATE NOT NULL DEFAULT CURRENT_DATE
	gender VARCHAR NOT NULL,
	--username VARCHAR NOT NULL,
	--PASSWORD VARCHAR NOT NULL,
	hire_date TIMESTAMP NOT NULL
	
	--role_id INTEGER NOT NULL,
	--CONSTRAINT  fk_role_id FOREIGN KEY (role_id) REFERENCES reimburse.role(role_id)
);


--CREATE OR REPLACE FUNCTION set_password_f()
--RETURNS TRIGGER AS $$
--BEGIN
--   NEW.pass_word = md5(CAST((f.*)AS TEXT));
--   RETURN NEW;
--END;
--$$ language plpgsql;
--
--CREATE TRIGGER set_password
--BEFORE INSERT
--ON reimbursedb.employee
--FOR EACH ROW
--	EXECUTE PROCEDURE set_password_f();


CREATE OR REPLACE FUNCTION set_current_time_f()
RETURNS TRIGGER AS $$
BEGIN
   NEW.hire_date = now();
   RETURN NEW;
END;
$$ language plpgsql;

CREATE TRIGGER set_current_time
BEFORE INSERT
ON reimbursedb.employee
FOR EACH ROW
	EXECUTE PROCEDURE set_current_time_f();

INSERT INTO reimbursedb.employee (first_name, last_name, user_name, pass_word, birth_date, gender) VALUES ('Mary', 'Jane', 'mjane3434', 'tester123','02/13/1972', 'F' );
INSERT INTO reimbursedb.employee (first_name, last_name, user_name, pass_word, birth_date, gender) VALUES ('Benjamin', 'Taylor', 'btaylor678', 'fixer456', '05/12/1975', 'M' );
INSERT INTO reimbursedb.employee (first_name, last_name, user_name, pass_word, birth_date, gender) VALUES ('Rose', 'Baker', 'rbaker980', 'painter789', '04/10/1982', 'F' );
INSERT INTO reimbursedb.employee (first_name, last_name, user_name, pass_word, birth_date, gender) VALUES ('Wanda', 'Griffith', 'wgriffith', 'doctor999', '12/24/1981', 'F' );
INSERT INTO reimbursedb.employee (first_name, last_name, user_name, pass_word, birth_date, gender) VALUES ('Scott', 'Perry', 'sperry', 'baker9090', '03/11/1992', 'M' );


--CREATE EXTENSION pgcrypto;


DROP TABLE IF EXISTS reimbursedb."role" CASCADE;
CREATE TABLE reimbursedb.role (
	role_id SERIAL PRIMARY KEY,
	emp_id INTEGER NOT NULL REFERENCES reimbursedb.employee(emp_id),
	--first_name VARCHAR NOT NULL,
	--last_name VARCHAR NOT NULL,
	role_name VARCHAR NOT NULL,
 	role_desc VARCHAR NOT NULL
	
	--CONSTRAINT  fk_emp_id FOREIGN KEY (emp_id) REFERENCES reimburse.employee(emp_id)
);


INSERT INTO reimbursedb.role (emp_id, role_name, role_desc) VALUES (1, 'admin', 'Role can view all dashboard view pages');
INSERT INTO reimbursedb.role (emp_id, role_name, role_desc) VALUES (3, 'admin', 'Role can view all dashboard view pages');
INSERT INTO reimbursedb.role (emp_id, role_name, role_desc) VALUES (2, 'admin', 'Role can view all dashboard view pages');
INSERT INTO reimbursedb.role (emp_id, role_name, role_desc) VALUES (4, 'admin', 'Role can view all dashboard view pages');

DROP TABLE IF EXISTS reimbursedb.reim_recpt CASCADE;
CREATE TABLE reimbursedb.reim_recpt (
     recpt_id SERIAL PRIMARY KEY,
     reim_id INTEGER NOT NULL REFERENCES reimbursedb.reimburse(reim_id),
     mime_type CHARACTER VARYING(255) NOT NULL,
     file_name CHARACTER VARYING(255) NOT NULL,
     file_data BYTEA NOT NULL
   );

DROP TABLE IF EXISTS reimbursedb.reimburse CASCADE;
CREATE TABLE reimbursedb.reimburse (
	reim_id SERIAL PRIMARY KEY,
	user_name VARCHAR NOT NULL,
	submit_by VARCHAR NOT NULL, --f_name + l_name
	reim_amt NUMERIC(10, 2) NOT NULL,
	reim_type VARCHAR NOT NULL,
	reim_descr VARCHAR NOT NULL,
	submit_dte TIMESTAMP NOT NULL,
	reim_recpt VARCHAR,
	reim_stat VARCHAR NOT NULL,
	process_dte TIMESTAMP NOT NULL,
	process_by VARCHAR NOT NULL
	
	
	--CONSTRAINT  fk_emp_id FOREIGN KEY (emp_id) REFERENCES reimburse.employee(emp_id)
	
);

INSERT INTO reimbursedb.reimburse (user_name, submit_by, reim_amt,reim_type,
reim_descr, submit_dte, reim_recpt, reim_stat, process_dte, process_by)
VALUES ('mjane3434', 'Mary Jane','200.00', 'Food', 'For Donuts',
'11/24/2019', '', 'Pending', '11/25/2019','Scott Perry');
INSERT INTO reimbursedb.reimburse (user_name, submit_by, reim_amt,reim_type,
reim_descr, submit_dte, reim_recpt, reim_stat, process_dte, process_by)
VALUES ('wgriffith', 'Wanda Griffith','225.00', 'Lodge', 'Overnight stay in 1 room',
'12/27/2019', '', 'Approve', '12/29/2019','Scott Perry');



DROP TABLE IF EXISTS reimbursedb.reim_type CASCADE;
CREATE TABLE reimbursedb.reim_type (
	type_id SERIAL PRIMARY KEY,
	reim_type VARCHAR NOT NULL
);

INSERT INTO reimbursedb.reim_type (reim_type) VALUES ('Food');
INSERT INTO reimbursedb.reim_type (reim_type) VALUES ('Lodging');
INSERT INTO reimbursedb.reim_type (reim_type) VALUES ('Travel');
INSERT INTO reimbursedb.reim_type (reim_type) VALUES ('Stationery');


DROP TABLE IF EXISTS reimbursedb.reim_status CASCADE;
CREATE TABLE reimbursedb.reim_status (
	status_id SERIAL PRIMARY KEY,
	reim_status VARCHAR NOT NULL
);

INSERT INTO reimbursedb.reim_status (reim_status) VALUES ('Approved');
INSERT INTO reimbursedb.reim_status (reim_status) VALUES ('Denied');
INSERT INTO reimbursedb.reim_status (reim_status) VALUES ('Pending');