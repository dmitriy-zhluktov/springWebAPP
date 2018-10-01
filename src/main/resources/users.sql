DROP TABLE IF EXISTS users;

CREATE  TABLE users (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(45) NOT NULL,
  password varchar(45) NOT NULL,
  enabled boolean NOT NULL DEFAULT TRUE,
  PRIMARY KEY (id))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

INSERT INTO users(id, name, password, enabled) VALUES
  (default, 'admin','123', true),
  (default, 'testUser','123', true);