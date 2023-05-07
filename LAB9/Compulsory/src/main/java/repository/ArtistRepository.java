package repository;


import java.util.List;

import entity.Artist;
import util.PersistenceUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;


public class ArtistRepository {
    public static void create(Artist artist){

        EntityManagerFactory entity_manager_factory = PersistenceUtil.getInstance().getEMFactory();
        EntityManager entity_manager = entity_manager_factory.createEntityManager();
        entity_manager.getTransaction().begin();

        entity_manager.persist(artist);
        entity_manager.getTransaction().commit();
        entity_manager.close();
    }

    public static Artist findById(int id){

        EntityManagerFactory entity_manager_factory = PersistenceUtil.getInstance().getEMFactory();
        EntityManager entity_manager = entity_manager_factory.createEntityManager();
        Artist artist = entity_manager.find(Artist.class, id);
        entity_manager.close();

        return artist;
    }

    public static List<Artist> findByName(String name){
        EntityManagerFactory entity_manager_factory = PersistenceUtil.getInstance().getEMFactory();
        EntityManager entity_manager = entity_manager_factory.createEntityManager();
        Query query = entity_manager.createQuery(String.format("SELECT e FROM artists e WHERE e.name LIKE '%e%'", name));
        List<Artist> list_of_artists = (List<Artist>) query.getResultList();
        entity_manager.close();

        return list_of_artists;
    }
}