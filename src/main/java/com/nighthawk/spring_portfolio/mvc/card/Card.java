package com.nighthawk.spring_portfolio.mvc.card;

import com.vladmihalcea.hibernate.type.json.JsonType;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@TypeDef(name="json", typeClass=JsonType.class)
@Table(name = "card")


public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; 

    @NotEmpty
    @Size(min=5)
    @Column(unique=true)
    private String rank; 
    private String suit; 

    public Card(String rank, String suit) {
        this.rank = rank; 
        this.suit = suit; 
    }
}
