# Railway Reservation System

A web-based Railway Reservation System developed using **Java, Apache Struts 2, JSP, JDBC, PostgreSQL, and Redis**.

The application provides separate functionalities for **passengers and administrators**, including user registration, authentication, train search, ticket booking, ticket cancellation, PNR search, train management, and booking management.

---

## Project Overview

The Railway Reservation System is designed to simulate the core operations of a railway ticket reservation platform.

### Passenger functionalities

* User registration
* User login and authentication
* Search trains
* View train search results
* Book railway tickets
* Generate PNR for bookings
* View booking history
* Cancel tickets
* Search booking details using PNR
* Logout

### Administrator functionalities

* Admin authentication
* Add trains
* View available trains
* Delete trains
* View all bookings
* Manage railway-related information

---

## Features

### User Management

* User registration
* User login
* Session-based authentication
* Secure password hashing using **BCrypt**
* User logout

### Train Management

* Search trains based on journey details
* View train information
* Add new trains through admin dashboard
* View all trains
* Delete trains

### Ticket Booking

* Select a train
* Validate seat availability
* Book tickets
* Generate PNR
* Store booking information in PostgreSQL
* Transaction-based booking operations

### Ticket Management

* View user's bookings
* Search booking information using PNR
* Cancel tickets
* Update booking-related information

### Performance

* Integrated **Redis** for caching
* Redis is used to improve frequently accessed train search operations

---

## Technologies Used

| Technology            | Purpose                         |
| --------------------- | ------------------------------- |
| Java 17               | Backend programming             |
| Apache Struts 2.6.6.1 | MVC web framework               |
| JSP                   | Presentation layer              |
| JDBC                  | Database connectivity           |
| PostgreSQL            | Relational database             |
| Redis                 | Caching                         |
| Jedis                 | Java Redis client               |
| BCrypt                | Password hashing                |
| Maven                 | Dependency management and build |
| Apache Tomcat         | Web application server          |
| Git                   | Version control                 |
| GitHub                | Source code hosting             |

---

##  Architecture

The application follows a layered MVC-oriented architecture using Apache Struts.
                    ┌─────────────────────┐
                    │       Browser       │
                    │     JSP / HTML      │
                    └──────────┬──────────┘
                               │
                               ▼
                    ┌─────────────────────┐
                    │   Struts 2 Filter   │
                    │        MVC          │
                    └──────────┬──────────┘
                               │
                               ▼
                    ┌─────────────────────┐
                    │       Actions       │
                    │  Controller Layer   │
                    └──────────┬──────────┘
                               │
                    ┌──────────┴──────────┐
                    ▼                     ▼
          ┌──────────────────┐   ┌──────────────────┐
          │      DAO         │   │      Utility     │
          │ Data Access      │   │ Redis / Security │
          └────────┬─────────┘   └────────┬─────────┘
                   │                      │
                   ▼                      ▼
          ┌──────────────────┐   ┌──────────────────┐
          │   PostgreSQL     │   │      Redis       │
          │   Database       │   │      Cache       │
          └──────────────────┘   └──────────────────┘

