package br.com.fiap.dbe_challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DbeChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbeChallengeApplication.class, args);
	}

}
