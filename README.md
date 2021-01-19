# CafeDelivery_DAJJ

## Technologies Used
### Front End
- HTML
- CSS
- JavaScript
### Middle
- Tomcat
- Java
### Back End
- AWS
- Postgresql
- Hibernate

## Getting Started
1) Run `git clone https://github.com/2012JavaReston/CafeDelivery_DAJJ.git`
2) Open Spring Tool Suite
3) Import CafeDelivery
4) Navigate to CafeDelivery/src/main/resources/hibernate.cfg.xml
5) Change the connection username, url, and password to your own Postgresql database
6) Run CafeDelivery/src/main/java/com/revature/driver/MainDriver.java on it's own to populate the database
7) Run the application on the server

## Front End
### Login / Sign Up Page
Responsive Design: Both pages implement responsive design. The Sign up page has a media query to change the design on mobile view.

JavaScript: Ensures that all fields are required. It also ensures that the password and confirm password are identical. 

AJAX: Is used to submit the forms via JSON format. It also catches login / sign up errors and renders them on page.


## Middle
Utilized Java to set up servlets, controllers, and service layer to connect to dao layer, Tomcat for running the server, Postman for testing, and log4j for logging

Master servlet takes in all requests and sends them to request helper

Request helper checks endpoint(uri) and method then sends them to the appropriate controller

Login controller handles login and logout requests

Sign up controller handles account creation

Customer controller handles getting the menu and order history, and submitting new orders

## Back End
### DAO Layer
Utilized Hibernate, PostgreSQL, AWS RDS and Java

We used Hibernate to be our framework when communicating with our database.  It utilizes a singleton design pattern so that only 1 session is provided at a time.  Using annotations provided by Hibernate, we are able to create table relations based on our objects.

### Table Relationships
Customer --One to Many-> Orders  
Orders --Many to One-> Customers  
Orders --Many to Many-> Food (Junction table is created to manage this)  

### Config
In the hibernate.cfg.xml file, you will have to insert your database credentials in order to interact with the application.  There is a MainDriver.java that you can run to create your tables and provide some initial data to play with.
