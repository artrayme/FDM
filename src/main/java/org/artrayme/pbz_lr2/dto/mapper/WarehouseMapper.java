package org.artrayme.pbz_lr2.dto.mapper;

import org.artrayme.pbz_lr2.dto.model.WarehouseDto;
import org.artrayme.pbz_lr2.entity.WarehouseEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
public class WarehouseMapper {
    private final ModelMapper mapper;

    @Autowired
    public WarehouseMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public WarehouseDto toDto(WarehouseEntity entity) {
        return mapper.map(entity, WarehouseDto.class);
    }

    public WarehouseEntity toEntity(WarehouseDto dto) {
        return mapper.map(dto, WarehouseEntity.class);
    }
}