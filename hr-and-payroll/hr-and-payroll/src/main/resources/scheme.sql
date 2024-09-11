CREATE TABLE employee (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    department_id BIGINT,
    position VARCHAR(50),
    hourly_rate DECIMAL(10, 2),
    FOREIGN KEY (department_id) REFERENCES department(id)
);

CREATE TABLE attendance (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    employee_id BIGINT,
    date DATE NOT NULL,
    check_in_time DATETIME,
    check_out_time DATETIME,
    hours_worked DECIMAL(5, 2),
    overtime_hours DECIMAL(5, 2),
    status ENUM('PRESENT', 'ABSENT', 'LEAVE'),
    FOREIGN KEY (employee_id) REFERENCES employee(id),
    INDEX (employee_id),
    INDEX (date)
);

CREATE TABLE leave (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    employee_id BIGINT,
    leave_type ENUM('SICK', 'VACATION', 'UNPAID'),
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    total_days INT,
    status ENUM('APPROVED', 'PENDING', 'REJECTED'),
    FOREIGN KEY (employee_id) REFERENCES employee(id),
    INDEX (employee_id),
    INDEX (status)
);

CREATE TABLE overtime_request (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    employee_id BIGINT,
    attendance_id BIGINT,
    requested_overtime_hours DECIMAL(5, 2),
    status ENUM('PENDING', 'APPROVED', 'REJECTED'),
    FOREIGN KEY (employee_id) REFERENCES employee(id),
    FOREIGN KEY (attendance_id) REFERENCES attendance(id),
    INDEX (employee_id),
    INDEX (status)
);

CREATE TABLE department (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);