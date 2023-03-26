package org.compulsory; 

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Catalog implements Serializable {
    private String name;
    private List<Document> docs = new ArrayList<>();
    public Catalog(){};
    public Catalog(String name){
        this.name=name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Document> getDoc() {
        return docs;
    }
    public void setDoc(List<Document> docs) {
        this.docs = docs;
    }

    public void add(Document doc) {
        docs.add(doc);
    }

    public Document findById(String id) {
        return docs.stream()
                .filter(d -> d.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "name='" + name + '\'' +
                ", doc=" + docs +
                '}';
    }
}
