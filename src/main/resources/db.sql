CREATE TABLE IF NOT EXISTS professor (
  id SERIAL PRIMARY KEY,
  login VARCHAR(20) UNIQUE,
  password VARCHAR (20) NOT NULL
);

CREATE TABLE IF NOT EXISTS student (
  id SERIAL PRIMARY KEY,
  name VARCHAR(20) NOT NULL,
  mark1 INT NOT NULL,
  mark2 INT NOT NULL
);

INSERT INTO professor (login, password) VALUES ('smith', '777');
INSERT INTO professor (login, password) VALUES ('grey', '666');
