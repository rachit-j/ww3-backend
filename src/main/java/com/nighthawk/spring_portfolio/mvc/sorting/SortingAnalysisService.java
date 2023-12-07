package com.nighthawk.spring_portfolio.mvc.sorting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nighthawk.spring_portfolio.mvc.sorting.bubble.BubbleSortService;
import com.nighthawk.spring_portfolio.mvc.sorting.insertion.InsertionSortService;
import com.nighthawk.spring_portfolio.mvc.sorting.merge.MergeSortService;
import com.nighthawk.spring_portfolio.mvc.sorting.selection.SelectionSortService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class SortingAnalysisService {

    @Autowired
    private BubbleSortService bubbleSortService;

    @Autowired
    private InsertionSortService insertionSortService;

    @Autowired
    private MergeSortService mergeSortService;

    @Autowired
    private SelectionSortService selectionSortService;

    private static final int NUM_TESTS = 12;

    public List<SortResult> analyzeSorts(List<Integer> inputList) {
        List<SortResult> results = new ArrayList<>();

        results.add(analyzeSort("Bubble", bubbleSortService, inputList));
        results.add(analyzeSort("Insertion", insertionSortService, inputList));
        results.add(analyzeSort("Merge", mergeSortService, inputList));
        results.add(analyzeSort("Selection", selectionSortService, inputList));

        return results;
    }

    private SortResult analyzeSort(String sortType, SortingServiceInterface sortService, List<Integer> inputList) {
        List<Long> times = new ArrayList<>();
        List<Integer> comparisons = new ArrayList<>();
        List<Integer> swaps = new ArrayList<>();
        List<Integer> representativeSortedList = null;

        for (int i = 0; i < NUM_TESTS; i++) {
            // Clone the input list to avoid modifying the original list
            List<Integer> testData = new ArrayList<>(inputList);
            SortResult result = sortService.sort(testData);

            times.add(result.getTimeTakenMs());
            comparisons.add(result.getComparisons());
            swaps.add(result.getSwaps());

            if (i == 0) {
                representativeSortedList = result.getSortedList();
            }
        }

        Collections.sort(times);
        Collections.sort(comparisons);
        Collections.sort(swaps);

        // Remove the highest and lowest values
        times.remove(0);
        times.remove(times.size() - 1);
        comparisons.remove(0);
        comparisons.remove(comparisons.size() - 1);
        swaps.remove(0);
        swaps.remove(swaps.size() - 1);

        // Calculate averages
        long avgTime = times.stream().mapToLong(Long::longValue).sum() / times.size();
        int avgComparisons = comparisons.stream().mapToInt(Integer::intValue).sum() / comparisons.size();
        int avgSwaps = swaps.stream().mapToInt(Integer::intValue).sum() / swaps.size();

        // Return a new SortResult with averages and the sort type
        return new SortResult(sortType, representativeSortedList, avgTime, 0, avgComparisons, avgSwaps);
    }
}
