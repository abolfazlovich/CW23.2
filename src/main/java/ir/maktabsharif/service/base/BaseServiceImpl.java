package ir.maktabsharif.service.base;

import ir.maktabsharif.model.BaseModel;
import ir.maktabsharif.repository.base.BaseRepository;


import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class BaseServiceImpl
        <T extends BaseModel<ID>
                , ID extends Serializable
                , R extends BaseRepository<T, ID>> implements BaseService<T, ID> {

    private final R repository;

    public BaseServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public void create(T entity) {
        repository.create(entity);
    }

    @Override
    public void update(T entity) {
        try {
            repository.update(entity);
        } catch (RuntimeException e) {
            System.out.println("Entity with this (" + entity.getId() + ") Id not found.");
        }
    }

    @Override
    public Optional<T> find(ID id) {
        Optional<T> optional = repository.findById(id);
        try {
            return optional;
        } catch (RuntimeException e) {
            System.out.println("Entity with this (" + id + ") Id not found.");
        }
        return optional;
    }

    @Override
    public void delete(ID id) {
        try {
            repository.delete(id);
        } catch (RuntimeException e) {
            System.out.println("Entity with this (" + id + ") Id not found.");
        }
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public Long getCount() {
        return repository.getCount();
    }
}

