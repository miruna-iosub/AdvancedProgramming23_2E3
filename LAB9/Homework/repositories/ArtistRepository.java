package repositories;

import entities.Artist;

public class ArtistRepository extends AbstractRepository<Artist, Long>{

    @Override
    protected Class<Artist> getEntityClass() {
        return Artist.class;
    }
    @Override
    protected String getFindByNameNamedQuery() {
        return "Artist.findByArtist";
    }
}