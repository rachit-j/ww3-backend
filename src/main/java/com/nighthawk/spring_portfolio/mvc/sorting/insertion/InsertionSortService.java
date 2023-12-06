package com.nighthawk.spring_portfolio.mvc.sorting.insertion;

import org.springframework.stereotype.Service;
import com.nighthawk.spring_portfolio.mvc.sorting.SortResult;
import com.nighthawk.spring_portfolio.mvc.sorting.SortingServiceInterface;


import java.util.ArrayList;
import java.util.List;

@Service
public class InsertionSortService implements SortingServiceInterface {

    public SortResult sort(List<Integer> input) {
        long startTime = System.nanoTime();

        List<Integer> arr = new ArrayList<>(input);
        int n = arr.size();
        int iterations = 0;
        int comparisons = 0;
        int swaps = 0;

        for (int i = 1; i < n; ++i) {
            int key = arr.get(i);
            int j = i - 1;

            while (j >= 0 && arr.get(j) > key) {
                comparisons++; // Increment comparison count
                arr.set(j + 1, arr.get(j));
                j = j - 1;
                swaps++; // Increment swap count
            }
            arr.set(j + 1, key);
            iterations++; // Increment iteration count
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;

        return new SortResult("Insertion", arr, duration, iterations, comparisons, swaps);
    }
}
