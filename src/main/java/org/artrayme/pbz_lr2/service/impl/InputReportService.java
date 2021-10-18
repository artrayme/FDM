package org.artrayme.pbz_lr2.service.impl;

import org.artrayme.pbz_lr2.entity.InputReportEntity;
import org.artrayme.pbz_lr2.repositories.InputReportRepository;
import org.artrayme.pbz_lr2.repositories.InventoryRepository;
import org.artrayme.pbz_lr2.service.InputReportCrudService;
import org.artrayme.pbz_lr2.service.InventoryCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InputReportService implements InputReportCrudService {

    private InputReportRepository repository;

    @Autowired
    public void setRepository(InputReportRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveInputReportOrUpdate(InputReportEntity InputReportEntity) {
        repository.save(InputReportEntity);
    }

    @Override
    public Optional<InputReportEntity> findInputReportById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<InputReportEntity> getAllFactories() {
        return repository.findAll();
    }

    @Override
    public void removeInputReport(InputReportEntity InputReportEntity) {
        repository.delete(InputReportEntity);
    }

    @Override
    public void updateInputReport(InputReportEntity InputReportEntity) {
        repository.save(InputReportEntity);
    }
}
