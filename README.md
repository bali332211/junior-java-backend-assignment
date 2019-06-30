README
======

[Requirements](Requirements.md)

# Note Management Application

## To run the application in Docker:
```
docker-compose up
```

Docker-compose environment variables in _.env_ file. Hostname, role, database names are given without these variables in sql file for container in /database and in docker-compose.yml. Application.properties has POSTGRES_HOSTNAME to set as well.

### Endpoints:
> #### /
Main page for web socket connection

> #### /api/save-note
Accepts note JSON payload
   ```json
    {
      "content": "abrakadabra",
      "timestamp": "2018-10-09 00:12:12+0100"
    }
   ```
> #### /api/all-notes
Displays all notes currently in database in JSON

## Technologies and traits of project
- Java SpringBoot
- Payload validation for /api/save-note using @Valid
  - Empty fields
  - Timestamp format
- PostgreSQL
- Flyway
- Thymeleaf html fragment
- H2 database for testing
- API, validation, repository, palindrome finder tests with 100% pitest mutation and line coverage
```
mvnw org.pitest:pitest-maven:mutationCoverage
```
Html generated in /target/pitest-reports/timestamp
- Main page timestamps calculated by frontend JS
- Responsive css for mobile
