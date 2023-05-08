package repository;


import java.util.List;

import entity.Artist;
import util.PersistenceUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;


public class ArtistRepository {
    public static void create(Artist artist){

        EntityManagerFactory entityManagerFactory = PersistenceUtil.getInstance().getEMFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(artist);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static Artist findById(int id){

        EntityManagerFactory entityManagerFactory = PersistenceUtil.getInstance().getEMFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Artist artist = entityManager.find(Artist.class, id);
        entityManager.close();

        return artist;
    }

    public static List<Artist> findByName(String name){
        EntityManagerFactory entityManagerFactory = PersistenceUtil.getInstance().getEMFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery(String.format("SELECT e FROM artists e WHERE e.name LIKE '%e%'", name));
        List<Artist> listOfartists = (List<Artist>) query.getResultList();
        entityManager.close();

        return listOfartists;
    }
}
