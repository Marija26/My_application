DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS global_sequence;

CREATE SEQUENCE global_sequence START 10000;

CREATE TABLE users(
  userid INTEGER PRIMARY KEY DEFAULT nextval('global_sequence'),
  firstname VARCHAR NOT NULL,
  lastname VARCHAR(45) NOT NULL,
  dob DATE DEFAULT NULL,
  email VARCHAR NOT NULL
);