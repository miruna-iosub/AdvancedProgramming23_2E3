package org.compulsory;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            Database.createConnection();

            var artist = new ArtistDAO();
            artist.create("Anna");
            Database.getConnection().commit();

            var album = new AlbumDAO();
            int artistId = artist.findByName("Anna");
            album.create(2000, "nottoday", artistId, "drama");

            Database.getConnection().commit();
            Database.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}