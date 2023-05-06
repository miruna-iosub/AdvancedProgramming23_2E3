package org.homework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class GenreDAO {
    public List<Genre> genreList = new ArrayList<>();

    public void create(String name) throws SQLException {
        int id;
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into genres (name) values (?)")) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
        catch(SQLException ex){
            System.err.println(ex);
        }
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(
                "select id from genres where name='" + name + "'")) {
            id = rs.next() ? rs.getInt(1) : null;
        }
        Genre genre = new Genre(id, name);
        genreList.add(genre);
    }

    public Genre findByName(String name) throws SQLException {
        int data;
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(
                "select id from genres where name='" + name + "'")) {
            data = rs.next() ? rs.getInt(1) : null;
        }
        for(Genre genre : genreList){
            if(genre.id == data){
                System.out.println(genre);
                return genre;
            }
        }
        return null;
    }

    public Genre findById(int id) throws SQLException {
        String data;
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(
                "select name from genres where id='" + id + "'")) {
            data = rs.next() ? rs.getString(1) : null;
        }
        for(Genre genre : genreList){
            if(genre.name.compareTo(data) == 0){
                System.out.println(genre);
                return genre;
            }
        }
        return null;
    }
}