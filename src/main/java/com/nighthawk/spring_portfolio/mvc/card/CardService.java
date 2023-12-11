package com.nighthawk.spring_portfolio.mvc.card;


import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    private final CardJpaRepository cardRepository;

    @Autowired
    public CardService(CardJpaRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public List<List<Card>> splitCardsRandomly(List<Card> cards) {
        // Shuffle the cards randomly
        Collections.shuffle(cards);

        // Split the cards into two halves
        int halfSize = cards.size() / 2;

        List<Card> firstHalf = new ArrayList<>(cards.subList(0, halfSize));
        List<Card> secondHalf = new ArrayList<>(cards.subList(halfSize, cards.size()));

        List<List<Card>> splitCards = new ArrayList<>();
        splitCards.add(firstHalf);
        splitCards.add(secondHalf);

        return splitCards;
    }
// commit change 


    public void saveCards(List<Card> cards) {
        cardRepository.saveAll(cards);
    }
}