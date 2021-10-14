package org.artrayme.pbz_lr2.repositories;

import org.artrayme.pbz_lr2.entity.FactoryEntity;
import org.artrayme.pbz_lr2.entity.InventoryUnitEntity;
import org.springframework.data.repository.CrudRepository;

public interface InventoryRepository extends CrudRepository<InventoryUnitEntity, Long> {
}
