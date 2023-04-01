package org.compulsory;

import javax.swing.*;
import java.awt.event.ActionEvent;


public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel dotsLabel, linesLabel;
    JSpinner dotsSpinner, linesSpinner;
    JComboBox linesCombo;
    JButton createButton;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        dotsLabel = new JLabel("Number of dots:");
        dotsSpinner = new JSpinner(new SpinnerNumberModel(6, 3, 100, 1));

        linesLabel = new JLabel("Line probability:");
        linesSpinner = new JSpinner(new SpinnerNumberModel(1.0, 1.0, 20.0, 1.0));
        createButton = new JButton("Create new game");

        add(dotsLabel);
        add(dotsSpinner);
        add(linesLabel);
        add(linesSpinner);
        add(createButton);

        createButton.addActionListener(this::createGame);
    }

    private void createGame(ActionEvent e) {
        DrawingPanel canvas = frame.canvas;
        canvas.createBoard();
        canvas.repaint();
    }
}