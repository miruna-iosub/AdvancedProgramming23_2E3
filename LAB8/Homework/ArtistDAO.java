package org.homework;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ArtistDAO {

    public List<Artist> artistList = new ArrayList<>();

    public void create(String name) throws SQLException {
        int id;
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into artists (name) values (?)")) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
        catch(SQLException ex){
            System.err.println(ex);
        }
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(
                "select id from artists where name='" + name + "'")) {
            id = rs.next() ? rs.getInt(1) : null;
        }
        Artist artist = new Artist(id, name);
        artistList.add(artist);
    }

    public Artist findByName(String name) throws SQLException {
        int data;
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(
                "select id from artists where name='" + name + "'")) {
            data = rs.next() ? rs.getInt(1) : null;
        }
        for(Artist artist : artistList){
            if(artist.id == data){
                System.out.println(artist);
                return artist;
            }
        }
        return null;
    }

    public Artist findById(int id) throws SQLException {
        String data;
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(
                "select name from artists where id='" + id + "'")) {
            data = rs.next() ? rs.getString(1) : null;
        }
        for(Artist artist : artistList){
            if(artist.name.compareTo(data) == 0){
                System.out.println(artist);
                return artist;
            }
        }
        return null;
    }
}