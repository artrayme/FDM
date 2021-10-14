package org.artrayme.pbz_lr2.service;

import org.artrayme.pbz_lr2.entity.FactoryEntity;

import java.util.Optional;

public interface FactoryCrudService {

    void saveFactoryOrUpdate(FactoryEntity factoryEntity);

    Optional<FactoryEntity> findFactoryById(Long id);

    Iterable<FactoryEntity> getAllFactories();

    void removeFactory(FactoryEntity factoryEntity);

    void updateFactory(FactoryEntity factoryEntity);

    Long getCount();
}
