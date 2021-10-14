package org.artrayme.pbz_lr2.service.impl;

import org.artrayme.pbz_lr2.entity.WarehouseEntity;
import org.artrayme.pbz_lr2.repositories.WarehouseRepository;
import org.artrayme.pbz_lr2.service.WarehouseCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WarehouseService implements WarehouseCrudService {

    private WarehouseRepository repository;

    @Autowired
    public void setRepository(WarehouseRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveWarehouseOrUpdate(WarehouseEntity WarehouseEntity) {
        repository.save(WarehouseEntity);
    }

    @Override
    public Optional<WarehouseEntity> findWarehouseById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<WarehouseEntity> getAllFactories() {
        return repository.findAll();
    }

    @Override
    public void removeWarehouse(WarehouseEntity WarehouseEntity) {
        repository.delete(WarehouseEntity);
    }

    @Override
    public void updateWarehouse(WarehouseEntity WarehouseEntity) {
        repository.save(WarehouseEntity);
    }
}
