# Speaking Clock Service

The Speaking Clock Service is a microservice-based application that provides functionality for validating and converting time formats. It consists of two microservices: Time Validation and Time Conversion.

## Time Validation Microservice

The Time Validation microservice is responsible for validating time inputs in the format HH:MM. It uses regular expressions to match the pattern and throws a validation exception if the input does not adhere to the required format.

### Endpoint

- `/validate-time`: Validates the time input and returns a response indicating whether the time format is valid or not.

**Request**
```
GET /validate-time?time={time}
```
**Response**
- HTTP Status: 200 OK (Valid time format)
    ```
    "Time is Valid"
    ```
- HTTP Status: 400 Bad Request (Invalid time format)
    ```
    "Invalid time format. Use HH:MM format."
    ```

## Time Conversion Microservice

The Time Conversion microservice handles the conversion of validated time inputs into a spoken representation. It verifies the validity of the time, checking if it falls within the acceptable range, and performs the conversion to a spoken format.

### Endpoint

- `/convert-time`: Converts the validated time input into a spoken representation and returns the converted time.

**Request**
```
GET /convert-time?time={time}
```
**Response**
- HTTP Status: 200 OK (Successful conversion)
    ```
    "It's [spoken representation of the time]"
    ```
- HTTP Status: 400 Bad Request (Invalid time or format)
    ```
    "Invalid Time Format" (If time is not in the expected range)
    ```

## Service Discovery with Eureka Server

Both microservices utilize Eureka Server for service discovery. Each microservice registers itself with the Eureka Server, allowing other microservices to locate and communicate with them using the registered service names instead of specific URLs.

## Swagger Documentation

Swagger is implemented in the Speaking Clock Service to provide interactive API documentation. You can access the Swagger UI for each microservice using the following URLs:

- Time Validation Microservice: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
- Time Conversion Microservice: [http://localhost:8081/swagger-ui/index.html](http://localhost:8081/swagger-ui/index.html)

## Getting Started

To run the Speaking Clock Service, follow these steps:

1. Start the Eureka Server: Run the Eureka Server application to enable service discovery.

2. Start the Time Validation Microservice: Run the Time Validation microservice on port 8080.

3. Start the Time Conversion Microservice: Run the Time Conversion microservice on port 8081.

4. Access the microservices' endpoints or Swagger UI to test the functionalities.

## Testing the Service

You can use tools like Postman or Swagger UI to test the Speaking Clock Service:

1. Use the Time Validation microservice's `/validate-time` endpoint to validate the time format.

2. If the time format is valid, use the Time Conversion microservice's `/convert-time` endpoint to convert the time into a spoken representation.

## Technologies Used

- Java
- Spring Boot
- Eureka Server
- RestTemplate
- Swagger

## Dependencies

The Speaking Clock Service has the following dependencies:

- Spring Boot Starter Web
- Spring Cloud Starter Netflix Eureka Client
- Springfox Swagger UI and Swagger2
- Other necessary dependencies for Spring Boot, Eureka Server, and Swagger

Make sure to include these dependencies in your build configuration (e.g., Maven or Gradle) to ensure smooth execution.

## Future Enhancements

The Speaking Clock Service can be further extended with additional features, such as support for different time zones, localization for spoken representations in multiple languages, and integration with other time-related services or APIs.

Feel free to contribute to the project or customize it to fit your specific requirements.