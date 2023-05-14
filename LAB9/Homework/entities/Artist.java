package entities;


import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;

@Table(name = "artists")
@NamedQueries({@NamedQuery(name = "Artist.findAll", query = "select e from Artist e order by e.name"),})
public class Artist implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
    private List<Album> albums;

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    @Column(name = "name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Artist(String name) {
        this.name = name;
    }

    public Artist() {
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", albums=" + albums +
                ", name='" + name + '\'' +
                '}';
    }
}