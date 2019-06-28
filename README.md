README
======

[Requirements](Requirements.md)

# Junior Backend Assignment Note Management Application

## To run the application:
```
./mvnw clean package && docker-compose build && docker-compose up
```

### Endpoints:
/
> Main page for web socket connection
/api/save-note
> Accepts note JSON payload

	Payload structure:
    ```json
    {
      "content": "abrakadabra",
      "timestamp": "2018-10-09 00:12:12+0100"
    }
    ```
/api/all-notes
> Displays all notes currently in database in JSON

Environment variables in _.env_ file

## Technologies and traits of project
- Java SpringBoot
- Payload validation for /api/save-note using @Valid
  - Empty fields
  - Timestamp format 2018-10-09 00:12:12+0100
- PostgreSQL
- Flyway
- Thymeleaf html fragment
- API, validation, repository, palindrome finder tests with 100% pitest mutation and line coverage
```
mvnw org.pitest:pitest-maven:mutationCoverage
```
- Main page timestamps calculated by frontend JS
- Responsive css for mobile