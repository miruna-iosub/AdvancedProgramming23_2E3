package org.homework;

import java.io.Serializable;

public class Document implements Serializable {
    private String id;
    private String title;
    private String location;

    public Document() {
    }

    public Document(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Document{" + "id=" + id + ", title=" + title + ", location=" + location + '}';
    }


}