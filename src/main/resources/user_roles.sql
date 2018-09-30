DROP TABLE IF EXISTS user_roles;

CREATE TABLE user_roles (
  id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(45) NOT NULL,
  role varchar(45) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username)
  ON DELETE CASCADE ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO user_roles (id, username, role) VALUES
(default, 'admin', 'ROLE_ADMIN'),
(default, 'testUser', 'ROLE_USER');