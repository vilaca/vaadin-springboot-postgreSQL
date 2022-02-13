CREATE USER um_guest;
CREATE DATABASE um;
GRANT ALL PRIVILEGES ON DATABASE um TO um_guest;

\connect um um_guest;

CREATE TABLE users (
    id      SERIAL PRIMARY KEY,
    name    TEXT NOT NULL,
    email   TEXT NOT NULL,
    enabled BOOLEAN NOT NULL DEFAULT TRUE,
    created TIMESTAMP NOT NULL
);
