package de.kania.esiexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableAutoConfiguration
@EnableWebFlux
public class EsiExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(EsiExampleApplication.class, args);
	}
}
