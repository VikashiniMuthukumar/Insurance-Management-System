create database insurance;
use insurance;

CREATE TABLE policy (
    policy_id INT PRIMARY KEY AUTO_INCREMENT,
    policy_amt DOUBLE NOT NULL,
    policy_name VARCHAR(100) NOT NULL,
    policy_coverage_amt DOUBLE NOT NULL,
    policy_duration INT NOT NULL
);


CREATE TABLE client (
    client_id INT PRIMARY KEY AUTO_INCREMENT,
    client_name VARCHAR(100) NOT NULL,
    contact_no VARCHAR(15) NOT NULL,
    policy_id INT,
    FOREIGN KEY (policy_id) REFERENCES policy(policy_id)
);


INSERT INTO policy (policy_amt, policy_name, policy_coverage_amt, policy_duration) VALUES
(10000, 'Health Plus', 500000, 10),
(15000, 'Family Secure', 800000, 15),
(20000, 'Senior Care', 600000, 12);


INSERT INTO client (client_name, contact_no, policy_id) VALUES
('Ram', '9876543210', 1),
('Prasad', '9123456789', 2),
('Seetha', '9988776655', 3),
('Rajeev', '9012345678', 1),
('Shyam', '8765432109', 1),
('Tom', '8899001122', 2),
('Jerry', '9334455667', 2),
('Henry', '9445566778', 3),
('Isha', '9556677889', 3);


select * from policy;
select * from client;


SELECT * FROM policy WHERE policy_id=1;


