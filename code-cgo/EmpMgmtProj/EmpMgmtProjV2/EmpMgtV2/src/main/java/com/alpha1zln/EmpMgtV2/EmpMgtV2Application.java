package com.alpha1zln.EmpMgtV2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmpMgtV2Application {

	public static void main(String[] args) {
		SpringApplication.run(EmpMgtV2Application.class, args);
	}

}



/*
for postman... data 
{
  "name": "jen",
  "department": "R_D",
  "salary": 400
}


can use this to enter from h2 db... console .. 
http://localhost:8086/h2-console
INSERT INTO employee (name, department, salary, joined_on)
VALUES ('sam', 'RMgmt', 100.0, CURRENT_DATE());

INSERT INTO employee (name, department, salary, joined_on)
VALUES ('aln', 'IT', 200.0, CURRENT_DATE());

INSERT INTO employee (name, department, salary, joined_on)
VALUES ('jaf', 'Ac', 150.0, CURRENT_DATE());


data.sql ... not working ... later
INSERT INTO employee (name, department, salary, joined_on) VALUES ('sam', 'RMgmt', 100.0, CURRENT_DATE());
INSERT INTO employee (name, department, salary, joined_on) VALUES ('aln', 'IT', 200.0, CURRENT_DATE());
INSERT INTO employee (name, department, salary, joined_on) VALUES ('jaf', 'Ac', 150.0, CURRENT_DATE());


*/