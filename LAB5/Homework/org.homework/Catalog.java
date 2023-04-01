package org.homework;

import java.io.Serializable;
import java.util.*;

public class Catalog implements Serializable {
    public String name;
    public List<Document> docs = new ArrayList<>();

    public Catalog() {
    }

    public Catalog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Document> getDocs() {
        return docs;
    }

    public void setDocs(List<Document> docs) {
        this.docs = docs;
    }

    public void add(Document doc) {
        docs.add(doc);
    }

    @Override
    public String toString() {
        return "Catalog{" + "name=" + name + ", docs=" + docs + '}';
    }
}