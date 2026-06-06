CREATE DATABASE payroll_db;

USE payroll_db;

CREATE TABLE employees (
    employee_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    position VARCHAR(50),
    monthly_salary DOUBLE
);

