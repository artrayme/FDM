package org.artrayme.pbz_lr2;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class PbzLr2Application {

    public static void main(String[] args) {
//        System.out.println("zdes");
        ConfigurableApplicationContext applicationContext = SpringApplication.run(PbzLr2Application.class, args);
        applicationContext.start();
//        applicationContext.refresh();
//        System.out.println("poka");

    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
