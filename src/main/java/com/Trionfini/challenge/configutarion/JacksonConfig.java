package com.Trionfini.challenge.configutarion;

import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

@Configuration
public class JacksonConfig {
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer customJackson() {
        return builder -> {
            // Configuración adicional según tus necesidades
            builder.dateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"));
        };
    }
}
