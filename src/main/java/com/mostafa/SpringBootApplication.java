package com.mostafa;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.boot.SpringApplication;

@org.springframework.boot.autoconfigure.SpringBootApplication
@OpenAPIDefinition(
        info = @Info(title = "Book API", version = "1.0.0"),
        servers = {@Server(url = "http://localhost:9090")},
        tags = {@Tag(name = "Book", description = "This is the book desc.")}
)

@SecurityScheme(name = "BearerJWT", type = SecuritySchemeType.HTTP, scheme = "bearer", bearerFormat = "JWT",
        description = "Bearer token for the project.")
public class SpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplication.class, args);
    }

}
