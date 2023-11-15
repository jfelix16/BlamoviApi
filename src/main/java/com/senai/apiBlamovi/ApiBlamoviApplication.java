package com.senai.apiBlamovi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "API Blamovi", version = "1.0.0",description = "Swagger da API do Blamovi"))
public class ApiBlamoviApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiBlamoviApplication.class, args);
	}

}
