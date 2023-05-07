package app;

import java.util.List;
import entity.Album;
import entity.Artist; 
import repository.AlbumRepository;
import repository.ArtistRepository;

public class Main {

    private static List<Artist> artists;
    private static List<Album> albums;

    public static void main(String[] args) {

        System.out.println("THE ARTIST WITH ID 1 IS: ");
        System.out.println(ArtistRepository.findById(1));

        System.out.println("THE ARTISTS WITH NAME STARTING WITH THE LETTER T: ");
        artists = ArtistRepository.findByName("M%");

        System.out.println("THE FIRST ALBUM IS: ");
        System.out.println(AlbumRepository.findById(1));

    }
}
