package org.artrayme.pbz_lr2.service;

import org.artrayme.pbz_lr2.entity.OutputReportEntity;

import java.util.Optional;

public interface OutputReportCrudService {

    void saveOutputReportOrUpdate(OutputReportEntity OutputReportEntity);

    Optional<OutputReportEntity> findOutputReportById(Long id);

    Iterable<OutputReportEntity> getAllFactories();

    void removeOutputReport(OutputReportEntity OutputReportEntity);

    void updateOutputReport(OutputReportEntity OutputReportEntity);

}
