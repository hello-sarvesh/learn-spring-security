DROP TABLE IF EXISTS users;

CREATE TABLE users (
    username varchar(50) NOT NULL,
    password varchar(50) NOT NULL,
    enabled tinyint NOT NULL,
    PRIMARY KEY (username)
)

DROP TABLE IF EXISTS authoriries

CREATE TABLE authorities (
    username varchar(50) NOT NULL,
    authority varchar(50) NOT NULL
    -- UNIQUE KEY authorities_idx_1 (username,authority),
    -- CONSTRAINT authorities_idfk_1 FOREIGN KEY (username) REFERENCES users(username)
)