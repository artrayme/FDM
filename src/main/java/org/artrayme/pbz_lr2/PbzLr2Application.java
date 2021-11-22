package org.artrayme.pbz_lr2;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Iterator;
import java.util.stream.Stream;

@SpringBootApplication

public class PbzLr2Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(PbzLr2Application.class, args);
        applicationContext.start();

    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
