package org.artrayme.pbz_lr2.dto.mapper;

import org.artrayme.pbz_lr2.dto.model.InventoryUnitDto;
import org.artrayme.pbz_lr2.dto.model.WarehouseDto;
import org.artrayme.pbz_lr2.entity.InventoryUnitEntity;
import org.artrayme.pbz_lr2.entity.WarehouseEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
public class WarehouseMapper {
    private final ModelMapper mapper;
    private final InventoryUnitMapper inventoryUnitMapper;

    @Autowired
    public WarehouseMapper(ModelMapper mapper, InventoryUnitMapper inventoryUnitMapper) {
        this.mapper = mapper;
        this.inventoryUnitMapper = inventoryUnitMapper;
    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }

    public WarehouseDto toDto(WarehouseEntity entity) {
        WarehouseDto dto = mapper.map(entity, WarehouseDto.class);
        //        var x = entity.getInputReportEntities().stream()
        //                .flatMap(e -> e.getInventory().stream())
        //                .sorted(Comparator.comparing(InventoryUnitEntity::getType))
        //                .filter(distinctByKey(InventoryUnitEntity::getType))
        //                .toList();

//        var inventoryFromInputReport = entity.getInputReportEntities().stream()
//                .flatMap(e -> e.getInventory().stream())
//                .collect(Collectors.groupingBy(InventoryUnitEntity::getType)).values()
//                .stream()
//                .map(group -> group.stream().reduce(
//                        (a, b) -> new InventoryUnitEntity(a.getType(), a.getCount() + b.getCount())).get())
//                .sorted();
//        var inventoryFromOutputReport = entity.getOutputReportEntities().stream()
//                .flatMap(e -> e.getInventory().stream())
//                .collect(Collectors.groupingBy(InventoryUnitEntity::getType)).values()
//                .stream()
//                .map(group -> group.stream().reduce(
//                        (a, b) -> new InventoryUnitEntity(a.getType(), a.getCount() + b.getCount())).get())
//                .sorted();
//
//        int index = 0;
//        inventoryFromInputReport.forEach();
//        var result = inventoryFromInputReport.

        //        var mergedFriends = entity.getInputReportEntities().stream()
        //                .flatMap(e->e.getInventory().stream())
        //                .collect(Collectors.collectingAndThen(Collectors.toMap(InventoryUnitEntity::getType, InventoryUnitEntity::getCount, (a, b) -> {
        //                    return a+b;})), m->new ArrayList<>(m));
        return dto;
    }

    public WarehouseEntity toEntity(WarehouseDto dto) {
        return mapper.map(dto, WarehouseEntity.class);
    }
}