package ir.maktabsharif.repository.impl;

import ir.maktabsharif.model.Edition;
import ir.maktabsharif.repository.EditionRepo;
import ir.maktabsharif.repository.base.BaseRepositoryImpl;

import java.util.Optional;

public class EditionRepositoryImpl extends BaseRepositoryImpl<Edition,Long> implements EditionRepo {
    public EditionRepositoryImpl(Class<Edition> entityType) {
        super(entityType);
    }

    @Override
    protected Long getId(Edition entity) {
        return entity.getId();
    }

    @Override
    protected void copyProperties(Edition source, Edition target) {
if(Optional.ofNullable(source.getName()).isPresent())
    target.setName(source.getName());
if(Optional.ofNullable(source.getPrice()).isPresent())
    target.setPrice(source.getPrice());
if(Optional.ofNullable(source.getGame()).isPresent())
    target.setGame(source.getGame());
    }
}
