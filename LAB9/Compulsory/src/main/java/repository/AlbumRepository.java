package repository;


import java.util.List;

import entity.Album; 
import util.PersistenceUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;


public class AlbumRepository {
    public static void create(Album album){

        EntityManagerFactory emfactory = PersistenceUtil.getInstance().getEMFactory();
        EntityManager entityManager = emfactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(album);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static Album findById(int id){

        EntityManagerFactory emfactory = PersistenceUtil.getInstance().getEMFactory();
        EntityManager entityManager = emfactory.createEntityManager();
        Album album = entityManager.find(Album.class, id);
        entityManager.close();
        return album;
    }

    public static List<Album> findByName(String name){

        EntityManagerFactory entityManagerFactory = PersistenceUtil.getInstance().getEMFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery(String.format("SELECT i FROM albums i WHERE i.titlu LIKE '%i%'", name));
        List<Album> listOfalbums = (List<Album>)query.getResultList();
        entity_manager.close();
        return listOfalbums;

    }
}
