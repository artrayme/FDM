package org.artrayme.pbz_lr2.service;

import org.artrayme.pbz_lr2.entity.InventoryUnitEntity;
import org.artrayme.pbz_lr2.entity.WarehouseEntity;

import java.util.List;
import java.util.Optional;

public interface WarehouseCrudService {


    void saveWarehouseOrUpdate(WarehouseEntity WarehouseEntity);

    Optional<WarehouseEntity> findWarehouseById(Long id);

    Iterable<WarehouseEntity> getAllWarehouses();

    void removeWarehouse(WarehouseEntity WarehouseEntity);

    void updateWarehouse(WarehouseEntity WarehouseEntity);

}
