package entity;


import java.io.Serializable; 
import javax.persistence.*;

@Entity
@Table(name="albums")

public class Album implements Serializable {

    @Id
    private int id;

    private String name;

    private int releaseYear;

    private Artist artist;
    private String genre;

    private static final long serialVersionUID = 1L;

    public Album() {
    }

    public Album(String name, int releaseYear, Artist artist, String genre) {
        super();
        this.name = name;
        this.releaseYear = releaseYear;
        this.artist = artist;
        this.genre = genre;
    }

    public Album(int id, String name, int releaseYear, Artist artist, String genre) {
        super();
        this.id = id;
        this.name = name;
        this.releaseYear = releaseYear;
        this.artist = artist;
        this.genre = genre;
    }


    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReleaseYear() {
        return this.releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Artist getArtist() {
        return this.artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }



    @Override
    public String toString() {
        return "Album [id=" + id + ", name=" + name + ", releaseYear=" + releaseYear + ", artist=" + artist + "]";
    }
}
