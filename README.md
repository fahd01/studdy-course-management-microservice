# Studdy Course Management Microservice

## Links
App:
- Frontend http://localhost:4200
- Microservices
  - Course Management 
    - http://localhost:8082
    - http://localhost:9001/actuator
  - User Management
    - http://localhost:8081
    - http://localhost:9002/actuator
  - Stage Management
    - http://localhost:8089
    - http://localhost:9003/actuator
Monitoring and Infrastructure
- PHPMyAdmin 
  - Keycloak and Services DB: http://localhost:9000
  - Course Management DB: http://localhost:8180
- Keycloak: http://localhost:8080
- Spring Admin: http://localhost:8767
- Eureka: http://localhost:8761
- API Gateway: http://localhost:8768
- Spring Config Server
  - http://localhost:8888
  - http://localhost:9004/actuator


## Tasks
- Standardize the project structure, naming and code style
- Integrate Blog management microservice
- Keycloak Integration
- API Gateway: Send all requests to backend through API Gateway
- preloaded data in mysql docker container or in spring boot app (managed by an env variable)