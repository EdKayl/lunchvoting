DELETE FROM restaurant;
DELETE FROM menu;
DELETE FROM dish;
DELETE FROM vote;
DELETE from users;
DELETE from user_roles;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO restaurant (name) VALUES
('Praga'), ('NewYork');

INSERT INTO menu (restaurant_id, menu_date) VALUES
(100000, '2018-12-01 0:0:0'),
(100001, '2018-12-01 0:0:0'),
(100000, '2018-12-01 0:0:0'),
(100000, '2018-12-01 0:0:0');

INSERT INTO dish (menu_id, name, price) VALUES
(100002, 'рыба в кляре', 250),
(100002, 'свинная отбивная', 350),
(100002, 'плов', 230),
(100002, 'сок', 120),
(100003, 'гуляш', 260),
(100003, 'манты', 320),
(100003, 'уха', 150),
(100003, 'борщ', 200);

INSERT INTO users (name, email, password) VALUES
  ('User', 'user@yandex.ru', '{noop}password'),
  ('User2', 'user2@yandex.ru', '{noop}password'),
  ('User3', 'user3@yandex.ru', '{noop}password'),
  ('User4', 'user4@yandex.ru', '{noop}password'),
  ('User5', 'user5@yandex.ru', '{noop}password'),
  ('User6', 'user6@yandex.ru', '{noop}password'),
  ('User7', 'user7@yandex.ru', '{noop}password'),
  ('User8', 'user8@yandex.ru', '{noop}password'),
  ('Admin', 'admin@gmail.com', '{noop}password');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100014),
  ('ROLE_USER', 100015),
  ('ROLE_USER', 100016),
  ('ROLE_USER', 100017),
  ('ROLE_USER', 100018),
  ('ROLE_USER', 100019),
  ('ROLE_USER', 100020),
  ('ROLE_USER', 100021),
  ('ROLE_ADMIN', 100022),
  ('ROLE_USER', 100022);

INSERT INTO vote (menu_id, user_id, vote_date) VALUES
(100002, 100014, '2018-12-01 10:14:0'),
(100002, 100015, '2018-12-01 10:15:0'),
(100003, 100016, '2018-12-01 9:16:0'),
(100002, 100017, '2018-12-01 9:17:0'),
(100003, 100018, '2018-12-01 10:18:0'),
(100002, 100019, '2018-12-01 8:19:0'),
(100002, 100020, '2018-12-01 9:20:0'),
(100002, 100021, '2018-12-01 8:21:0');