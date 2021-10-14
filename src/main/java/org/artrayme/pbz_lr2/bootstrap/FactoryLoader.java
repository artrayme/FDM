package org.artrayme.pbz_lr2.bootstrap;

import org.artrayme.pbz_lr2.entity.FactoryEntity;
import org.artrayme.pbz_lr2.entity.InventoryUnitEntity;
import org.artrayme.pbz_lr2.entity.WarehouseEntity;
import org.artrayme.pbz_lr2.repositories.FactoryRepository;
import org.artrayme.pbz_lr2.repositories.InventoryRepository;
import org.artrayme.pbz_lr2.repositories.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class FactoryLoader {
    private FactoryRepository factoryRepository;

    private WarehouseRepository warehouseRepository;

    private InventoryRepository inventoryRepository;

    @Autowired
    public void setWarehouseRepository(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    @Autowired
    public void setFactoryRepository(FactoryRepository factoryRepository) {
        this.factoryRepository = factoryRepository;
    }

    @Autowired
    public void setInventoryRepository(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

//    @EventListener({ContextStartedEvent.class})
    public void handleContextStart() {

        FactoryEntity factoryEntity = new FactoryEntity();
        factoryEntity.setId(1L);
        factoryEntity.setName("TestFactory");
        factoryRepository.save(factoryEntity);
        FactoryEntity mtz = new FactoryEntity();
        mtz.setId(2L);
        mtz.setName("MTZ");
        factoryRepository.save(mtz);

        WarehouseEntity warehouse1 = new WarehouseEntity();
        warehouse1.setId(1L);
        warehouse1.setName("Main Warehouse");
        warehouse1.setTelephoneNumber("+375291389234");
        warehouse1.setFactory(factoryEntity);
        warehouseRepository.save(warehouse1);

        WarehouseEntity instruments = new WarehouseEntity();
        instruments.setId(2L);
        instruments.setName("Instruments");
        instruments.setTelephoneNumber("+37529101204987");
        instruments.setFactory(mtz);
        warehouseRepository.save(instruments);

        WarehouseEntity details = new WarehouseEntity();
        details.setId(3L);
        details.setName("Details");
        details.setTelephoneNumber("+375291012073478");
        details.setFactory(mtz);
        warehouseRepository.save(details);

        InventoryUnitEntity screw = new InventoryUnitEntity();
        screw.setId(1L);
        screw.setType("Screw");
        screw.setCount(5L);
        screw.setWarehouse(instruments);
        inventoryRepository.save(screw);

        InventoryUnitEntity axe = new InventoryUnitEntity();
        axe.setId(2L);
        axe.setType("Axe");
        axe.setCount(2L);
        axe.setWarehouse(instruments);
        inventoryRepository.save(axe);

        InventoryUnitEntity glass = new InventoryUnitEntity();
        glass.setId(3L);
        glass.setType("Glass");
        glass.setCount(500L);
        glass.setWarehouse(details);
        inventoryRepository.save(glass);

    }


}
