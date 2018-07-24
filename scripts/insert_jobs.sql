Insert into pw.tech_skill (id, skill_name) Values 
(1, 'Java EE'),
(2, 'Bootstrap'),
(3, 'Spring MVC'),
(4, 'Eclipse');



Insert into pw.job (id, companyname, phone, fardel, desct, salary, academic, fulltime) Values 
(1, 'Noesis Solutions', '+32 (0) 555 555 555', 'Software Engineer', 'Job abroad on Noesis', 20000, true, true),
(2, 'Apple Inc.', '+32 (0) 222 222 222', 'Tester', 'Normal job', 10, false, false),
(3, 'Third Company', '+55 (11) 94861 6495', 'Quality Assurance', 'Full and integrate tester', 1000, true, false),
(4, 'Fourth Company', '+1 (9) 555 332 12', 'Human Resources HR', 'A good job to hire', 50000, false, true),
(5, 'Google inc.', '+1 (7) 333 22 1', 'Java Developer', 'A good place to work', 100000, false, false);



Insert into pw.job_tech_skills (job_id, tech_skill_id, tech_skill_level) Values
(1, 1, 1),
(1, 2, 3),
(1, 3, 1),
(1, 4, 1),

(2, 1, 5),
(2, 2, 0),
(2, 3, 3),
(2, 4, 2),

(3, 1, 0),
(3, 2, 0),
(3, 3, 0),
(3, 4, 1),

(4, 1, 2),
(4, 2, 0),
(4, 3, 1),
(4, 4, 0),

(5, 1, 3),
(5, 2, 1),
(5, 3, 0),
(5, 4, 0);



Insert into pw.applicant (id, name, email, phone, salary, idworkingtime, academicdegree) Values
(1, 'Abraham Aiken', 'abrah.aik@gmail.com', '+32 (1) 5555 55', 2500, 2, 'Computer Science'),
(2, 'Adam Bowe', 'adam.bowe@gmail.com', '+1 (0) 555 55 5', 100, 1, ''),
(3, 'Bianca Courtier', 'bia.court@outlook.com', '+1 (9) 99 99 9', 250, 0, 'Science'),
(4, 'Rachel Downing', 'rach.downing@yahoo.com', '+37 7 777 777 77', 500, 2, 'Information Systems'),
(5, 'James Bond', 'bond.james.bond@gmail.com', '+55 (11) 90000 0000', 5000, 2, 'Business Administration');


Insert into pw.applicant_tech_skills (applicant_id, tech_skill_id, tech_skill_level) Values
(1, 1, 0),
(1, 2, 0),
(1, 3, 1),
(1, 4, 1),

(2, 1, 3),
(2, 2, 0),
(2, 3, 2),
(2, 4, 2),

(3, 1, 1),
(3, 2, 0),
(3, 3, 0),
(3, 4, 2),

(4, 1, 1),
(4, 2, 0),
(4, 3, 0),
(4, 4, 0),

(5, 1, 5),
(5, 2, 5),
(5, 3, 5),
(5, 4, 5);