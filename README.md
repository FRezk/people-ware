# People-ware
Solving the People-Ware Web App Tech Challenge!

## What is it?
This is a Tech Challenge solved building an entire Web App to hire and find a job.

## Technologies, Frameworks, patterns and softwares used
```
FrontEnd
```
- HTML / CSS / JS
- Tabler UI / Bootstrap / Handlebars / Template String / Fontawesome /  Visual Studio Code

```
Backend
```
- Java EE / Java 8
- Maven / Spring Web MVC / Rest APIs / Tomcat 9 / Gson / Lambda Expressions / Eclipse

```
Database
```
- PostgreSQL / PgAdmin v4.0


## Pre-reqs
```
Jre Java 1.8 or newer
```
```
Postman or any software to test via Http Request
(Obs.: You may use linux cURL to make the http requests)
```
```
PgAdmin v4.0 - With a database created, ready to create a new schema
```

## How to use?


1- Clone the repository


![clone](https://image.ibb.co/fni3Do/pw1.jpg)


2- Open PgAdmin v4.0 , create a database called peopleware and create a schema called 'pw'


![schema](https://image.ibb.co/kTPzm8/pw2.jpg)

```
Obs.: The default project's credentials configuration is 'postgres' as user and 'root' as password. If you have a different credentials, take a look into the step 4 notes.  
```


3- Execute the scripts in order: create_table_structure.sql then insert_jobs.sql


![insert](https://image.ibb.co/cdr6Yo/pw3.jpg)


4- Import the project into your IDE


![import](https://image.ibb.co/f4MODo/pw4.jpg)

```
Obs.: If you have a differente credential then 'postgres' as username, and 'root' as password, open the class 'BeansConfig' and look for the DbExecutor interface implementation, and change the connection credentials.
```


5- Deploy the war (API module) into your Tomcat 9, and run the server


![deploy](https://image.ibb.co/b4AKKT/pw5.jpg)


6- We are good to test the Web App. Open your FrontEnd folder and open home.html in your browser


![deploy](https://image.ibb.co/cA7oDo/pw6.jpg)


# People-Ware Screenshots

### 1 - Home
![home](https://image.ibb.co/k0auKT/pw7.jpg)


### 2 - Company Screen, listing all the jobs published
![listJobs](https://image.ibb.co/i5U4KT/pw8.jpg)


### 3 - How about a new job? Lets publish a new job!
![publish](https://image.ibb.co/k5VTeT/pw10.jpg)


### 4 - Job detail, showing the job descriptions and the best candidates sorted by score
![jobDetail](https://image.ibb.co/d4GvR8/pw9.jpg)


### 5 - Lets find a job, filling in the professional form
![professionalForm](https://image.ibb.co/fgFx68/pw11.jpg)


### 6 - Now we can see all the jobs we may apply, based on our informations
![professionalForm](https://image.ibb.co/iv7um8/pw12.jpg)

/

## Authors

* **Fernando D. Rezk** - [People-Ware](https://github.com/FRezk/people-ware.git)

Thanks!
