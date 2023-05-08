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

        EntityManagerFactory entity_manager_factory = PersistenceUtil.getInstance().getEMFactory();
        EntityManager entity_manager = entity_manager_factory.createEntityManager();
        Query query = entity_manager.createQuery(String.format("SELECT i FROM albums i WHERE i.titlu LIKE '%i%'", name));
        List<Album> list_of_albums = (List<Album>)query.getResultList();
        entity_manager.close();
        return list_of_albums;

    }
}
