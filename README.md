# Faulty Calculator Service

A small Spring Boot REST API that exposes basic calculator operations. As the name suggests, the service is intentionally imperfect — it makes a good target for practicing API testing (edge cases such as division by zero, negative square roots, integer overflow in `factorial`, and empty lists in `average` are left unhandled on purpose).

## Requirements

- Java 25
- No local Maven needed — the Maven wrapper (`./mvnw`) is included

## Running the service

```bash
./mvnw spring-boot:run
```

The service starts on http://localhost:8080.

## API

All endpoints are `GET` requests with query parameters and return a plain numeric result.

| Endpoint     | Parameters                          | Description                              | Example                                  |
|--------------|-------------------------------------|------------------------------------------|------------------------------------------|
| `/sum`       | `a`, `b` (double)                   | Add two numbers                          | `/sum?a=2&b=3` → `5.0`                   |
| `/subtract`  | `a`, `b` (double)                   | Subtract `b` from `a`                    | `/subtract?a=5&b=3` → `2.0`              |
| `/multiply`  | `a`, `b` (double)                   | Multiply two numbers                     | `/multiply?a=2&b=3` → `6.0`              |
| `/divide`    | `a`, `b` (int)                      | Integer division                         | `/divide?a=6&b=3` → `2`                  |
| `/modulo`    | `a`, `b` (int)                      | Remainder of `a` divided by `b`          | `/modulo?a=7&b=3` → `1`                  |
| `/power`     | `a`, `b` (double)                   | Raise `a` to the power `b`               | `/power?a=2&b=10` → `1024.0`             |
| `/sqrt`      | `a` (double)                        | Square root of `a`                       | `/sqrt?a=9` → `3.0`                      |
| `/average`   | `numbers` (comma-separated doubles) | Average of a list of numbers             | `/average?numbers=2,4,6` → `4.0`         |
| `/factorial` | `n` (int)                           | Factorial of `n`                         | `/factorial?n=5` → `120`                 |

The full OpenAPI 3 specification is available at [`src/main/resources/static/openapi.yml`](src/main/resources/static/openapi.yml), and is served by the running application at http://localhost:8080/openapi.yml.

## Running the tests

```bash
./mvnw test
```

The tests in [`CalculatorControllerTest`](src/test/java/com/polteq/service/CalculatorControllerTest.java) cover the happy path of each endpoint using `MockMvc`.

## Project structure

```
src/main/java/com/polteq/service/
├── FaultyCalculatorServiceApplication.java   # Spring Boot entry point
└── CalculatorController.java                 # All calculator endpoints
src/main/resources/static/openapi.yml         # OpenAPI 3 specification
src/test/java/com/polteq/service/
└── CalculatorControllerTest.java             # MockMvc happy-path tests
```
