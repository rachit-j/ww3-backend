package com.nighthawk.spring_portfolio.mvc.card;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/cards")
public class CardApiController {
   
    @Autowired
    private CardJpaRepository repository;

    @GetMapping("/")
    public ResponseEntity<List<Card>> getCards() {
        List<Card> cards = repository.findAll();
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }
    
}
