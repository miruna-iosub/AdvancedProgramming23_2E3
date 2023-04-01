package org.homework;

import java.io.IOException;

public abstract class Command {
    public abstract void execute() throws IOException;
}