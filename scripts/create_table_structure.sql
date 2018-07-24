CREATE TABLE PW.JOB(

id SERIAL PRIMARY KEY,

companyName TEXT not null,

phone TEXT not null,

fardel TEXT not null,

desct TEXT not null,

salary int,

academic boolean not null,

fulltime boolean not null
);

create table pw.applicant(

id serial primary key,

name text not null,

email text not null,

phone text not null,

salary int,

idWorkingTime int not null,

academicDegree text
);

CREATE TABLE PW.TECH_SKILL(

id SERIAL PRIMARY KEY,

skill_name TEXT not null
);

create table pw.job_tech_skills(

job_id int not null,

tech_skill_id int not null,

tech_skill_level int not null,

PRIMARY KEY (job_id, tech_skill_id),

FOREIGN KEY (job_id) REFERENCES pw.job(id),

FOREIGN KEY (tech_skill_id) REFERENCES pw.tech_skill(id)
);

create table pw.applicant_tech_skills(

applicant_id int not null,

tech_skill_id int not null,

tech_skill_level int not null,

PRIMARY KEY (applicant_id, tech_skill_id),

FOREIGN KEY (applicant_id) REFERENCES pw.applicant(id),

FOREIGN KEY (tech_skill_id) REFERENCES pw.tech_skill(id)
);