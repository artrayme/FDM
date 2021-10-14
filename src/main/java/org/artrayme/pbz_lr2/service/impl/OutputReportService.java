//package org.artrayme.pbz_lr2.service.impl;
//
//import org.artrayme.pbz_lr2.entity.OutputReportEntity;
//import org.artrayme.pbz_lr2.repositories.OutputReportRepository;
//import org.artrayme.pbz_lr2.service.OutputReportCrudService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class OutputReportService implements OutputReportCrudService {
//
//    private OutputReportRepository repository;
//
//    @Autowired
//    public void setRepository(OutputReportRepository repository) {
//        this.repository = repository;
//    }
//
//    @Override
//    public void saveOutputReportOrUpdate(OutputReportEntity OutputReportEntity) {
//        repository.save(OutputReportEntity);
//    }
//
//    @Override
//    public Optional<OutputReportEntity> findOutputReportById(Long id) {
//        return repository.findById(id);
//    }
//
//    @Override
//    public Iterable<OutputReportEntity> getAllFactories() {
//        return repository.findAll();
//    }
//
//    @Override
//    public void removeOutputReport(OutputReportEntity OutputReportEntity) {
//        repository.delete(OutputReportEntity);
//    }
//
//    @Override
//    public void updateOutputReport(OutputReportEntity OutputReportEntity) {
//        repository.save(OutputReportEntity);
//    }
//}
