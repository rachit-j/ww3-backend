package com.nighthawk.spring_portfolio.mvc.sorting;

import java.util.List;

public class SortResult {
    private List<Integer> sortedList;
    private long timeTakenMs;

    public SortResult(List<Integer> sortedList, long timeTakenMs) {
        this.sortedList = sortedList;
        this.timeTakenMs = timeTakenMs;
    }

    public List<Integer> getSortedList() {
        return sortedList;
    }

    public long getTimeTakenMs() {
        return timeTakenMs;
    }
}
