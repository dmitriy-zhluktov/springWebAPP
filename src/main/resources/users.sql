DROP TABLE IF EXISTS users;

CREATE  TABLE users (
  id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(45) NOT NULL,
  password varchar(45) NOT NULL,
  enabled boolean NOT NULL DEFAULT TRUE,
  PRIMARY KEY (id),
  KEY (username))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO users(id, username, password, enabled) VALUES
(default, 'admin','123', true),
(default, 'testUser','123', true);