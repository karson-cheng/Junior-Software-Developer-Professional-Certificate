DROP TABLE IF EXISTS user;

CREATE TABLE user (
  user_id int NOT NULL AUTO_INCREMENT,
  first_name varchar(50) NOT NULL,
  last_name varchar(50) DEFAULT NULL,
  reward_points int NOT NULL DEFAULT '0',
  PRIMARY KEY (user_id) 
);

INSERT INTO user VALUES (1,'John','Doe',14320),(2,'Jane','Doe',12050),(3,'Michael','Smith',11340),(4,'Emily','Jones',9800),(5,'David','Lee', 15430);