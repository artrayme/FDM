package org.artrayme.pbz_lr2.controllers.v1;

import org.artrayme.pbz_lr2.service.impl.FactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    private FactoryService factoryService;

    @Autowired
    public void setFactoryService(FactoryService factoryService) {
        this.factoryService = factoryService;
    }

    @RequestMapping(value = {"/", "/home", "/index"})
    public String index(Model model) {
        model.addAttribute("factories", factoryService.getAllFactories());
        model.addAttribute("factories_count", factoryService.getCount());
//        model.addAttribute("categories", categoryService.findAll());
        return "index";
    }
}
