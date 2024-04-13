1. Clone this repository in your IDE
   **NOTE: Please make sure you have Java 17 as well as latest MAVEN in your machine**
2. on the terminal run using :
     **mvn clean compile**
     then
     **mvn spring-boot:run**
3. Once the application is running. On postman you can test the APIs



APIs are listed below

1. **POST** http://localhost:8081/notes/createNote
    Please add requestbody you can use this JSON as an example
**    {
    "title": "Test Note",
    "body": "This is a test note."
    }
**

2. **GET** http://localhost:8081/notes/list
3. **GET** http://localhost:8081/notes/getNoteById/{id}  **{id} is a number**
4. **PUT** http://localhost:8081/notes/updateNote/{id}
**     {id} is a number
     Please also include request body similar to createNote**
5. **DELETE** http://localhost:8081/notes/deletNote/{id}
