# FizzBuzz Rest server
This application is a backend rest server to get result of FizzBuzz game
# local build

This project can be build locally with maven wrapper:

    ./mvnw install
    
To run it on local environment the dev spring profile needs to be provided:

    java -jar -Dspring.profiles.active=dev fizzbuzz-backend-0.0.1-SNAPSHOT.jar

# Endpoints

    /{number}

accepts integer value and produces json response with the following schema:

    {
      "type": "object",
      "properties": {
        "input": {
          "type": "integer",
          "title": "Interpreted value of the input supplied in the request",
          "examples": [
            789
          ]
        },
        "result": {
          "type": "string",
          "title": "Result of the game",
          "examples": [
            "Fizz"
          ]
        }
      }
    }

Demo application can be found [here] 

# Design decisions made
   1) Service created with Spring Boot 2.0
   2) MVC error handling is configured in `RestResponseEntityExceptionHandler` class to provide JSON error responses to the client.
   3) Two Spring configuration files are provided (`dev` and `default`).
   4) `FizzBuzzResource` uses `FizzBuzzService` interface to obtain response and is it's only implementation at the moment is 'FizzBuzzServiceImpl'. By using the interface an alternative implementation can be added without any changes to the web layer.
   


[here]: https://fizz-buzz-backend.herokuapp.com/1
