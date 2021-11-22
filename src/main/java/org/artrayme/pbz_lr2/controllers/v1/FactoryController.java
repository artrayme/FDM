package org.artrayme.pbz_lr2.controllers.v1;

import org.artrayme.pbz_lr2.dto.mapper.FactoryMapper;
import org.artrayme.pbz_lr2.dto.model.FactoryDto;
import org.artrayme.pbz_lr2.entity.FactoryEntity;
import org.artrayme.pbz_lr2.service.impl.FactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.ConstraintViolationException;
import java.util.Optional;

@Controller
@RequestMapping(path = "/factories")
public class FactoryController {
    private final FactoryService service;
    private final FactoryMapper mapper;

    @Autowired
    FactoryController(FactoryService crudService, FactoryMapper mapper) {
        this.service = crudService;
        this.mapper = mapper;
    }

    @GetMapping()
    String getAll(Model model) {
        model.addAttribute("factories", service.getAllFactories());
        return "factories";
    }

    @GetMapping("create")
    public String creator(Model model) {
        model.addAttribute("factoryForm", new FactoryDto());
        return "factory/create";
    }

    @PostMapping(value = "create")
    public String create(@ModelAttribute("factoryForm") FactoryDto dto) {
        FactoryEntity entity = mapper.toEntity(dto);
        service.saveFactoryOrUpdate(entity);
        return "redirect:/";
    }

    @GetMapping("edit/{id}")
    public String updater(@PathVariable("id") Long id, Model model) {
        Optional<FactoryEntity> factoryById = service.findFactoryById(id);
        if (factoryById.isPresent()) {
            FactoryDto factoryDto = mapper.toDto(factoryById.get());
            model.addAttribute("thisFactory", factoryDto);
            return "factory/edit";
        } else
            return "error/404";
    }

    @PostMapping(value = "edit/{id}")
    String update(@ModelAttribute("thisFactory") FactoryDto dto) {
        Optional<FactoryEntity> originalEntity = service.findFactoryById(dto.getId());
        if (originalEntity.isPresent()) {
            var entity = originalEntity.get();
            entity.setName(dto.getName());
            service.updateFactory(entity);
            return "redirect:/";
        }
        return "error/404";
    }

    @GetMapping(value = "remove/{id}")
    String remover(@PathVariable("id") Long id, Model model) {
        Optional<FactoryEntity> factoryById = service.findFactoryById(id);
        if (factoryById.isPresent()) {
            model.addAttribute("thisFactory", factoryById.get());
            return "factory/remove";
        } else {
            return "error/404";
        }
    }

    @PostMapping(value = "remove/{id}")
    String remove(@PathVariable("id") Long id) {
        Optional<FactoryEntity> factoryById = service.findFactoryById(id);
        if (factoryById.isPresent()) {
            service.removeFactory(factoryById.get());
            return "redirect:/";
        } else {
            return "error/404";
        }
    }

    @ExceptionHandler(value = {ConstraintViolationException.class})
    public ModelAndView ModelAndViewExceptionHandler(Exception ex) {
        return new ModelAndView("error/error", HttpStatus.BAD_REQUEST);
    }
}
