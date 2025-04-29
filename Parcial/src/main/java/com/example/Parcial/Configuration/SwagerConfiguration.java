package com.example.Parcial.Configuration;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwagerConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Liga de Futbol")
                        .version("1.0")
                        .description("Documentacion de la API Liga de futbol")
                        .contact(new Contact()
                                .name("Jorge Herrera")
                                .email("jorge.herrera-j@uninuto.edu.co")));
    }
}