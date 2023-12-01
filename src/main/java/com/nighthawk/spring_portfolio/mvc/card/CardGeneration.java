package com.nighthawk.spring_portfolio.mvc.card;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration

public class CardGeneration {
    public CommandLineRunner commandLineRunner(CardJpaRepository repository){
        return args -> {
            List<Card> cards = new ArrayList<>();
            String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

            for (String suit : suits) {
                for (int rank = 1; rank <= 500; rank++) {
                    Card card = new Card(String.valueOf(rank), suit);
                    cards.add(card);
                }
            }

            repository.saveAll(cards);
        
        }; 
    }
}
