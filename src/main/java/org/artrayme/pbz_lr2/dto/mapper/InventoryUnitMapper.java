package org.artrayme.pbz_lr2.dto.mapper;

import org.artrayme.pbz_lr2.dto.model.InventoryUnitDto;
import org.artrayme.pbz_lr2.entity.InventoryUnitEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InventoryUnitMapper {
    private final ModelMapper mapper;

    @Autowired
    public InventoryUnitMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public InventoryUnitDto toDto(InventoryUnitEntity entity) {
        return mapper.map(entity, InventoryUnitDto.class);
    }

    public InventoryUnitEntity toEntity(InventoryUnitDto dto) {
        return mapper.map(dto, InventoryUnitEntity.class);
    }
}