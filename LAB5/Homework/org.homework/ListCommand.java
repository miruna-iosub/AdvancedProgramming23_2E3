package org.homework;

public class ListCommand extends Command {
    private final Catalog catalog;

    public ListCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public void execute() {
        if (catalog.docs.isEmpty()) throw new CatalogException("No documents in catalog.");
        System.out.println("Catalog{" + "name=" + catalog.name + ", docs=" + catalog.docs + '}');
    }
}