## Project Structure
RailwayReservationSystem/
│
├── pom.xml
├── .gitignore
│
├── src/
│   └── main/
│       │
│       ├── java/
│       │   └── com/
│       │       └── railway/
│       │           │
│       │           ├── action/
│       │           │   ├── AddTrainAction.java
│       │           │   ├── AdminLoginAction.java
│       │           │   ├── BookTicketAction.java
│       │           │   ├── CancelTicketAction.java
│       │           │   ├── DeleteTrainAction.java
│       │           │   ├── LoginAction.java
│       │           │   ├── LogoutAction.java
│       │           │   ├── MyBookingsAction.java
│       │           │   ├── RegisterAction.java
│       │           │   ├── SearchPNRAction.java
│       │           │   ├── SearchTrainAction.java
│       │           │   ├── ViewBookingsAction.java
│       │           │   └── ViewTrainAction.java
│       │           │
│       │           ├── config/
│       │           │   └── DBConnection.java
│       │           │
│       │           ├── constant/
│       │           │   └── package-info.java
│       │           │
│       │           ├── dao/
│       │           │   ├── AdminDAO.java
│       │           │   ├── BookingDAO.java
│       │           │   ├── TrainDAO.java
│       │           │   ├── UserDAO.java
│       │           │   └── package-info.java
│       │           │
│       │           ├── exception/
│       │           │   └── package-info.java
│       │           │
│       │           ├── filter/
│       │           │   └── package-info.java
│       │           │
│       │           ├── model/
│       │           │   ├── Admin.java
│       │           │   ├── Booking.java
│       │           │   ├── RedisTest.java
│       │           │   ├── Train.java
│       │           │   ├── User.java
│       │           │   └── package-info.java
│       │           │
│       │           ├── service/
│       │           │   └── package-info.java
│       │           │
│       │           ├── util/
│       │           │   ├── AdminPasswordGenerator.java
│       │           │   ├── RedisUtil.java
│       │           │   ├── TestConnection.java
│       │           │   └── package-info.java
│       │           │
│       │           └── package-info.java
│       │
│       ├── resources/
│       │   └── struts.xml
│       │
│       └── webapp/
│           │
│           ├── index.jsp
│           ├── login.jsp
│           ├── register.jsp
│           ├── dashboard.jsp
│           │
│           ├── searchTrain.jsp
│           ├── searchResult.jsp
│           │
│           ├── bookTicket.jsp
│           ├── bookingSuccess.jsp
│           ├── myBookings.jsp
│           │
│           ├── searchPNR.jsp
│           ├── pnrResult.jsp
│           ├── success.jsp
│           │
│           ├── adminLogin.jsp
│           ├── adminDashboard.jsp
│           ├── addTrain.jsp
│           ├── viewTrains.jsp
│           ├── viewBookings.jsp
│           │
│           ├── META-INF/
│           │   └── MANIFEST.MF
│           │
│           └── WEB-INF/
│               ├── web.xml
│               └── lib/
│
└── .gitignore



## 🔄 Application Flow

### Passenger Flow

Registration
     │
     ▼
Login
     │
     ▼
Dashboard
     │
     ├──────────────► Search Train
     │                    │
     │                    ▼
     │              Search Results
     │                    │
     │                    ▼
     │              Book Ticket
     │                    │
     │                    ▼
     │              Seat Validation
     │                    │
     │                    ▼
     │              Generate PNR
     │                    │
     │                    ▼
     │             Booking Success
     │
     ├──────────────► My Bookings
     │                    │
     │                    ▼
     │              Cancel Ticket
     │
     └──────────────► Search PNR
                          │
                          ▼
                     PNR Result


### Admin Flow


Admin Login
     │
     ▼
Admin Dashboard
     │
     ├──────────────► Add Train
     │
     ├──────────────► View Trains
     │                    │
     │                    ▼
     │               Delete Train
     │
     └──────────────► View All Bookings


---

## 🧩 Package Responsibilities

### `action`

Contains Struts action classes that handle HTTP requests and control application flow.

Examples:

* `LoginAction`
* `RegisterAction`
* `SearchTrainAction`
* `BookTicketAction`
* `CancelTicketAction`
* `SearchPNRAction`
* `AdminLoginAction`
* `AddTrainAction`

---

### `dao`

Contains Data Access Objects responsible for interacting with PostgreSQL.


AdminDAO
BookingDAO
TrainDAO
UserDAO


The DAO layer separates database operations from the controller logic.



### `model`

Contains Java model/entity classes representing application data.

Admin
User
Train
Booking

---

### `config`

Contains application configuration classes.

DBConnection.java

This class is responsible for establishing the PostgreSQL database connection.

---

### `util`

Contains reusable utility functionality.

RedisUtil.java
AdminPasswordGenerator.java
TestConnection.java


`RedisUtil` provides Redis-related functionality.

---

### `resources`

Contains Struts configuration.


struts.xml


The Struts configuration maps incoming actions to Java action classes and JSP result pages.

---

### `webapp`

Contains the JSP presentation layer.

The JSP pages provide the user interface for:

* Authentication
* Train search
* Ticket booking
* Booking management
* PNR search
* Admin operations

---

##  Database

The application uses **PostgreSQL** as its relational database.

The database is used for persistent storage of application information such as:

* Users
* Administrators
* Trains
* Bookings
* Ticket-related information

> Configure your PostgreSQL database and update the database connection details in `DBConnection.java` before running the application.

---

## Redis Caching

Redis is integrated into the application as a caching layer.

Application
     │
     ▼
Train Search
     │
     ▼
