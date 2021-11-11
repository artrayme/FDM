package org.artrayme.pbz_lr2.repositories;

import org.artrayme.pbz_lr2.entity.InventoryUnitEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InventoryRepository extends CrudRepository<InventoryUnitEntity, Long> {

    @Query(value = """
            select min(id)          as id,
                   type,
                   sum(res1 - res2) as count,
                   min(ir_id)       as input_report_id,
                   min(or_id)       as output_report_id
            from (select min(iu.id) as id, iu.type, sum(iu.count) as res1, 0 as res2, min(iu.input_report_id) as ir_id, 1 as or_id
                  from inventory_unit iu
                           join input_report ir
                               on ir.id = iu.input_report_id
                  where ir.warehouse_id = :warehouseId
                  group by iu.type
                  union all
                  select min(iu.id) as id, iu.type, 0 as res1, sum(iu.count) as res2, 1 as ir_id, min(iu.output_report_id) as or_id
                  from inventory_unit iu
                           join output_report o
                                on o.id = iu.output_report_id
                  where o.warehouse_id = :warehouseId
                  group by iu.type
                 ) as iiio
            group by type;
            """, nativeQuery = true)
    List<InventoryUnitEntity> getInventoryFromWarehouseById(Long warehouseId);

}
