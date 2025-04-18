# Docker

* List running containers
    ```shell
    docker ps
    ```

* List local images
    ```shell
    docker images
    ```

* Build course management microservice
    ```shell
    docker build -t fahdech/course-management-microservice:1.0.0 .
    ```

* Push course management microservice
    ```shell
    docker push fahdech/course-management-microservice:1.0.0
    ```
  
* Build Api Gateway
  ```shell
  docker build -t studdy-course-management-microservice-api-gateway:latest ./infrastructure/api-gateway
  ```  

* Docker compose
    ```shell
    docker compose up
    ```

    ```shell
    docker compose down
    ```
  
* Connect to DockerHub 
`docker login -u fahdech`
pwd: dckr_pat_9X0OizJdBqmshYpVvpXjIQkqJIo

## Management Links
* [Spring Admin Dashboard](http://localhost:8767/wallboard)
* [Eureka Server Dashboard](http://localhost:8761)
* [Actuator (Course Management Service)](http://localhost:9001/actuator)
* [Api Gateway](http://localhost:8768)
* [Keycloak](http://localhost:8080)
* [PhpMyAdmin (All DBs)](http:localhost:9000)
* Services:
  * user management   -> http://localhost:8081 | http://localhost:9001
  * course management -> http://localhost:8082 | http://localhost:9002
  * stage management  -> http://localhost:8082 | http://localhost:9003
