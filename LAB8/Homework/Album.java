package org.homework;


public class Album extends Superclass{
    String artist;
    String genre;
    int releaseYear;

    public Album(int id, int releaseYear, String name, String artist, String genre) {
        this.name = name;
        this.id = id;
        this.artist = artist;
        this.genre = genre;
        this.releaseYear = releaseYear;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
 
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getRelease_year() {
        return releaseYear;
    }

    public void setRelease_year(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return "Album{" + "name=" + name + ", id=" + id + ", release_year=" + releaseYear + ", artist=" + artist + ", genre=" + genre + '}';
    }
}
