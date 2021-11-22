package org.artrayme.pbz_lr2.controllers;

import org.artrayme.pbz_lr2.controllers.v1.FactoryController;
import org.artrayme.pbz_lr2.entity.FactoryEntity;
import org.artrayme.pbz_lr2.service.impl.FactoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * @author artrayme
 * 11/21/21
 */
@SpringBootTest
@WebMvcTest(FactoryController.class)
public class FactoryControllerUnitTest {
    @Autowired
    private FactoryService factoryService;


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, World")));
    }

    @Test
    public void whenViewBooks_thenReturnBooksView() throws Exception {
        when(factoryService.getAllFactories()).thenReturn(existingFactories());
        ResultActions viewBooksResult = mockMvc.perform(get("/"));

        viewBooksResult.andExpect(view().name("factories"))
                .andExpect(model().attribute("factories", hasSize(3)));
    }

    private static Collection<FactoryEntity> existingFactories() {
        List<FactoryEntity> factories = new ArrayList<>();
        factories.add(new FactoryEntity());
        factories.add(new FactoryEntity());
        factories.add(new FactoryEntity());
        return factories;
    }
}
