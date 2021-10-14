package org.artrayme.pbz_lr2.service;

import org.artrayme.pbz_lr2.entity.InventoryUnitEntity;

import java.util.Optional;

public interface InventoryCrudService {

    void saveInventoryUnitOrUpdate(InventoryUnitEntity InventoryUnitEntity);

    Optional<InventoryUnitEntity> findInventoryUnitById(Long id);

    Iterable<InventoryUnitEntity> getAllFactories();

    void removeInventoryUnit(InventoryUnitEntity InventoryUnitEntity);

    void updateInventoryUnit(InventoryUnitEntity InventoryUnitEntity);

}
