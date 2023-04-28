package org.compulsory;

import java.sql.*;

public class AlbumDAO<PrepareStatement> {
    public void create(Integer releaseYear, String title, int artist, String genre) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement("insert into albums (release_year, title, artist, genre) values ((?), (?), (?), (?))")) {
            pstmt.setInt(1, releaseYear);
            pstmt.setString(2, title);
            pstmt.setInt(3, artist);
            pstmt.setString(4, genre);
            pstmt.executeUpdate();
        }
    }

    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select id from albums where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    public String findById(Integer id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select title from albums where id='" + id + "'")) {
            return rs.next() ? rs.getString(1) : null;
        }
    }
}