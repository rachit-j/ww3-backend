package com.nighthawk.spring_portfolio.mvc.fibonacci.matrix;

import org.springframework.stereotype.Service;

@Service
public class MatrixFibonacciService {

    public FibonacciResult calculate(int n) {
        long startTime = System.nanoTime();

        int[][] result = matrixPower(new int[][]{{1, 1}, {1, 0}}, n - 1);
        int fibonacci = result[0][0];

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000; // Convert to milliseconds

        return new FibonacciResult(fibonacci, duration);
    }

    private int[][] matrixPower(int[][] matrix, int n) {
        int[][] result = {{1, 0}, {0, 1}}; // Identity matrix
        while (n > 0) {
            if (n % 2 == 1) {
                result = matrixMultiply(result, matrix);
            }
            n /= 2;
            matrix = matrixMultiply(matrix, matrix);
        }
        return result;
    }

    private int[][] matrixMultiply(int[][] a, int[][] b) {
        int[][] result = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
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
