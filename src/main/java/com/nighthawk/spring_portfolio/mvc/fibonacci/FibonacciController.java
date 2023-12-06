package com.nighthawk.spring_portfolio.mvc.fibonacci;

import com.nighthawk.spring_portfolio.mvc.fibonacci.binets.BinetService;
import com.nighthawk.spring_portfolio.mvc.fibonacci.matrix.MatrixFibonacciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fibonacci")
public class FibonacciController {

    @Autowired
    private BinetService binetService; // Can go until 92 (java)

    @Autowired
    private MatrixFibonacciService matrixFibonacciService; // Cannot go above 46 (some matrix thing)

    // Autowire other services

    @GetMapping("/{method}/{n}")
    public Object calculateFibonacci(@PathVariable String method, @PathVariable int n) {
        switch (method.toLowerCase()) {
            case "binet":
                return binetService.calculate(n);
            case "matrix":
                return matrixFibonacciService.calculate(n);
            // Add more cases for other methods here
            default:
                throw new IllegalArgumentException("Invalid Fibonacci calculation method: " + method);
        }
    }
}
