# Employee Reimbursement System

## Project Description

Expense Reimbursement System (ERS) In this document, all requirements and required technologies pertaining the first full stack individual project of your training will be presented. All requirements are mandatory. The Expense Reimbursement System will manage the process of reimbursing employees for expenses incurred while on company time. All employees in the company can login and submit requests for reimbursement and view their past tickets and pending requests. Finance managers can log in and view all reimbursement requests and history for all employees in the company. Finance managers are authorized to approve and deny requests for expense reimbursement.

## Technologies Used

* Java (Intellij IDE)
* Java Servlets
* Tomcat
* MySQL

## Features

List of features ready and TODOs for future development
* Login/Logout
* Submit requests
* View pending requests
* Approve/deny requests
*

To-do list:
* Integrate Hibernate in replacement of MySQL
* Create a password recovery feature

## Getting Started
   
git clone command - git clone https://github.com/Seith09/Revature_Project_One.git

> Create a hibernate.cfg.xml file inside the resources folder and provide the information for your local database. The configuration on the page should look like this:
> Create a local database that stores your admin and employee credentials

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE hibernate-configuration PUBLIC
        "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
        "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">

<hibernate-configuration>
    <session-factory>
        <property name="connection.driver_class">com.mysql.cj.jdbc.Driver</property>
        <property name="connection.url">jdbc:mysql://localhost:3306/<your SQL database name></property>
        <property name="connection.username"><your username></property>
        <property name="connection.password"><your password></property>
        <property name="dialect">org.hibernate.dialect.MySQLDialect</property>
        <property name="hbm2ddl.auto">update</property>
        <property name="show_sql">true</property>
        <mapping class="com.revature.servlets.ReiServletR"/>
    </session-factory>
</hibernate-configuration>

> Run the application and click in the console to launch.

