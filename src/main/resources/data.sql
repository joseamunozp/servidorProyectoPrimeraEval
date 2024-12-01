INSERT INTO status (status_name) VALUES ('In Progress'), ('Completed');

INSERT INTO technologies (tech_name) VALUES ('Java'), ('Spring Boot'), ('MySQL');

INSERT INTO developers (dev_name, dev_surname, email) 
VALUES ('John', 'Doe', 'john.doe@example.com'), 
       ('Jane', 'Smith', 'jane.smith@example.com');

INSERT INTO projects (project_name, description, start_date, end_date, status_status_id)
VALUES ('Project A', 'Description for project A', '2024-01-01', '2024-12-31', 1);
