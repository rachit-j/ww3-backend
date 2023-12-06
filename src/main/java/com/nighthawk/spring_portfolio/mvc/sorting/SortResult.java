package com.nighthawk.spring_portfolio.mvc.sorting;

import java.util.List;

public class SortResult {
    private String sortType; // Add this field
    private List<Integer> sortedList;
    private long timeTakenMs;
    private int iterations;
    private int comparisons;
    private int swaps;

    public SortResult(String sortType, List<Integer> sortedList, long timeTakenMs, int iterations, int comparisons, int swaps) {
        this.sortType = sortType; // Include this in the constructor
        this.sortedList = sortedList;
        this.timeTakenMs = timeTakenMs;
        this.iterations = iterations;
        this.comparisons = comparisons;
        this.swaps = swaps;
    }

    // Getter for sortType
    public String getSortType() {
        return sortType;
    }

    // Existing getters
    public List<Integer> getSortedList() {
        return sortedList;
    }

    public long getTimeTakenMs() {
        return timeTakenMs;
    }

    // New getters
    public int getIterations() {
        return iterations;
    }

    public int getComparisons() {
        return comparisons;
    }

    public int getSwaps() {
        return swaps;
    }
}
