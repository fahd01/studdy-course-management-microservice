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
    docker buid -t course-management-microservice:latest .
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
* [Keycloak](http://localhost:8080)
* [PhpMyAdmin (All DBs)](http:localhost:9000)
