DROP TABLE IF EXISTS user_roles;

CREATE TABLE user_roles (
  id int(11) NOT NULL AUTO_INCREMENT,
  user_id int(11) NOT NULL,
  role varchar(45) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_userid FOREIGN KEY (user_id) REFERENCES users (id)
    ON DELETE CASCADE ON UPDATE CASCADE)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

INSERT INTO user_roles (id, user_id, role) VALUES
  (default, 1, 'ROLE_ADMIN'),
  (default, 2, 'ROLE_USER');