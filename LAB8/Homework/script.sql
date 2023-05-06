    /*
    CREATE TABLE genres ( id serial PRIMARY KEY, name VARCHAR (50) NOT NULL);
    CREATE TABLE artists ( id serial PRIMARY KEY, name VARCHAR (50) NOT NULL);
    CREATE TABLE albums ( id serial PRIMARY KEY, release_year INTEGER NOT NULL, title VARCHAR (100) NOT NULL, artist VARCHAR (100) NOT NULL, genres VARCHAR (100) NOT NULL);
    CREATE TABLE album_genres ( album_id INTEGER, genre_id INTEGER, PRIMARY KEY (album_id, genre_id), CONSTRAINT fk_album FOREIGN KEY(album_id) REFERENCES albums(id), CONSTRAINT fk_genre FOREIGN KEY(genre_id) REFERENCES genres(id));
     */