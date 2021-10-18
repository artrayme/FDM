package org.artrayme.pbz_lr2.repositories;

import org.artrayme.pbz_lr2.entity.FactoryEntity;
import org.artrayme.pbz_lr2.entity.InventoryUnitEntity;
import org.artrayme.pbz_lr2.entity.WarehouseEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WarehouseRepository extends CrudRepository<WarehouseEntity, Long> {
//
//    @Query("select ir " +
//            "from InputReportEntity ir " +
//            "where ir.warehouse = :warehouseId")
//    List<WarehouseEntity> getWarehouseInventoryById(@Param("warehouseId") Long warehouseId);


}
