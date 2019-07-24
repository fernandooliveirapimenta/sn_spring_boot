package br.com.fernando.relatorio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"br.com.fernando.relatorio.model"})  // scan JPA entities
public class RelatorioApplication {

	public static void main(String[] args) {
		SpringApplication.run(RelatorioApplication.class, args);
	}

}
