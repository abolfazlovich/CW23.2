package ir.maktabsharif.repository.base;

import ir.maktabsharif.model.BaseModel;
import ir.maktabsharif.repository.base.BaseRepository;
import ir.maktabsharif.util.HibernateUtil;


import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseRepositoryImpl<T extends BaseModel<ID>, ID extends Serializable>
        implements BaseRepository<T, ID> {

    private final Class<T> entityType;

    public BaseRepositoryImpl(Class<T> entityType) {
        this.entityType = entityType;
    }

    @Override
    public T create(T entity) {
        return HibernateUtil.inTxReturn(em -> {
            em.persist(entity);
            return entity;
        });
    }

    @Override
    public T update(T entity) {
        return HibernateUtil.inTxReturn(em -> {
            ID id = getId(entity);

            T managedEntity = em.find(entityType, id);

            if (managedEntity == null) {
                throw new RuntimeException("Entity not found with ID: " + id);
            }

            copyProperties(entity, managedEntity);

            return managedEntity;
        });
    }

    protected abstract ID getId(T entity);

    protected abstract void copyProperties(T source, T target);

    @Override
    public Optional<T> findById(ID id) {
        return HibernateUtil.read(em ->
                Optional.ofNullable(em.find(entityType, id))
        );
    }

    @Override
    public void delete(ID id) {
        HibernateUtil.inTxReturn(em -> {
            T entity = em.find(entityType, id);
            if (entity != null) {
                em.remove(entity);
            }
            return null;
        });
    }

    @Override
    public List<T> findAll() {
        return HibernateUtil.read(em ->
                em.createQuery(
                        "from " + entityType.getName(),
                        entityType
                ).getResultList()
        );
    }

    @Override
    public Long getCount() {
        return HibernateUtil.inTxReturn(em ->
                em.createQuery(
                        "select count(e) from " + entityType.getName() + " e",
                        Long.class
                ).getSingleResult()
        );
    }
}
