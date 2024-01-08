INSERT INTO users
VALUES
('spring','{noop}hello-spring',1),
('john','{noop}hello-spring',1),
('tom','{noop}hello-tom',1);

INSERT INTO authorities
VALUES
('spring','ROLE_ADMIN'),
('john','ROLE_MANAGER'),
('tom','ROLE_USER');