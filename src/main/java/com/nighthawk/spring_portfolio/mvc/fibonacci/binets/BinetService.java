package com.nighthawk.spring_portfolio.mvc.fibonacci.binets;

import org.springframework.stereotype.Service;

@Service
public class BinetService {

    public FibonacciResult calculate(int n) {
        long startTime = System.nanoTime();

        double phi = (1 + Math.sqrt(5)) / 2;
        int fibonacci = (int) Math.round(Math.pow(phi, n) / Math.sqrt(5));

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000; // Convert to milliseconds

        return new FibonacciResult(fibonacci, duration);
    }

    public static class FibonacciResult {
        private final int fibonacciNumber;
        private final long timeTakenMs;

        public FibonacciResult(int fibonacciNumber, long timeTakenMs) {
            this.fibonacciNumber = fibonacciNumber;
            this.timeTakenMs = timeTakenMs;
        }

        public int getFibonacciNumber() {
            return fibonacciNumber;
        }

        public long getTimeTakenMs() {
            return timeTakenMs;
        }
    }
}
