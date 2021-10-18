package org.artrayme.pbz_lr2.service;

import org.artrayme.pbz_lr2.entity.InputReportEntity;

import java.util.Optional;

public interface InputReportCrudService {

    void saveInputReportOrUpdate(InputReportEntity InputReportEntity);

    Optional<InputReportEntity> findInputReportById(Long id);

    Iterable<InputReportEntity> getAllFactories();

    void removeInputReport(InputReportEntity InputReportEntity);

    void updateInputReport(InputReportEntity InputReportEntity);

}
