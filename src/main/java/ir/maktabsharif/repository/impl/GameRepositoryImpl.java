package ir.maktabsharif.repository.impl;

import ir.maktabsharif.model.Game;
import ir.maktabsharif.repository.GameRepo;
import ir.maktabsharif.repository.base.BaseRepositoryImpl;

public class GameRepositoryImpl extends BaseRepositoryImpl<Game, Long> implements GameRepo {
    public GameRepositoryImpl() {
        super(Game.class);
    }

    @Override
    protected Long getId(Game entity) {
        return entity.getId();
    }

    @Override
    protected void copyProperties(Game source, Game target) {
        if (source.getDescription() != null) target.setDescription(source.getDescription());
        if (source.getPrice() != null)target.setPrice(source.getPrice());
        if (source.getTitle() != null) target.setTitle(source.getTitle());
        if (source.getDeveloper() != null) target.setDeveloper(source.getDeveloper());
    }
}

