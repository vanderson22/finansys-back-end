package br.com.home.finansys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class FinansysApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinansysApplication.class, args);
	}

}
