package org.homework;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class MainFrame extends JFrame{
    FileChooser fc;

    public MainFrame() {
        super("Choose CSV file");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        fc = new FileChooser(this);

        add(fc, BorderLayout.CENTER);

        pack();
    }
}