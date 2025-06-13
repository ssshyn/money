package com.sh.money.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Value("${swagger.server.url}")
    private String swaggerServerUrl;

    @Bean
    public OpenAPI openAPI() {
        Server server = new Server()
                .url(swaggerServerUrl)
                .description("서버 url");

        return new OpenAPI()
                .info(new Info().title("가계부 테스트")
                        .description("가계부 테스트")
                        .version("1.0.0"))
                .servers(List.of(server));
//                .components(new Components()
//                        .addSecuritySchemes("bearerAuth",
//                                new SecurityScheme()
//                                        .type(SecurityScheme.Type.HTTP)
//                                        .scheme("bearer")
//                                        .bearerFormat("JWT")
//                        )
//                )
//                .addSecurityItem(
//                        new SecurityRequirement().addList("bearerAuth")
//                );
    }
}
