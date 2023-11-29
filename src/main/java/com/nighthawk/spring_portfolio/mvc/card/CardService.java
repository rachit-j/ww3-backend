package com.nighthawk.spring_portfolio.mvc.card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {
    
    private final CardJpaRepository cardRepository;

    @Autowired
    public CardService(CardJpaRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public void saveCards(Card[] cards){
        for (Card card: cards){
            cardRepository.save(card);
        }
    }
}
