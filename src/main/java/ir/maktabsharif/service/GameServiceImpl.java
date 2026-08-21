package ir.maktabsharif.service;

import ir.maktabsharif.model.Game;
import ir.maktabsharif.repository.GameRepo;
import ir.maktabsharif.service.base.BaseServiceImpl;

public class GameServiceImpl extends BaseServiceImpl<Game,Long, GameRepo> implements GameService {
    public GameServiceImpl(GameRepo repository) {
        super(repository);
    }
}

