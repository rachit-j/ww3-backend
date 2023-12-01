package com.nighthawk.spring_portfolio.mvc.fibonacci;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fibonacci")
public class FibonacciController {

    @Autowired
    private FibonacciService fibonacciService;

    @GetMapping("/{n}")
    public long getFibonacci(@PathVariable int n) {
        return fibonacciService.calculateFibonacci(n);
    }
}
