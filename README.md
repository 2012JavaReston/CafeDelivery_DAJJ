# CafeDelivery_DAJJ

## Middle
Utilized Java to set up servlets, controllers, and service layer to connect to dao layer, Tomcat for running the server, Postman for testing, and log4j for logging

Master servlet takes in all requests and sends them to request helper

Request helper checks endpoint(uri) and method and sends them to the appropriate controller

Login controller handles login and logout requests

Sign up contorller handles account creation

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
