CREATE TABLE topics
(
    id   serial primary key,
    name VARCHAR(255),
    description TEXT
);

CREATE TABLE posts
(
    id       SERIAL PRIMARY KEY,
    name     VARCHAR(255),
    description     TEXT,
    created  TIMESTAMP,
    topic_id INT REFERENCES topics (id)
);

CREATE TABLE messages
(
    id       SERIAL PRIMARY KEY,
    text     TEXT,
    username VARCHAR(255),
    created  TIMESTAMP,
    post_id  INT REFERENCES posts (id)
);


CREATE TABLE authorities
(
    id        serial primary key,
    authority VARCHAR(50) NOT NULL unique
);

CREATE TABLE users
(
    id           serial primary key,
    username     VARCHAR(50)  NOT NULL unique,
    password     VARCHAR(100) NOT NULL,
    enabled      boolean default true,
    authority_id int          not null references authorities (id)
);