create table Users (
  id serial PRIMARY KEY,
  username VARCHAR (50) NOT NULL UNIQUE,
  password VARCHAR (50) NOT NULL,
  name VARCHAR (50) NOT NULL
);
CREATE TABLE priority (
  id serial PRIMARY KEY,
  priorityname VARCHAR (50) NOT NULL UNIQUE,
  priorityorder INTEGER NOT NULL UNIQUE CHECK(priorityorder < 4 AND priorityorder > 0)
);
CREATE TABLE status (
  id serial PRIMARY KEY,
  statusname VARCHAR (50) NOT NULL UNIQUE,
  statusorder INTEGER NOT NULL UNIQUE CHECK(statusorder < 3 AND statusorder > 0)
);
CREATE TABLE todolist (
  id serial PRIMARY KEY,
  todoname VARCHAR (50) NOT NULL,
  todotime TIMESTAMPTZ  NOT NULL,
  userid INTEGER REFERENCES users(id),
  priorityorder INTEGER REFERENCES priority(priorityorder),
  statusorder INTEGER REFERENCES status(statusorder)
);