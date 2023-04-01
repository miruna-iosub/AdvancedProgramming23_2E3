package org.homework;

public class AddCommand extends Command {
    private final Catalog catalog;
    private final Document document;

    public AddCommand(Catalog catalog, Document document) {
        this.catalog = catalog;
        this.document = document;
    }

    @Override
    public void execute() {
        catalog.docs.add(document);
    }
}