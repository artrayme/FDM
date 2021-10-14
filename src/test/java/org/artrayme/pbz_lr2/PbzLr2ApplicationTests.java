package org.artrayme.pbz_lr2;

import org.artrayme.pbz_lr2.controllers.v1.FactoryController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PbzLr2ApplicationTests {

    @Autowired
    private FactoryController controller;

    @Test
    void contextLoads() throws InterruptedException {
        assertThat(controller).isNotNull();
    }

}
