package com.nighthawk.spring_portfolio.mvc.sorting.bubble;

import org.springframework.stereotype.Service;
import com.nighthawk.spring_portfolio.mvc.sorting.SortResult;
import com.nighthawk.spring_portfolio.mvc.sorting.SortingServiceInterface;


import java.util.ArrayList;
import java.util.List;

@Service
public class BubbleSortService implements SortingServiceInterface {

    public SortResult sort(List<Integer> input) {
        long startTime = System.nanoTime(); // Start timing

        List<Integer> arr = new ArrayList<>(input);
        int n = arr.size();
        int iterations = 0;
        int comparisons = 0;
        int swaps = 0;

        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                comparisons++; // Increment comparison count
                if (arr.get(j) > arr.get(j+1)) {
                    // swap arr[j+1] and arr[j]
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j+1));
                    arr.set(j+1, temp);
                    swaps++; // Increment swap count
                }
            }
            iterations++; // Increment iteration count
        }

        long endTime = System.nanoTime(); // End timing
        long duration = (endTime - startTime) / 1000000; // Convert nanoseconds to milliseconds

        return new SortResult("Bubble", arr, duration, iterations, comparisons, swaps);
    }
}