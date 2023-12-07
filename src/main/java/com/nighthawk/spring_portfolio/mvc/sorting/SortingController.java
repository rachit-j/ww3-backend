package com.nighthawk.spring_portfolio.mvc.sorting;

import com.nighthawk.spring_portfolio.mvc.sorting.bubble.BubbleSortService;
import com.nighthawk.spring_portfolio.mvc.sorting.insertion.InsertionSortService;
import com.nighthawk.spring_portfolio.mvc.sorting.merge.MergeSortService;
import com.nighthawk.spring_portfolio.mvc.sorting.selection.SelectionSortService;
import com.nighthawk.spring_portfolio.mvc.sorting.SortingAnalysisService;
import com.nighthawk.spring_portfolio.mvc.sorting.SortResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sorting")
public class SortingController {

    @Autowired
    private BubbleSortService bubbleSortService;

    @Autowired
    private InsertionSortService insertionSortService;

    @Autowired
    private MergeSortService mergeSortService;

    @Autowired
    private SelectionSortService selectionSortService;

    @PostMapping("/bubble") // Change the annotation to @PostMapping
    public SortResult bubbleSort(@RequestBody List<Integer> input) { // Use @RequestBody to receive the input data
        return bubbleSortService.sort(input);
    }

    @PostMapping("/insertion") // Change the annotation to @PostMapping
    public SortResult insertionSort(@RequestBody List<Integer> input) { // Use @RequestBody to receive the input data
        return insertionSortService.sort(input);
    }

    @PostMapping("/merge") // Change the annotation to @PostMapping
    public SortResult mergeSort(@RequestBody List<Integer> input) { // Use @RequestBody to receive the input data
        return mergeSortService.sort(input);
    }

    @PostMapping("/selection") // Change the annotation to @PostMapping
    public SortResult selectionSort(@RequestBody List<Integer> input) { // Use @RequestBody to receive the input data
        return selectionSortService.sort(input);
    }

    @Autowired
    private SortingAnalysisService sortingAnalysisService;

    @PostMapping("/analyze") // Change the annotation to @PostMapping
    public List<SortResult> analyzeSorts(@RequestBody List<Integer> input) { // Use @RequestBody to receive the input data
        return sortingAnalysisService.analyzeSorts(input);
    }
}
