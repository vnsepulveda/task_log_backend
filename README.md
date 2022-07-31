# Task Management
Backend created with Spring Boot to management tasks.

To run Project with Docker: 

1. run *docker-compose up* to start project, nothing else needed.

To run Project without Docker:

1. Create PostgreSQL db called task_manager.
2. Change your username and password in the application.properties file as accordingly (datasource.username & datasource.password).
3. Run the project with your favorite IDE.

DB script: 

create table task (
  id  serial not null,
  description varchar(255) not null,
  insert_time timestamp not null,
  valid boolean not null,
  primary key (id)
)

To see de docs, enter: **http://localhost:8080/swagger-ui.html** after the project has been runned.

