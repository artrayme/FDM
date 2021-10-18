package org.artrayme.pbz_lr2.dto.mapper;

import org.artrayme.pbz_lr2.dto.model.InputReportDto;
import org.artrayme.pbz_lr2.entity.InputReportEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InputReportMapper {
    private final ModelMapper mapper;

    @Autowired
    public InputReportMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public InputReportDto toDto(InputReportEntity entity) {
        return mapper.map(entity, InputReportDto.class);
    }

    public InputReportEntity toEntity(InputReportDto dto) {
        return mapper.map(dto, InputReportEntity.class);
    }
}
