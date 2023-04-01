package org.homework;

import java.io.File;
import java.io.IOException;

public class Homework {
    public static void main(String[] args) throws IOException {
        Catalog catalog = new Catalog("My Catalog");

        var book = new Document("book");
        book.setTitle("Poem");

        var article = new Document("article");
        article.setTitle("Java Homework");

        AddCommand add = new AddCommand(catalog, book);
        AddCommand add1 = new AddCommand(catalog, article);
        ListCommand list = new ListCommand(catalog);
        SaveCommand save = new SaveCommand(catalog, "./catalog.json");
        add.execute();
        add1.execute();
        save.execute();
        list.execute();

        File file = new File("./catalog.json");
        ViewCommand view = new ViewCommand(file);
        ReportCommand report = new ReportCommand(catalog);
        view.execute();
        report.execute();
    }
}