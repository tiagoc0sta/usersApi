# Users API - Spring Boot RESTful Service



This project is a RESTful API for managing users, built with Spring Boot. It demonstrates basic CRUD operations (Create, Read, Update, Delete) for user data, using an in-memory database. The project includes endpoints for fetching all users, fetching users by ID, creating new users, updating existing users, and deleting users. It is preloaded with sample data and can be easily tested with a Postman collection included in the project.


## API Features

- User Management: Full CRUD operations (Create, Read, Update, Delete) for users. Users can be retrieved by ID or as a full list.
- In-Memory Database: Uses an in-memory database to store user data for easy testing and development.
- Preloaded Sample Data: Loads initial user data from a JSON file at startup if the database is empty.
- Error Handling: Custom error handling for cases like user not found.
- JSON Input/Output: API accepts and returns data in JSON format.
- Postman Collection: Includes a Postman collection for testing API endpoints.
- Spring Boot Architecture: Built using Spring Boot 3.3.4 and Java 21 adhering to standard project structure and practices.



## Deployment

To deploy this project:

### Prerequisites

- Java 21
- Maven
- Spring Boot 3.3.4

### Running the Application

1. Clone the repository:
   ```bash
   git clone https://github.com/tiagoc0sta/usersApi.git
   cd usersApi
### API Reference

#### Get all users

GET /api/users

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| None      | N/A      | No parameters are required to get all users. |

#### Get user by ID
GET /api/users/{id}

| Parameter | Type      | Description                       |
| :-------- | :-------- | :-------------------------------- |
| id        | integer   | **Required**. The ID of the user to fetch. |

#### Create a user
POST /api/users

| Parameter  | Type     | Description                                  |
| :--------- | :------- | :------------------------------------------- |
| userName   | string   | **Required**. The username of the new user.  |
| firstName  | string   | **Required**. The first name of the new user.|
| lastName   | string   | **Required**. The last name of the new user. |
| email      | string   | **Required**. The email of the new user.     |
| phone      | string   | **Optional**. The phone number of the new user. |

#### Update a user

PUT /api/users/{id}

| Parameter  | Type      | Description                                  |
| :--------- | :-------- | :------------------------------------------- |
| id         | integer   | **Required**. The ID of the user to update.  |
| userName   | string    | **Optional**. The new username.              |
| firstName  | string    | **Optional**. The new first name.            |
| lastName   | string    | **Optional**. The new last name.             |
| email      | string    | **Optional**. The new email.                 |
| phone      | string    | **Optional**. The new phone number.          |

#### Delete a user
DELETE /api/users/{id}

| Parameter | Type      | Description                       |
| :-------- | :-------- | :-------------------------------- |
| id        | integer   | **Required**. The ID of the user to delete. |



## Preview

#### localhost
##### http://localhost:8080/api/users
![image](https://github.com/user-attachments/assets/076b5c23-a653-4917-993c-db29ecaf976b)


#### postman
##### Please user the file: users-API-postman-collection.json inside Postman folder.
![image](https://github.com/user-attachments/assets/07ec42e9-bbb2-4958-b34f-37a9ef005e58)


#### H2 database
##### http://localhost:8080/h2-console
##### JDBC URL: jdbc:h2:mem:usersApi
##### User Name: sa
##### Password:
![image](https://github.com/user-attachments/assets/0a4e362b-2ed5-45a0-a8b7-421803a228dd)
![image](https://github.com/user-attachments/assets/be30e9e3-9ee7-45fa-a187-798f394d633d)


#### Swagger
##### http://localhost:8080/swagger-ui/index.html#
![image](https://github.com/user-attachments/assets/1da2aa80-1df1-44cd-a961-7f71c44da74c)
