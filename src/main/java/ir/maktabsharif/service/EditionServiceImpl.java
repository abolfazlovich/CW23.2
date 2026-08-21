package ir.maktabsharif.service;

import ir.maktabsharif.model.Edition;
import ir.maktabsharif.repository.EditionRepo;
import ir.maktabsharif.repository.base.BaseRepository;
import ir.maktabsharif.repository.base.BaseRepositoryImpl;
import ir.maktabsharif.service.base.BaseService;
import ir.maktabsharif.service.base.BaseServiceImpl;

import java.util.Optional;

public class EditionServiceImpl extends BaseServiceImpl<Edition,Long, EditionRepo> implements EditionService {


    public EditionServiceImpl(EditionRepo repository) {
        super(repository);
    }

}
