package com.nighthawk.spring_portfolio.mvc.card;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// commit change 

@Repository
public interface CardJpaRepository extends JpaRepository<Card, Long> {

}