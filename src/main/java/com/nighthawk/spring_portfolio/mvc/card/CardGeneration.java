package com.nighthawk.spring_portfolio.mvc.card;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// commit change 

@Configuration
public class CardGeneration {

    @Bean
    CommandLineRunner commandLineRunner(
        CardJpaRepository repository) {
            return args -> {
            List<Card> cards = new ArrayList<>();

            for (int rank = 1; rank <= 500; rank++) {
                Card card = new Card(rank);
                cards.add(card);
            }

            repository.saveAll(cards);
        };
        }
    
    
}
