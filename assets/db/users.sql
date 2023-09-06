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