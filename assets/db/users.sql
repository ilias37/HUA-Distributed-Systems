DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS users;


CREATE TABLE IF NOT exists users (
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(100) NOT NULL,
    enabled BOOLEAN NOT NULL
);


CREATE TABLE IF NOT EXISTS authorities (
    username VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    UNIQUE(username,authority),
    CONSTRAINT fk_authorities_users FOREIGN KEY (username) REFERENCES users(username)
);


INSERT INTO users (username, password, enabled) VALUES
    ('actor1', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 't'),
    ('actor2', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 't'),
    ('notary1', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 't'),
    ('notary2', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 't'),
    ('admin1', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 't'),
    ('admin2', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 't')
;


INSERT INTO authorities(username, authority) VALUES
    ('actor1', 'ROLE_ACTOR'),
    ('actor2', 'ROLE_ACTOR'),
    ('notary1', 'ROLE_NOTARY'),
    ('notary2', 'ROLE_NOTARY'),
    ('admin1', 'ROLE_ADMIN'),
    ('admin2', 'ROLE_ADMIN')
;


INSERT INTO actors(username, firstname, lastname, email) VALUES
    ('john', 'John', 'Ajohn', 'john@hua.gr'),
    ('nick', 'Nick', 'Anick', 'nick@hua.gr'),
    ('pavlos', 'Pavlos', 'Apavlos', 'pavlos@hua.gr'),
    ('mike', 'Mike', 'Amike', 'mike@hua.gr')
;


INSERT INTO notaries(username, firstname, lastname, email) VALUES
    ('symbol1', 'Symbol1', 'Asymbol1', 'symbol1@hua.gr'),
    ('symbol2', 'Symbol2', 'Asymbol2', 'symbol2@hua.gr'),
    ('symbol3', 'Symbol3', 'Asymbol3', 'symbol3@hua.gr')
;


INSERT INTO contracts(notaryid, sellerid, buyerid, address, tax, sellerdec, buyerdec) VALUES    
    (2, 1, 2, 'Tripolitsas 12', 100, false, false),
    (2, 1, 3, 'Dramas 34', 200, false, false),
    (3, 2, 4, 'Ioanninwn 56', 300, false, false)
;