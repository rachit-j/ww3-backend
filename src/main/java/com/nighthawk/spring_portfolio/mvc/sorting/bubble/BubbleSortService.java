package com.nighthawk.spring_portfolio.mvc.sorting.bubble;

import org.springframework.stereotype.Service;
import com.nighthawk.spring_portfolio.mvc.sorting.SortResult;

import java.util.ArrayList;
import java.util.List;

@Service
public class BubbleSortService {

    public SortResult sort(List<Integer> input) {
        long startTime = System.nanoTime(); // Start timing

        List<Integer> arr = new ArrayList<>(input);
        int n = arr.size();
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr.get(j) > arr.get(j+1)) {
                    // swap arr[j+1] and arr[j]
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j+1));
                    arr.set(j+1, temp);
                }

        long endTime = System.nanoTime(); // End timing
        long duration = (endTime - startTime) / 1000000; // Convert nanoseconds to milliseconds

        return new SortResult(arr, duration);
    }
}
