package com.aniljadhav2833.mysite.mysiteBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
@EnableJpaRepositories("com.aniljadhav2833.mysite.mysiteBackend.repository")
public class MysiteBackendApplication {



	public static void main(String[] args) {
		SpringApplication.run(MysiteBackendApplication.class, args);
	}

}
