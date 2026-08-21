package ir.maktabsharif.repository.base;





import ir.maktabsharif.model.BaseModel;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface BaseRepository<T extends BaseModel<ID>, ID extends Serializable> {
    T create(T entity);

    T update(T entity);

    Optional<T> findById(ID id);

    void delete(ID id);

    List<T> findAll();

    Long getCount();
}
