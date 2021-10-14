package org.artrayme.pbz_lr2.dto.model;

import lombok.Data;

import java.util.List;

@Data
public class FactoryDto {
    private Long id;
    private String name;
    private List<WarehouseDto> warehouses;
}
