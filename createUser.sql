CREATE TABLE users(
    id SERIAL UNIQUE PRIMARY KEY ,
    email TEXT NOT NULL,
    name TEXT NOT NULL,
    password TEXT not null
);
