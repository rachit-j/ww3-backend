package com.nighthawk.spring_portfolio.mvc.sorting.merge;

import org.springframework.stereotype.Service;
import com.nighthawk.spring_portfolio.mvc.sorting.SortResult;
import com.nighthawk.spring_portfolio.mvc.sorting.SortingServiceInterface;


import java.util.ArrayList;
import java.util.List;

@Service
public class MergeSortService implements SortingServiceInterface {

    private int comparisons = 0;
    private int merges = 0;

    public SortResult sort(List<Integer> input) {
        long startTime = System.nanoTime();

        List<Integer> arr = new ArrayList<>(input);
        mergeSort(arr, 0, arr.size() - 1);

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;

        return new SortResult("Merge", arr, duration, 0, comparisons, merges);
    }

    private void merge(List<Integer> arr, int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        List<Integer> L = new ArrayList<>(n1);
        List<Integer> R = new ArrayList<>(n2);

        /* Copy data to temp arrays */
        for (int i = 0; i < n1; ++i)
            L.add(i, arr.get(l + i));
        for (int j = 0; j < n2; ++j)
            R.add(j, arr.get(m + 1 + j));

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            comparisons++;  // Increment comparison count
            if (L.get(i) <= R.get(j)) {
                arr.set(k, L.get(i));
                i++;
            } else {
                arr.set(k, R.get(j));
                j++;
            }
            merges++;  // Increment merge count
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr.set(k, L.get(i));
            i++;
            k++;
            merges++;  // Increment merge count for remaining elements of L[]
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr.set(k, R.get(j));
            j++;
            k++;
            merges++;  // Increment merge count for remaining elements of R[]
        }
    }


    // Main function that sorts arr[l..r] using merge()
    private void mergeSort(List<Integer> arr, int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
}
