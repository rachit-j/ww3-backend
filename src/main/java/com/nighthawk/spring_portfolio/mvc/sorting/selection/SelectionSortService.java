package com.nighthawk.spring_portfolio.mvc.sorting.selection;

import org.springframework.stereotype.Service;
import com.nighthawk.spring_portfolio.mvc.sorting.SortResult;
import com.nighthawk.spring_portfolio.mvc.sorting.SortingServiceInterface;

import java.util.ArrayList;
import java.util.List;

@Service
public class SelectionSortService implements SortingServiceInterface {

    public SortResult sort(List<Integer> input) {
        long startTime = System.nanoTime();

        List<Integer> arr = new ArrayList<>(input);
        int n = arr.size();
        int iterations = 0;
        int comparisons = 0;
        int swaps = 0;

        for (int i = 0; i < n-1; i++) {
            int min_idx = i;
            for (int j = i+1; j < n; j++) {
                comparisons++; // Increment comparison count
                if (arr.get(j) < arr.get(min_idx)) {
                    min_idx = j;
                }
            }

            // Swap
            int temp = arr.get(min_idx);
            arr.set(min_idx, arr.get(i));
            arr.set(i, temp);
            swaps++; // Increment swap count

            iterations++; // Increment iteration count
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;

        return new SortResult("Selection", arr, duration, iterations, comparisons, swaps);
    }
}
