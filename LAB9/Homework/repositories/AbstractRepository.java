package repositories;


import entities.Album;
import entities.Genre; 
import util.PersistenceUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRepository<T, ID extends Serializable> {

    protected abstract Class<T> getEntityClass();
    protected abstract String getFindByNameNamedQuery();

    public T create(T entity) {
        EntityManager entityManager = PersistenceUtil.getInstance().createEntityManager();

        try {
            entityManager.getTransaction().begin();
            if (entity instanceof Album) {
                Album album = (Album) entity;
                List<Genre> managedGenres = new ArrayList<>();

                for (Genre genre : album.getGenres()) {
                    managedGenres.add(entityManager.merge(genre));
                }

                album.setGenres(managedGenres);
            }
            entityManager.persist(entity);
            entityManager.flush();
            entityManager.getTransaction().commit();
            return entity;
        } finally {
            entityManager.close();
        }
    }

    public T findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        EntityManager entityManager = PersistenceUtil.getInstance().createEntityManager();
        T entity = entityManager.find(getEntityClass(), id);
        entityManager.close();
        return entity;
    }

    public List<T> findByName(String name) {
        EntityManager entityManager = PersistenceUtil.getInstance().createEntityManager();
        TypedQuery<T> query = entityManager.createNamedQuery(getFindByNameNamedQuery(), getEntityClass());
        query.setParameter(1, name);
        List<T> entities = query.getResultList();
        entityManager.close();
        return entities;
    }
}
