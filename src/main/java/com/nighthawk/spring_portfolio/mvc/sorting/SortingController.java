package com.nighthawk.spring_portfolio.mvc.sorting;

import com.nighthawk.spring_portfolio.mvc.sorting.bubble.BubbleSortService;
import com.nighthawk.spring_portfolio.mvc.sorting.insertion.InsertionSortService;
import com.nighthawk.spring_portfolio.mvc.sorting.merge.MergeSortService;
import com.nighthawk.spring_portfolio.mvc.sorting.selection.SelectionSortService;
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

    @GetMapping("/bubble")
    public List<Integer> bubbleSort(@RequestParam List<Integer> input) {
        return bubbleSortService.sort(input);
    }

    @GetMapping("/insertion")
    public List<Integer> insertionSort(@RequestParam List<Integer> input) {
        return insertionSortService.sort(input);
    }

    @GetMapping("/merge")
    public List<Integer> mergeSort(@RequestParam List<Integer> input) {
        return mergeSortService.sort(input);
    }

    @GetMapping("/selection")
    public List<Integer> selectionSort(@RequestParam List<Integer> input) {
        return selectionSortService.sort(input);
    }
}
