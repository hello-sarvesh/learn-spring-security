-- INSERT INTO members
-- VALUES
-- ('spring','{noop}hello-spring',1),
-- ('john','{noop}hello-john',1),
-- ('tom','{noop}hello-tom',1);

-- Bcrpt Password
INSERT INTO members
VALUES
('spring','{bcrypt}$2a$10$gMALp3vlGqUNnyfuGlU45e2AzIhWZFUzaGhRptT2wTHMZ1VEoI5R6',1),
('john','{bcrypt}$2a$10$nwNgLb0OBpFNvLu6bm4x2ejXHkYN2anXTtHQZhXYs3hw0uzTCmGCi',1),
('tom','{bcrypt}$2a$10$PPVc9I1HECLh/3bfRjdgguUTcoJU9uUTQF09GsnLtm5pMW2LLfnGu',1);


INSERT INTO roles
VALUES
('spring','ROLE_ADMIN'),
('john','ROLE_MANAGER'),
('tom','ROLE_USER');