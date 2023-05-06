package org.homework;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class FileChooser extends JPanel {

    final MainFrame frame;
    JButton button;
    String path;

    public FileChooser(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        button = new JButton("Select File");
        add(button);
        button.addActionListener(this::actionPerformed);
    }

    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == button) {
            JFileChooser j = new JFileChooser();
            int r = j.showSaveDialog(null);
            if (r == JFileChooser.APPROVE_OPTION) {
                System.out.println(j.getSelectedFile().getAbsolutePath());
                Database db = new Database();
                try {
                    db.createConnection();
                    var albums = new AlbumDAO();
                    albums.importData(j.getSelectedFile().getAbsolutePath());
                    db.getConnection().commit();
                    db.getConnection().close();
                } catch (SQLException e) {
                    System.err.println(e);
                    //Database.rollback();
                }
            }
        }
    }

    public String getPath() {
        System.out.println(this.path);
        return path;
    }

}