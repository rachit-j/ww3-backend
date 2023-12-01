package com.nighthawk.spring_portfolio.mvc.fibonacci;

import org.springframework.stereotype.Service;

@Service
public class FibonacciService {

    public long calculateFibonacci(int n) {
        double phi = (1 + Math.sqrt(5)) / 2;
        return Math.round((Math.pow(phi, n) - Math.pow(-phi, -n)) / Math.sqrt(5));
    }
}
