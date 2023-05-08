package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil { 

    private EntityManagerFactory entityManagerFactory = null;
    private static PersistenceUtil instance;

    public EntityManagerFactory getEMFactory() {

        return entityManagerFactory;
    }

    private PersistenceUtil() {

        entityManagerFactory = Persistence.createEntityManagerFactory("AlbumsPU");
    }

    public static PersistenceUtil getInstance() {

        if (null == instance)
            instance = new PersistenceUtil();
        return instance;
    }
}
