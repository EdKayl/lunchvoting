DROP TABLE IF EXISTS vote;
DROP TABLE IF EXISTS dish ;
DROP TABLE IF EXISTS menu;
DROP TABLE IF EXISTS restaurant;
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE GLOBAL_SEQ START WITH 100000;


CREATE TABLE restaurant (
   id     INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
   name   VARCHAR(255)     NOT NULL
);

CREATE TABLE menu (
  id              INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  restaurant_id   INTEGER       NOT NULL,
  menu_date       TIMESTAMP     NOT NULL,
  FOREIGN KEY (restaurant_id) REFERENCES restaurant (id) ON DELETE CASCADE
);

CREATE TABLE dish (
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  menu_id     INTEGER     NOT NULL,
  name        VARCHAR(255)     NOT NULL,
  price       INTEGER     NOT NULL,
  FOREIGN KEY (menu_id) REFERENCES menu (id) ON DELETE CASCADE
);

CREATE TABLE users (
  id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name             VARCHAR(255)                 NOT NULL,
  email            VARCHAR(255)                 NOT NULL,
  password         VARCHAR(255)                 NOT NULL,
  registered       TIMESTAMP DEFAULT now() NOT NULL,
  enabled          BOOLEAN DEFAULT TRUE       NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR(255),
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE vote (
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  menu_id     INTEGER         NOT NULL,
  user_id     INTEGER         NOT NULL,
  vote_date   TIMESTAMP       NOT NULL,
  FOREIGN KEY (menu_id) REFERENCES menu (id) ON DELETE CASCADE,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);