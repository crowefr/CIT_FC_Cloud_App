create table ATHLETE(id serial, username varchar, password varchar, fname varchar, sname varchar, country varchar, event varchar, primary key(id));
create table EVENT(id serial, venue varchar, eventDate varchar, winner varchar, primary key(id));
create table users(username varchar_ignorecase(50) not null primary key, password varchar_ignorecase(50) not null, enabled boolean not null);
create table authorities(username varchar_ignorecase(50) not null, authority varchar_ignorecase(50) not null, constraint fk_authorities_users foreign key(username) references users(username));
create unique index ix_auth_username on authorities (username,authority);
INSERT INTO users VALUES ('fccloud', '0xCF142', true);
INSERT INTO authorities VALUES ('fccloud', 'ROLE_ADMIN');