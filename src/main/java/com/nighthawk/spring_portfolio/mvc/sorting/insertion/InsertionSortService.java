package com.nighthawk.spring_portfolio.mvc.sorting.insertion;

import org.springframework.stereotype.Service;
import com.nighthawk.spring_portfolio.mvc.sorting.SortResult;

import java.util.ArrayList;
import java.util.List;

@Service
public class InsertionSortService {

    public SortResult sort(List<Integer> input) {
        long startTime = System.nanoTime(); // Start timing

        List<Integer> arr = new ArrayList<>(input);
        int n = arr.size();
        for (int i = 1; i < n; ++i) {
            int key = arr.get(i);
            int j = i - 1;

            while (j >= 0 && arr.get(j) > key) {
                arr.set(j + 1, arr.get(j));
                j = j - 1;
            }
            arr.set(j + 1, key);
        }

        long endTime = System.nanoTime(); // End timing
        long duration = (endTime - startTime) / 1000000; // Convert nanoseconds to milliseconds

        return new SortResult(arr, duration);
    }
}