Check Redis Cache
     │
     ├── Cache Hit ─────► Return Cached Data
     │
     └── Cache Miss
             │
             ▼
        PostgreSQL
             │
             ▼
        Store in Redis
             │
             ▼
        Return Result

Redis is used to reduce repeated database queries for frequently accessed train search data.

---

## Security

The application uses **BCrypt password hashing** for storing user passwords securely.

User Password
      │
      ▼
 BCrypt Hashing
      │
      ▼
Stored Password Hash


During authentication, the entered password is verified against the stored BCrypt hash instead of storing the plain-text password.

---

## Transaction Management

Ticket booking operations use database transaction handling to maintain data consistency.

The booking flow validates seat availability before completing the booking operation.


Start Transaction
       │
       ▼
Check Seat Availability
       │
       ├── Not Available ──► Rollback
       │
       ▼
Create Booking
       │
       ▼
Update Seat Information
       │
       ▼
Generate PNR
       │
       ▼
Commit Transaction
       │
       ▼
Booking Successful


---

##  Maven Configuration

The project uses Maven for dependency management and packaging.

The application is packaged as a WAR application:


<packaging>war</packaging>


Java version:
Java 17

Main dependencies include:

* Struts 2 Core
* Struts 2 Convention Plugin
* Jakarta Servlet API
* Jakarta JSP API
* PostgreSQL JDBC Driver
* JSTL
* BCrypt
* Jedis

---

## Prerequisites

Before running the project, install and configure:

* Java JDK 17
* Apache Maven
* PostgreSQL
* Redis
* Apache Tomcat
* Git

Verify Java: java -version

Verify Maven: mvn -version

Verify Git: git --version


Verify Redis: redis-cli ping


Expected response: PONG


---

## Clone the Repository

Clone the project using Git:
git clone https://github.com/Hariprasath2004/RailwayReservationSystem.git


Navigate to the project: cd RailwayReservationSystem


---

##  PostgreSQL Configuration

1. Install PostgreSQL.
2. Create the required database.
3. Create the required tables.
4. Update the PostgreSQL connection details in:

src/main/java/com/railway/config/DBConnection.java

Configure:

Database URL
Username
Password


> Do not commit real database passwords or other secrets to GitHub.

---

##  Redis Configuration

Start the Redis server: redis-server

Test the Redis connection: redis-cli ping


Expected: PONG


Configure Redis connection details according to the application's `RedisUtil.java`.

---

##  Build the Project

Run Maven build: mvn clean install


To create the WAR file: mvn clean package


The generated WAR file will be available under: target/
---

## Run the Application

Deploy the generated WAR file to an Apache Tomcat server.

Example: target/RailwayReservationSystem.war


Copy the WAR file into Tomcat's: webapps/


Start Tomcat.

Then open the application in a browser using your configured Tomcat URL.

Example: http://localhost:8080/RailwayReservationSystem/

##  Testing

The project contains utility classes for testing database and Redis connectivity.

Examples:
TestConnection.java
RedisTest.java


These can be used to verify that the application can communicate with PostgreSQL and Redis.

---

## Struts Action Mapping

Some of the configured Struts actions include:

| Action            | Purpose                  |
| ----------------- | ------------------------ |
| `login`           | User authentication      |
| `register`        | User registration        |
| `searchTrain`     | Search trains            |
| `bookTicket`      | Book ticket              |
| `myBookings`      | View user's bookings     |
| `cancelTicket`    | Cancel ticket            |
| `searchPNR`       | Search booking using PNR |
| `logout`          | Logout                   |
| `adminLogin`      | Admin authentication     |
| `addTrain`        | Add train                |
| `viewTrains`      | View trains              |
| `deleteTrain`     | Delete train             |
| `viewAllBookings` | View all bookings        |

---

## Future Enhancements

Possible future improvements include:

* Email notification for ticket booking
* Online payment integration
* Waiting-list management
* Role-based authorization improvements
* REST API integration
* Docker support
* Automated unit and integration testing
* CI/CD pipeline
* Improved UI/UX
* Railway schedule notifications

---

##  Author

**Hariprasath Ranjithkumar**

GitHub:

https://github.com/Hariprasath2004

Project Repository:

https://github.com/Hariprasath2004/RailwayReservationSystem

---

##  License

This project is developed for educational and portfolio purposes.
