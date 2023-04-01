package org.homework;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ViewCommand extends Command {

    private final File file;

    public ViewCommand(File file) {
        this.file = file;
    }

    @Override
    public void execute() throws IOException {
        Desktop desktop = Desktop.getDesktop();
        desktop.open(file);
    }
}