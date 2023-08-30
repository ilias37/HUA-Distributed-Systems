--DROP TABLE IF EXISTS authorities;
--DROP TABLE IF EXISTS users;
--
--
--CREATE TABLE IF NOT exists users (
--    username VARCHAR(50) PRIMARY KEY,
--    password VARCHAR(100) NOT NULL,
--    enabled BOOLEAN NOT NULL
--);
--
--
--CREATE TABLE IF NOT EXISTS authorities (
--    username VARCHAR(50) NOT NULL,
--    authority VARCHAR(50) NOT NULL,
--    UNIQUE(username,authority),
--    CONSTRAINT fk_authorities_users FOREIGN KEY (username) REFERENCES users(username)
--);


INSERT INTO users (username, password, enabled) VALUES
    ('actor1', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 't'),
    ('actor2', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 't'),
    ('actor3', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 't'),
    ('actor4', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 't'),
    ('notary1', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 't'),
    ('notary2', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 't'),
    ('notary3', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 't'),
    ('admin1', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 't'),
    ('admin2', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 't')
;


INSERT INTO authorities(username, authority) VALUES
    ('actor1', 'ROLE_ACTOR'),
    ('actor2', 'ROLE_ACTOR'),
    ('actor3', 'ROLE_ACTOR'),
    ('actor4', 'ROLE_ACTOR'),
    ('notary1', 'ROLE_NOTARY'),
    ('notary2', 'ROLE_NOTARY'),
    ('notary3', 'ROLE_NOTARY'),
    ('admin1', 'ROLE_ADMIN'),
    ('admin2', 'ROLE_ADMIN')
;


INSERT INTO actors(username, firstname, lastname, email) VALUES
    ('actor1', 'Actor1', 'One1', 'actor1@hua.gr'),
    ('actor2', 'Actor2', 'Two2', 'actor2@hua.gr'),
    ('actor3', 'Actor3', 'Three3', 'actor3@hua.gr'),
    ('actor4', 'Actor4', 'Four4', 'actor4@hua.gr')
;    


INSERT INTO notaries(username, firstname, lastname, email) VALUES
    ('notary1', 'Notary1', 'One1', 'notary1@hua.gr'),
    ('notary2', 'Notary2', 'Two2', 'notary2@hua.gr'),
    ('notary3', 'Notary3', 'Three3', 'notary3@hua.gr')
;    


INSERT INTO contracts(notaryid, sellerid, buyerid, address, tax, sellerdec, buyerdec) VALUES    
    (2, 1, 2, 'Tripolitsas 12', 100, false, false),
    (2, 1, 3, 'Dramas 34', 200, false, false),
    (3, 2, 4, 'Ioanninwn 56', 300, false, false)
;


--INSERT INTO userreg (username, firstname, lastname, email, password, role) VALUES
--    ('actor1', 'Actor1', 'One1', 'actor1@hua.gr', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 'ROLE_ACTOR'),
--    ('actor2', 'Actor2', 'Two2', 'actor2@hua.gr', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 'ROLE_ACTOR'),
--    ('actor3', 'Actor3', 'Three3', 'actor3@hua.gr', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 'ROLE_ACTOR'),
--    ('actor4', 'Actor4', 'Four4', 'actor4@hua.gr', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 'ROLE_ACTOR'),
--    ('notary1', 'Notary1', 'One1', 'notary1@hua.gr', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 'ROLE_NOTARY'),
--    ('notary2', 'Notary2', 'Two2', 'notary2@hua.gr', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 'ROLE_NOTARY'),
--    ('notary3', 'Notary3', 'Three3', 'notary3@hua.gr', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 'ROLE_NOTARY')
--;
--

-------------------------------------------------------------------------------------------

--create table actors (
--    id  serial not null,
--    email varchar(50),
--    firstName varchar(30),
--    lastName varchar(30),
--    username varchar(255),
--	primary key (id)
--);
--
--    
--create table contracts (
--    id  serial not null,
--    address varchar(30),
--    buyerdec boolean,
--    buyerId int4 not null,
--    notaryId int4 not null,
--    sellerdec boolean,
--    sellerId int4 not null,
--    tax int4 not null,
--    primary key (id)
--);
--
--    
--create table notaries (
--   id  serial not null,
--    email varchar(50),
--    firstName varchar(30),
--    lastName varchar(30),
--    username varchar(255),
--    primary key (id)
--);
--
--    
--alter table actors drop constraint UK_dqey1tbodurhtadt040er82k1;
--
--    
--alter table actors add constraint UK_dqey1tbodurhtadt040er82k1 unique (email);
--
--       
--alter table actors drop constraint UK_syugrn88hpahn8ypmrwnvwkd4;
--
--    
--alter table actors add constraint UK_syugrn88hpahn8ypmrwnvwkd4 unique (username);
--
--    
--alter table notaries drop constraint UK_d4sfwehfheox3uibhic99o2rp;
-- 
--    
--alter table notaries add constraint UK_d4sfwehfheox3uibhic99o2rp unique (email);
--
--    
--alter table notaries drop constraint UK_s7wrm7vf8w19213bkwkr6kyie;
--
--    
--alter table notaries add constraint UK_s7wrm7vf8w19213bkwkr6kyie unique (username);