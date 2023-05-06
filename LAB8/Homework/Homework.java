package org.homework;


import java.sql.SQLException;

public class Homework {
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setVisible(true);
        Database db = new Database();
        try {
            db.createConnection();
            var artists = new ArtistDAO();
            artists.create("Pink Floyd");
            artists.create("Michael Jackson");
            var genres = new GenreDAO();
            genres.create("Rock");
            genres.create("Funk");
            genres.create("Soul");
            genres.create("Pop");
            db.getConnection().commit();
            var albums = new AlbumDAO();
            albums.create(1979, "The Wall", "Pink Floyd", "Rock");
            albums.create(1982, "The Wall2", "Michael John", "Funk,Soul,Pop");
            Database.getConnection().commit();
            System.out.println(albums.albumList);
            db.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
            //Database.rollback();
        }

    }
}