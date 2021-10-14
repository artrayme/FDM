package org.artrayme.pbz_lr2.service.impl;

import org.artrayme.pbz_lr2.entity.FactoryEntity;
import org.artrayme.pbz_lr2.repositories.FactoryRepository;
import org.artrayme.pbz_lr2.service.FactoryCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FactoryService implements FactoryCrudService {

    private FactoryRepository repository;

    @Autowired
    public void setRepository(FactoryRepository repository) {
        this.repository = repository;
    }


    @Override
    public void saveFactoryOrUpdate(FactoryEntity factoryEntity) {
        repository.save(factoryEntity);
    }

    @Override
    public Optional<FactoryEntity> findFactoryById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<FactoryEntity> getAllFactories() {
        return repository.findAll();
    }

    @Override
    public void removeFactory(FactoryEntity factoryEntity) {
        repository.delete(factoryEntity);
    }

    @Override
    public void updateFactory(FactoryEntity factoryEntity) {
        repository.save(factoryEntity);
    }

    @Override
    public Long getCount() {
        return repository.count();
    }
}
