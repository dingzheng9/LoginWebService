# demo-login-service

[![License](https://img.shields.io/badge/license-EPL-blue.svg)](LICENSE)

## Description

This is the backend service for the demo login application. It provides authentication and authorization features using JWT tokens.

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Database Initialization](#database-initialization)

## Installation

To run this project locally on command prompt or a console, follow these steps:

1. Clone the repository:

   ```bash
   git clone https://github.com/dingzheng9/LoginWebService.git

   ```

2. Navigate to the project directory:

   ```bash
   cd demo-login-service

   ```

3. Build and run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

To run this project locally on Eclipse, follow these steps:

1. **Clone the Repository:** Start by cloning this Git repository to your local machine. You can do this using the following command:

   ```
   git clone https://github.com/dingzheng9/LoginWebService.git
   ```

2. **Open Eclipse:** Launch Eclipse IDE on your computer.

3. **Import the Project:**

   - In Eclipse, click on `File` > `Import`.
   - In the Import dialog, select `Existing Gradle Project` under the `Gradle` folder and click `Next`.

4. **Browse for the Project:** Click on the `Browse` button to locate and select the directory where you cloned the project repository. The project should now appear in the list of available projects. Select it and click `Finish`.

5. **Build the Project:**

   - In Eclipse, navigate to the Project Explorer panel on the left.
   - Locate the `demo-login-service` project, right-click on it, and select `Run As` > `Maven build...`.
   - In the "Goals" field, type `clean install`.
   - Click the "Run" button.

6. **Run the Application:** Go to `src/main/java` > `com.interviewco.login.demo_login_service` > "Right click" `DemoLoginServiceApplication.java` "Select" `Run As` "Java application".

7. **Access the Application:** Once the application is running, you can access it by opening a web browser and navigating to `http://localhost:8080`. You can use Postman or any other API testing tool to interact with the RESTful endpoints provided by the application.

8. **Login:** To test the login functionality, use the `/api/auth/login` endpoint. Provide the appropriate username and password in the request body to obtain a JWT token.

That's it! You have successfully set up and run this project locally on Eclipse.

## Usage

You can access the API endpoints to perform various authentication and authorization tasks. Make sure to configure the frontend application to interact with this backend service.

## API Endpoints

By default localhost should be pointing to 8080.

    locahost:8080/api/auth/login
    localhost:8080/h2-console

### Postman

1. Create a New Request:
   Click on the "New" button in the top-left corner.
   Give your request a name, such as "Login."
   Choose the **Request Type**:

2. Select the HTTP **POST** request method from the dropdown next to the URL field. Enter the API URL: http://localhost:8080/api/auth/login

3. This API requires headers (, you can add them in the "Headers" section. **Key**: "Content-Type", **Value**: "application/json"

4. Add Request Body:

   1. Switch to the "Body" tab.
   2. Select the "raw" option.
   3. Choose the "JSON (application/json)" option from the dropdown.
   4. Enter a JSON object with your login credentials. For example:

   ```bash
   {
   "username": "username",
   "password": "password"
   }


   ```

### cURL

    curl --location 'http://localhost:8080/api/auth/login' \
    --header 'Content-Type: application/json' \
    --data '{
        "username": "username",
        "password": "password"
    }
    '

### User accounts for login

This login service does not include a user registration feature, so passwords have been pre-hashed during the initial data seeding process. This are the follow accounts:

    username: `user`
    password: `password`

    username: `mgr`
    password: `password`

    username: `dz`
    password: `123qwe`

    username: `乐乐`
    password: `password`

## Database Initialization

To initialize the database with sample data, the application uses SQL scripts located in the `src/main/resources` directory.

    * schema.sql: Defines the database schema.
    * data.sql: Inserts sample data into the database.

If you're able to run the application, the data initialization should be done.

Do check if users data are in the table,
`if no data exist please follow the steps from step 5 below. `

If you encounter error during database initialization, please follow the steps below:

1. In src/main/resources open **application.properties**
2. Comment out or remove line 12 to 19
   ```bash
   spring.datasource.initialization-mode=always
   spring.datasource.schema=classpath:schema.sql
   spring.datasource.data=classpath:data.sql
   ```
3. Save and terminate the application
4. Update and rebuild the application
5. Upon running, on your browser go to `localhost:8080/h2-console`
6. Click connect on `H2 Console`.
7. Firstly, open `src/main/resources/schema.sql`, copy, paste and run the query.
8. Subsequently, open `src/main/resources/data.sql`, copy, paste and run the query.
9. By running the select statement, you will see 3 users.
10. Database Initialization Completed.

## Database Access (H2 Console)

```bash
Driver Class: org.h2.Driver
JDBC URL: jdbc:h2:mem:testdb
User Name: sa
Password:
```

Click `Connect`
