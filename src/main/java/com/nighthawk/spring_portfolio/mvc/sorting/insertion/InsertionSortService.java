package com.nighthawk.spring_portfolio.mvc.sorting.insertion;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class InsertionSortService {

    public List<Integer> sort(List<Integer> input) {
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
        return arr;
    }
}
