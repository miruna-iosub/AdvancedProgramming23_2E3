package org.compulsory;

import javax.swing.*;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton exitButton = new JButton("Exit");
    JButton loadButton = new JButton("Load");
    JButton saveButton = new JButton("Save");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        add(loadButton, CENTER_ALIGNMENT);
        add(saveButton, CENTER_ALIGNMENT);
        add(exitButton, CENTER_ALIGNMENT);
    }
}
