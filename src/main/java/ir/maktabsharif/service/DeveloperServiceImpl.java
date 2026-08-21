package ir.maktabsharif.service;

import ir.maktabsharif.model.Developer;
import ir.maktabsharif.repository.DeveloperRepo;
import ir.maktabsharif.service.base.BaseServiceImpl;

public class DeveloperServiceImpl extends BaseServiceImpl<Developer,Long, DeveloperRepo> implements DeveloperService {

    public DeveloperServiceImpl(DeveloperRepo repository) {
        super(repository);
    }


}
