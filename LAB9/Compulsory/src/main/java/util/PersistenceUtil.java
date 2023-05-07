package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil { 

    private EntityManagerFactory entity_manager_factory = null;
    private static PersistenceUtil instance;

    public EntityManagerFactory getEMFactory() {

        return entity_manager_factory;
    }

    private PersistenceUtil() {

        entity_manager_factory = Persistence.createEntityManagerFactory("AlbumsPU");
    }

    public static PersistenceUtil getInstance() {

        if (null == instance)
            instance = new PersistenceUtil();
        return instance;
    }
}
