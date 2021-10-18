package org.artrayme.pbz_lr2.dto.mapper;

import org.artrayme.pbz_lr2.dto.model.OutputReportDto;
import org.artrayme.pbz_lr2.entity.OutputReportEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OutputReportMapper {
    private final ModelMapper mapper;

    @Autowired
    public OutputReportMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public OutputReportDto toDto(OutputReportEntity entity) {
        return mapper.map(entity, OutputReportDto.class);
    }

    public OutputReportEntity toEntity(OutputReportDto dto) {
        return mapper.map(dto, OutputReportEntity.class);
    }
}