package com.nighthawk.spring_portfolio.mvc.card;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
// @TypeDef(name="json", typeClass=JsonType.class)
@Table(name = "card")


public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; 

    @NotEmpty
    @JsonProperty("rank")
    private String rank; 
    private String suit; 

    public Card(String rank, String suit) {
        this.rank = rank; 
        this.suit = suit; 
    }
}
