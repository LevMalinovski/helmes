package com.helmes.helmes;

import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class HelmesApplicationConfiguration {

    @Bean
    public ModelMapper mapper() {
        return new ModelMapper();
    }
}
