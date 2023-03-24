package org.compulsory;

import java.io.IOException;

public class Compulsory {
    public static void main(String[] args) throws IOException {
        Catalog catalog = new Catalog("Catalog");
 
        Document doc1 = new Document("1", "Compulsory Java", "Compulsory.java");
        doc1.addTag("year", 2023);
        doc1.addTag("author", "Miruna Iosub");

        Document doc2 = new Document("2", "Luceafarul", "Luceafarul.txt");
        doc2.addTag("year", 1883);
        doc2.addTag("author", "Mihai Eminescu");

        catalog.add(doc1);
        catalog.add(doc2);

        CatalogUtil.save(catalog, "./catalog.json");

        Catalog loadedCatalog = CatalogUtil.load("./catalog.json");

        System.out.println(loadedCatalog);
    }
}
