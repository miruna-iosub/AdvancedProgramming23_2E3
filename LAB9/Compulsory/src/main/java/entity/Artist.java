package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="artists")

public class Artist implements Serializable {

    @Id
    private int id;

    private String name;

    private static final long serialVersionUID = 1L;

    public Artist() {
    }

    public Artist(String name) {
        this.name = name;
    }

    public Artist(int id, String name) {
        this.id = id;
        this.name = name;
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


    @Override
    public String toString() {
        return "Artist [id=" + id + ", name=" + name + "]";
    }


}