#

# --- !Ups

CREATE TABLE employee (
  id                 SERIAL           PRIMARY KEY,
  name               VARCHAR(256)      NOT NULL
);


# --- !Downs

DROP TABLE employee;


