package ir.maktabsharif.repository.impl;

import ir.maktabsharif.model.Developer;
import ir.maktabsharif.repository.DeveloperRepo;
import ir.maktabsharif.repository.base.BaseRepositoryImpl;

public class DeveloperRepositoryImpl extends BaseRepositoryImpl<Developer, Long> implements DeveloperRepo {

    public DeveloperRepositoryImpl() {
        super(Developer.class);
    }

    @Override
    protected Long getId(Developer entity) {
        return entity.getId();
    }

    @Override//source => target
    protected void copyProperties(Developer source, Developer target) {
        if (source.getCountry() != null) target.setCountry(source.getCountry());
        if (source.getName() != null) target.setName(source.getName());
        if (source.getGames() != null) target.setGames(source.getGames());
    }
}

