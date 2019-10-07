package br.com.iponto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class IPontoApplication {

	public static void main(String[] args) {
		SpringApplication.run(IPontoApplication.class, args);
	}

}
		