CREATE TABLE albums (
        release_year INT,
        title VARCHAR(30),
        artist VARCHAR(30),
        genre VARCHAR(30)
        );

ALTER TABLE albums ADD COLUMN ID SERIAL PRIMARY KEY;

CREATE TABLE artists (
       name VARCHAR(30)
       );

ALTER TABLE artists ADD COLUMN ID SERIAL PRIMARY KEY;

CREATE TABLE genres (
       name VARCHAR(30)
       );

ALTER TABLE genres ADD COLUMN ID SERIAL PRIMARY KEY;

drop table artists;
drop table albums;
select * from albums;
select * from artists;