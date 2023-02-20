CREATE TABLE IF NOT EXISTS Account (
    id SERIAL PRIMARY KEY ,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

INSERT INTO Account(username,password)
VALUES ('user1', 'password1');

INSERT INTO Account(username,password)
VALUES ('user2', 'password2');