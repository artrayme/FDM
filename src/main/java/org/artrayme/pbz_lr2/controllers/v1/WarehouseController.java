package org.artrayme.pbz_lr2.controllers.v1;

import org.artrayme.pbz_lr2.dto.mapper.WarehouseMapper;
import org.artrayme.pbz_lr2.dto.model.WarehouseDto;
import org.artrayme.pbz_lr2.entity.FactoryEntity;
import org.artrayme.pbz_lr2.entity.WarehouseEntity;
import org.artrayme.pbz_lr2.service.impl.FactoryService;
import org.artrayme.pbz_lr2.service.impl.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Component
@RequestMapping("/factories/edit/{factoryId}/warehouses")
public class WarehouseController {
    private final WarehouseMapper mapper;
    private final WarehouseService service;
    private final FactoryService factoryService;

    @Autowired
    public WarehouseController(WarehouseMapper mapper, WarehouseService service, FactoryService factoryService) {
        this.mapper = mapper;
        this.service = service;
        this.factoryService = factoryService;
    }

    @GetMapping()
    String getAll(Model model, @PathVariable String factoryId) {
        model.addAttribute("warehouses", service.getAllFactories());
        return "factories";
    }

    @GetMapping(value = "remove/{id}")
    String remover(@PathVariable("id") Long id, Model model, @PathVariable String factoryId) {
        var warehouseById = service.findWarehouseById(id);
        if (warehouseById.isPresent()) {
            model.addAttribute("thisWarehouse", warehouseById.get());
            return "warehouse/remove";
        } else {
            return "error/404";
        }
    }

    @PostMapping(value = "remove/{id}")
    String remove(@PathVariable("id") Long id, @PathVariable Long factoryId) {
        Optional<WarehouseEntity> warehouseById = service.findWarehouseById(id);
        if (warehouseById.isPresent()) {
            service.removeWarehouse(warehouseById.get());
            return "redirect:/factories/edit/" + factoryId + "/";
        } else {
            return "error/404";
        }
        //        model.addAttribute("remove_form", service.findwarehouseById(id));
    }

    @GetMapping("edit/{id}")
    public String updater(@PathVariable("id") Long id, Model model, @PathVariable String factoryId) {
        Optional<WarehouseEntity> warehouseById = service.findWarehouseById(id);
        if (warehouseById.isPresent()) {
            WarehouseDto warehouseDto = mapper.toDto(warehouseById.get());
            model.addAttribute("thisWarehouse", warehouseDto);
            model.addAttribute("inventory", warehouseDto.getInventory());
            return "warehouse/edit";
        } else
            return "error/404";
    }

    @PostMapping(value = "edit/{id}")
    String update(@ModelAttribute("warehouseForm") WarehouseDto dto, @PathVariable Long factoryId) {
        WarehouseEntity entity = mapper.toEntity(dto);
        entity.setFactory(factoryService.findFactoryById(factoryId).get());
        service.updateWarehouse(entity);
        return "redirect:/factories/edit/" + factoryId + "/";

    }

    @GetMapping("create")
    public String creator(Model model, @PathVariable Long factoryId) {
        model.addAttribute("warehouseForm", new WarehouseDto());
        return "warehouse/create";
    }

    @PostMapping(value = "create")
    public String create(@ModelAttribute("warehouseForm") WarehouseDto dto, @PathVariable Long factoryId) {
        WarehouseEntity entity = mapper.toEntity(dto);
        Optional<FactoryEntity> factoryById = factoryService.findFactoryById(factoryId);
        if (factoryById.isPresent()) {
            entity.setFactory(factoryById.get());
            service.saveWarehouseOrUpdate(entity);
            return "redirect:/factories/edit/" + factoryId + "/";

        } else
            return "error/404";
    }
}
