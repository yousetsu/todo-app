-- src/main/resources/db/migration/V1__create_todos.sql
CREATE TABLE todos (
                       id BIGSERIAL PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       completed BOOLEAN NOT NULL DEFAULT FALSE
);
