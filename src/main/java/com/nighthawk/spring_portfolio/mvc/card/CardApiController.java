package com.nighthawk.spring_portfolio.mvc.card;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// commit change 

@RestController
@RequestMapping(path = "/api/card")
public class CardApiController {

    @Autowired
    private CardJpaRepository repository;

    @Autowired
    private CardService cardService;

    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<List<Card>> getCards() {
        List<Card> cards = repository.findAll();
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }

    @GetMapping(value = "/split", produces = "application/json")
    public ResponseEntity<List<List<Card>>> splitCards() {
        List<Card> cards = repository.findAll();

        // Split the cards into two halves randomly
        List<List<Card>> splitCards = cardService.splitCardsRandomly(cards);

        return new ResponseEntity<>(splitCards, HttpStatus.OK);
    }
}
