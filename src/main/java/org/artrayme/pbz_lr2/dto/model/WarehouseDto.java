package org.artrayme.pbz_lr2.dto.model;

import lombok.Data;

import java.util.List;

@Data
public class WarehouseDto {
    private Long id;
    private String name;
    private String telephoneNumber;
    private List<InventoryUnitDto> inventory;

}
