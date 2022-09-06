#MOVIE LIBRARY with REST API
<br />
<br />
stack: Java, SpringBoot, Maven, JDBC to connect with database, MySQL db in Docker container 
<br />
<br />
REST methods implemented:
- GET - getAll() to display all movies, getById() display 1 movie
- POST - add(), adds list of movies
- PUT - update() updates all fields of a movie, by id
- PATCH - updatePartially() updates any fields we want of a movie, by id
- DELETE - delete() deletes the movie, by id
<br />
to run:

- mvn clean install
- mvn spring-boot:run

