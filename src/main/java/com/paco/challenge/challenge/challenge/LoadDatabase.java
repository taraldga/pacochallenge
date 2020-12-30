package com.paco.challenge.challenge.challenge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ChallengeRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Challenge("Løpechallenge", "Løpedistanse ut året")));
            log.info("Preloading " + repository.save(new Challenge("Skrittchallenge", "Hvor mange skritt kan du ta")));
        };
    }
}
