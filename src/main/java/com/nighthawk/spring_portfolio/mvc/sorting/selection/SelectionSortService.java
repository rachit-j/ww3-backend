package com.nighthawk.spring_portfolio.mvc.sorting.selection;

import org.springframework.stereotype.Service;
import com.nighthawk.spring_portfolio.mvc.sorting.SortResult;
import java.util.ArrayList;
import java.util.List;

@Service
public class SelectionSortService {

    public SortResult sort(List<Integer> input) {
        long startTime = System.nanoTime();
        List<Integer> arr = new ArrayList<>(input);
        int n = arr.size();

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr.get(j) < arr.get(min_idx))
                    min_idx = j;

            // Swap the found minimum element with the first element
            int temp = arr.get(min_idx);
            arr.set(min_idx, arr.get(i));
            arr.set(i, temp);
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000; // convert to ms
        return new SortResult(arr, duration);
    }
}
