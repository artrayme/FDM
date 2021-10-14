package org.artrayme.pbz_lr2.service.impl;

import org.artrayme.pbz_lr2.entity.InventoryUnitEntity;
import org.artrayme.pbz_lr2.repositories.InventoryRepository;
import org.artrayme.pbz_lr2.service.InventoryCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventoryService implements InventoryCrudService {

    private InventoryRepository repository;

    @Autowired
    public void setRepository(InventoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveInventoryUnitOrUpdate(InventoryUnitEntity InventoryUnitEntity) {
        repository.save(InventoryUnitEntity);
    }

    @Override
    public Optional<InventoryUnitEntity> findInventoryUnitById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<InventoryUnitEntity> getAllFactories() {
        return repository.findAll();
    }

    @Override
    public void removeInventoryUnit(InventoryUnitEntity InventoryUnitEntity) {
        repository.delete(InventoryUnitEntity);
    }

    @Override
    public void updateInventoryUnit(InventoryUnitEntity InventoryUnitEntity) {
        repository.save(InventoryUnitEntity);
    }
}
