package org.artrayme.pbz_lr2.controllers.v1;

import org.artrayme.pbz_lr2.dto.mapper.InputReportMapper;
import org.artrayme.pbz_lr2.dto.mapper.InventoryUnitMapper;
import org.artrayme.pbz_lr2.dto.mapper.OutputReportMapper;
import org.artrayme.pbz_lr2.dto.model.InputReportDto;
import org.artrayme.pbz_lr2.dto.model.InventoryUnitDto;
import org.artrayme.pbz_lr2.dto.model.OutputReportDto;
import org.artrayme.pbz_lr2.entity.InputReportEntity;
import org.artrayme.pbz_lr2.entity.OutputReportEntity;
import org.artrayme.pbz_lr2.entity.WarehouseEntity;
import org.artrayme.pbz_lr2.service.impl.FactoryService;
import org.artrayme.pbz_lr2.service.impl.InputReportService;
import org.artrayme.pbz_lr2.service.impl.InventoryService;
import org.artrayme.pbz_lr2.service.impl.OutputReportService;
import org.artrayme.pbz_lr2.service.impl.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/factories/edit/{factoryId}/warehouses/edit/{warehouseId}/report/")
public class ReportController {
    private final WarehouseService warehouseService;
    private final InventoryService inventoryService;
    private final InputReportService inputReportService;
    private final OutputReportService outputReportService;

    private final InventoryUnitMapper inventoryUnitMapper;
    private final InputReportMapper inputReportMapper;
    private final OutputReportMapper outputReportMapper;

    private InputReportDto inputReportDto;
    private OutputReportDto outputReportDto;
    private String lastPath = "";
    private boolean isCreated = true;

    @Autowired
    public ReportController(WarehouseService warehouseService, InventoryService inventoryService,
                            InputReportService inputReportService, OutputReportService outputReportService,
                            InventoryUnitMapper inventoryUnitMapper, InputReportMapper inputReportMapper,
                            OutputReportMapper outputReportMapper) {
        this.warehouseService = warehouseService;
        this.inventoryUnitMapper = inventoryUnitMapper;
        this.inputReportMapper = inputReportMapper;
        this.outputReportMapper = outputReportMapper;
        this.inventoryService = inventoryService;
        this.inputReportService = inputReportService;
        this.outputReportService = outputReportService;
    }

    @GetMapping(value = "remove")
    String remover(Model model) {
        lastPath = "remove";
        if (isCreated)
            outputReportDto = new OutputReportDto();
        isCreated = false;
        model.addAttribute("report", outputReportDto);
        return "reports/outputReport";
    }

    @PostMapping(value = "remove")
    String remove(@ModelAttribute("report") OutputReportDto dto, @PathVariable Long warehouseId, @PathVariable Long factoryId) {
        isCreated = true;
        WarehouseEntity warehouse = warehouseService.findWarehouseById(warehouseId).get();
        OutputReportEntity report = outputReportMapper.toEntity(outputReportDto);
        report.setWarehouse(warehouse);
        outputReportService.saveOutputReportOrUpdate(report);
        outputReportDto.getInventory().stream().map(inventoryUnitMapper::toEntity).forEach(inventoryUnitEntity -> {
            inventoryUnitEntity.setOutputReport(report);
            inventoryService.saveInventoryUnitOrUpdate(inventoryUnitEntity);
        });

        warehouse.getOutputReportEntities().add(report);
        warehouseService.saveWarehouseOrUpdate(warehouse);
        return "redirect:/factories/edit/" + factoryId + "/warehouses/edit/" + warehouseId + "/";
    }

    @GetMapping("remove/add")
    public String addInventoryForRemoving(Model model) {
        model.addAttribute("thisUnit", new InventoryUnitDto());
        return "inventory/remove";
    }

    @PostMapping(value = "remove/add")
    public String addInventoryForRemove(@ModelAttribute("thisUnit") InventoryUnitDto dto, @PathVariable Long warehouseId, @PathVariable String factoryId) {
        outputReportDto.getInventory().add(dto);
        return "redirect:/factories/edit/" + factoryId + "/warehouses/edit/" + warehouseId + "/report/" + lastPath + "/";
    }

    @GetMapping("create")
    public String creator(Model model) {
        lastPath = "create";
        if (isCreated)
            inputReportDto = new InputReportDto();
        isCreated = false;
        model.addAttribute("report", inputReportDto);
        return "reports/inputReport";
    }

    @PostMapping(value = "create")
    public String create(@ModelAttribute("report") InputReportDto dto, @PathVariable Long warehouseId, @PathVariable String factoryId) {
        isCreated = true;
        WarehouseEntity warehouse = warehouseService.findWarehouseById(warehouseId).get();
        InputReportEntity report = inputReportMapper.toEntity(inputReportDto);
        report.setWarehouse(warehouse);
        inputReportService.saveInputReportOrUpdate(report);
        inputReportDto.getInventory().stream().map(inventoryUnitMapper::toEntity).forEach(inventoryUnitEntity -> {
            inventoryUnitEntity.setInputReport(report);
            inventoryService.saveInventoryUnitOrUpdate(inventoryUnitEntity);
        });

        warehouse.getInputReportEntities().add(report);
        warehouseService.saveWarehouseOrUpdate(warehouse);
        return "redirect:/factories/edit/" + factoryId + "/warehouses/edit/" + warehouseId + "/";
    }

    @GetMapping("create/add")
    public String addInventory(Model model) {
        model.addAttribute("thisUnit", new InventoryUnitDto());
        return "inventory/create";
    }

    @PostMapping(value = "create/add")
    public String removeInventory(@ModelAttribute("thisUnit") InventoryUnitDto dto, @PathVariable Long warehouseId, @PathVariable String factoryId) {
        inputReportDto.getInventory().add(dto);
        return "redirect:/factories/edit/" + factoryId + "/warehouses/edit/" + warehouseId + "/report/" + lastPath + "/";
    }
}
