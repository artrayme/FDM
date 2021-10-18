package org.artrayme.pbz_lr2.bootstrap;

import org.artrayme.pbz_lr2.entity.FactoryEntity;
import org.artrayme.pbz_lr2.entity.InputReportEntity;
import org.artrayme.pbz_lr2.entity.InventoryUnitEntity;
import org.artrayme.pbz_lr2.entity.OutputReportEntity;
import org.artrayme.pbz_lr2.entity.WarehouseEntity;
import org.artrayme.pbz_lr2.repositories.FactoryRepository;
import org.artrayme.pbz_lr2.repositories.InputReportRepository;
import org.artrayme.pbz_lr2.repositories.InventoryRepository;
import org.artrayme.pbz_lr2.repositories.OutputReportRepository;
import org.artrayme.pbz_lr2.repositories.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class FactoryLoader {
    private FactoryRepository factoryRepository;

    private WarehouseRepository warehouseRepository;

    private InventoryRepository inventoryRepository;

    private InputReportRepository inputReportRepository;

    private OutputReportRepository outputReportRepository;

    @Autowired
    public void setInputReportRepository(InputReportRepository inputReportRepository) {
        this.inputReportRepository = inputReportRepository;
    }

    @Autowired
    public void setOutputReportRepository(OutputReportRepository outputReportRepository) {
        this.outputReportRepository = outputReportRepository;
    }

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

        FactoryEntity testFactory = new FactoryEntity();
        testFactory.setId(1L);
        testFactory.setName("TestFactory");
        factoryRepository.save(testFactory);

        WarehouseEntity warehouse1 = new WarehouseEntity();
        warehouse1.setId(1L);
        warehouse1.setName("Main Warehouse");
        warehouse1.setTelephoneNumber("+375291389234");
        warehouse1.setFactory(testFactory);
        warehouseRepository.save(warehouse1);

        FactoryEntity mtz = new FactoryEntity();
        mtz.setId(2L);
        mtz.setName("MTZ");
        factoryRepository.save(mtz);

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

        InputReportEntity detailsInputReport = new InputReportEntity();
        detailsInputReport.setId(1L);
        detailsInputReport.setDate(LocalDate.now());
        detailsInputReport.setWorkerFIO("Иванов Иван Иванович");
        detailsInputReport.setWorkerPost("Начальник склада");
        detailsInputReport.setWarehouse(details);
        inputReportRepository.save(detailsInputReport);

        InputReportEntity detailsInputReport2 = new InputReportEntity();
        detailsInputReport2.setId(2L);
        detailsInputReport2.setDate(LocalDate.now());
        detailsInputReport2.setWorkerFIO("Олегов Олег Олегович");
        detailsInputReport2.setWorkerPost("Прохожий");
        detailsInputReport2.setWarehouse(details);
        inputReportRepository.save(detailsInputReport2);

        InputReportEntity instrumentsInputReport = new InputReportEntity();
        instrumentsInputReport.setId(3L);
        instrumentsInputReport.setDate(LocalDate.now());
        instrumentsInputReport.setWorkerFIO("Петров Пётр Петрович");
        instrumentsInputReport.setWorkerPost("Заместитель начальника склада");
        instrumentsInputReport.setWarehouse(instruments);
        inputReportRepository.save(instrumentsInputReport);

        OutputReportEntity detailsOutputReport = new OutputReportEntity();
        detailsOutputReport.setId(1L);
        detailsOutputReport.setDate(LocalDate.now());
        detailsOutputReport.setWorkerFIO("Ворюга");
        detailsOutputReport.setWorkerPost("Директор");
        detailsOutputReport.setWarehouse(details);
        outputReportRepository.save(detailsOutputReport);

        InventoryUnitEntity screw = new InventoryUnitEntity();
        screw.setId(1L);
        screw.setType("Screw");
        screw.setCount(5L);
        screw.setInputReport(instrumentsInputReport);
        inventoryRepository.save(screw);

        InventoryUnitEntity axe = new InventoryUnitEntity();
        axe.setId(2L);
        axe.setType("Axe");
        axe.setCount(2L);
        axe.setInputReport(instrumentsInputReport);
        inventoryRepository.save(axe);

        InventoryUnitEntity glass = new InventoryUnitEntity();
        glass.setId(3L);
        glass.setType("Glass");
        glass.setCount(500L);
        glass.setInputReport(detailsInputReport);
        inventoryRepository.save(glass);

        InventoryUnitEntity metal = new InventoryUnitEntity();
        metal.setId(4L);
        metal.setType("Metal");
        metal.setCount(324L);
        metal.setInputReport(detailsInputReport);
        inventoryRepository.save(metal);

        InventoryUnitEntity engines = new InventoryUnitEntity();
        engines.setId(5L);
        engines.setType("Engine");
        engines.setCount(40L);
        engines.setInputReport(detailsInputReport);
        inventoryRepository.save(engines);

        InventoryUnitEntity engines2 = new InventoryUnitEntity();
        engines2.setId(6L);
        engines2.setType("Engine");
        engines2.setCount(5L);
        engines2.setInputReport(detailsInputReport2);
        inventoryRepository.save(engines2);

        InventoryUnitEntity enginesR = new InventoryUnitEntity();
        enginesR.setId(7L);
        enginesR.setType("Engine");
        enginesR.setCount(6L);
        enginesR.setOutputReport(detailsOutputReport);
        inventoryRepository.save(enginesR);

    }

    //    @EventListener({ContextStartedEvent.class})
    public void testGettingWarehouseInventory() {
        var x = inventoryRepository.getInventoryFromWarehouseById(3L);
        System.out.println(x);
        //        var warehouseInventoryById = warehouseRepository.getWarehouseInventoryById(3L);
        //        System.out.println(warehouseInventoryById);
    }
}
