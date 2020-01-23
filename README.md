## Пимер API REST CRUD с Spring Boot, PostgreSQL, JPA и Hibernate

### Шаги по настройке

##### 1. Клонируйте приложение

> **https://github.com/niyazkadirov/SpringRestfull.git**

##### 2. Создайте базу данных

> **create database your_database**

##### 3. Измените имя пользователя, пароль и название базы данных PostgreSQL

> октройте **src/main/resources/application.properties**  

> измените **spring.datasource.url=jdbc:postgresql://localhost/your_database**   

> так же **spring.datasource.username** и **spring.datasource.password** согласно вашей установке PostgreSQL 

##### 4. Создайте и запустите приложение, используя Maven

> mvn spring-boot:run

Приложение начнет работу по следующему адресу **http://localhost:8080**

## REST APIs

Для быстрого тестирования CRUD методов, вы можете использовать Swagger 2 API по адресу **http://localhost:8080/swagger-ui.html**
