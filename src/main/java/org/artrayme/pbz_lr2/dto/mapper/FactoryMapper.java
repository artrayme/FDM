package org.artrayme.pbz_lr2.dto.mapper;

import org.artrayme.pbz_lr2.dto.model.FactoryDto;
import org.artrayme.pbz_lr2.entity.FactoryEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FactoryMapper {

    private final ModelMapper mapper;

    @Autowired
    public FactoryMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public FactoryDto toDto(FactoryEntity entity) {
        return mapper.map(entity, FactoryDto.class);
    }

    public FactoryEntity toEntity(FactoryDto dto) {

        return mapper.map(dto, FactoryEntity.class);
    }
}
