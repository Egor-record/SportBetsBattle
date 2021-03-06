package ru.sportbetsbattle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


/**
 * Starting point of the app
 */

@EnableJpaAuditing
@SpringBootApplication
public class SportBetsBattleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportBetsBattleApplication.class, args);
	}

}
