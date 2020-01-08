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


DROP TABLE IF EXISTS reimbursedb.reimburse CASCADE;;
CREATE TABLE reimbursedb.reimburse (
	reim_id SERIAL PRIMARY KEY,
	submit_by VARCHAR NOT NULL, --f_name + l_name
	reim_amt NUMERIC(10, 2) NOT NULL,
	reim_type VARCHAR NOT NULL,
	reim_descr VARCHAR NOT NULL,
	submit_dte TIMESTAMP NOT NULL,
	reim_recpt VARCHAR NOT NULL,
	reim_stat VARCHAR NOT NULL,
	process_dte TIMESTAMP NOT NULL,
	process_by VARCHAR NOT NULL,
	emp_id INTEGER REFERENCES reimbursedb.employee(emp_id),
	type_id INTEGER REFERENCES reimbursedb.reim_type(type_id),
	status_id INTEGER REFERENCES reimbursedb.reim_status(status_id)
	
	--CONSTRAINT  fk_emp_id FOREIGN KEY (emp_id) REFERENCES reimburse.employee(emp_id)
	
);

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