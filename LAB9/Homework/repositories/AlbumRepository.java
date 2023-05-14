package repositories;

import entities.Album;
public class AlbumRepository extends AbstractRepository<Album, Long>{

    @Override
    protected Class<Album> getEntityClass() {
        return Album.class;
    }
    @Override
    protected String getFindByNameNamedQuery() {
        return "Album.findByArtist";
    }
}