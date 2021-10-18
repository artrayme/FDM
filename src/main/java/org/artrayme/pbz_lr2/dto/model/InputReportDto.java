package org.artrayme.pbz_lr2.dto.model;

import lombok.Data;
import org.artrayme.pbz_lr2.entity.InventoryUnitEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class InputReportDto {
    private Long id;
    private LocalDate date;
    private String workerFIO;
    private String workerPost;
    private List<InventoryUnitDto> inventory = new ArrayList<>();
}
