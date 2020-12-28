DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS authorities;

CREATE TABLE users(
    id int NOT NULL AUTO_INCREMENT,
    username varchar_ignorecase(50) not null,
    password varchar_ignorecase(500) not null,
    random varchar(250)
);

CREATE TABLE authorities (
    id int NOT NULL AUTO_INCREMENT,
    username varchar_ignorecase(50) not null,
    authority varchar_ignorecase(50) not null,
    constraint fk_authorities_users foreign key(username) references users(username)
);

CREATE UNIQUE INDEX ix_auth_username on authorities (username, authority);

INSERT INTO users (username, password, random) VALUES
  ('marcus-chiu', '$2a$10$/6hk/sskm1GKnv5UotVPKeTdDf/imwpZuLCaaG7tq9d91kT.GE7uO', 'I ate a burger'),
  ('erina-chiu', '$2a$10$/6hk/sskm1GKnv5UotVPKeTdDf/imwpZuLCaaG7tq9d91kT.GE7uO', 'I ate food');
  -- System.out.println(new BCryptPasswordEncoder().encode("password"));

INSERT INTO authorities (username, authority) VALUES
  ('marcus-chiu', 'USER'),
  ('marcus-chiu', 'ADMIN'),
  ('erina-chiu', 'PLEBEIAN');