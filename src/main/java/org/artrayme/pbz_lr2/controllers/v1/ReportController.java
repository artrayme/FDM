package org.artrayme.pbz_lr2.controllers.v1;

import org.artrayme.pbz_lr2.dto.mapper.InventoryUnitMapper;
import org.artrayme.pbz_lr2.dto.model.FactoryDto;
import org.artrayme.pbz_lr2.dto.model.InputReportDto;
import org.artrayme.pbz_lr2.dto.model.OutputReportDto;
import org.artrayme.pbz_lr2.entity.FactoryEntity;
import org.artrayme.pbz_lr2.entity.InventoryUnitEntity;
import org.artrayme.pbz_lr2.entity.WarehouseEntity;
import org.artrayme.pbz_lr2.service.impl.FactoryService;
import org.artrayme.pbz_lr2.service.impl.InventoryService;
import org.artrayme.pbz_lr2.service.impl.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/factories/edit/{factoryId}/warehouses/edit/{warehouseId}/report/")
public class ReportController {
    private final WarehouseService warehouseService;
    private final FactoryService factoryService;
    private final InventoryUnitMapper inventoryUnitMapper;
    private final InventoryService inventoryService;
    private InputReportDto inputReportDto;
    private OutputReportDto outputReportDto;



    @Autowired
    public ReportController(WarehouseService warehouseService, FactoryService factoryService,
                            InventoryUnitMapper inventoryUnitMapper, InventoryService inventoryService) {
        this.warehouseService = warehouseService;
        this.factoryService = factoryService;
        this.inventoryUnitMapper = inventoryUnitMapper;
        this.inventoryService = inventoryService;
    }

    @GetMapping(value = "remove")
    String remover(Model model) {
        outputReportDto = new OutputReportDto();
        model.addAttribute("report", outputReportDto);
        return "reports/outputReport";
    }

    @PostMapping(value = "remove")
    String remove(@ModelAttribute("report") OutputReportDto dto, @PathVariable Long warehouseId, @PathVariable Long factoryId) {
        WarehouseEntity warehouse = warehouseService.findWarehouseById(warehouseId).get();
        List<InventoryUnitEntity> inventoryUnitEntities = dto.getInventory().stream()
                .map(inventoryUnitMapper::toEntity)
                .toList();
        inventoryUnitEntities.forEach(e -> e.setWarehouse(null));
        inventoryUnitEntities.forEach(inventoryService::removeInventoryUnit);
        warehouse.getInventory().removeAll(inventoryUnitEntities);
        return "redirect:/factories/edit/" + factoryId + "/warehouses/edit/" + warehouseId + "/";
    }

    @GetMapping("create")
    public String creator(Model model) {
        inputReportDto = new InputReportDto();
        model.addAttribute("report", inputReportDto);
        return "reports/inputReport";
    }

    @PostMapping(value = "create")
    public String create(@ModelAttribute("report") InputReportDto dto, @PathVariable Long warehouseId, @PathVariable String factoryId) {
        WarehouseEntity warehouse = warehouseService.findWarehouseById(warehouseId).get();
        List<InventoryUnitEntity> inventoryUnitEntities = dto.getInventory().stream()
                .map(inventoryUnitMapper::toEntity)
                .toList();
        inventoryUnitEntities.forEach(e -> e.setWarehouse(warehouse));
        inventoryUnitEntities.forEach(inventoryService::saveInventoryUnitOrUpdate);
        warehouse.getInventory().addAll(inventoryUnitEntities);
        return "redirect:/factories/edit/" + factoryId + "/warehouses/edit/" + warehouseId + "/";
    }

    @GetMapping("create/add")
    public String addInventory(Model model) {
        model.addAttribute("report", new InputReportDto());
        return "reports/inputReport";
    }

    @PostMapping(value = "create/remove")
    public String removeInventory(@ModelAttribute("report") InputReportDto dto, @PathVariable Long warehouseId, @PathVariable String factoryId) {
        WarehouseEntity warehouse = warehouseService.findWarehouseById(warehouseId).get();
        List<InventoryUnitEntity> inventoryUnitEntities = dto.getInventory().stream()
                .map(inventoryUnitMapper::toEntity)
                .toList();
        inventoryUnitEntities.forEach(e -> e.setWarehouse(warehouse));
        inventoryUnitEntities.forEach(inventoryService::saveInventoryUnitOrUpdate);
        warehouse.getInventory().addAll(inventoryUnitEntities);
        return "redirect:/factories/edit/" + factoryId + "/warehouses/edit/" + warehouseId + "/";
    }
}
