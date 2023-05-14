package repositories;

import entities.Genre;
public class GenreRepository extends AbstractRepository<Genre, Long>{

    @Override
    protected Class<Genre> getEntityClass() {
        return Genre.class;
    }
    @Override
    protected String getFindByNameNamedQuery() {
        return "Genre.findByArtist";
    }
}