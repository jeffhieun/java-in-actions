package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Maximum Score
 * max(2, 5, 0, 6, 3) = 6
 *
 * Price:  2 5 4 7 8
 * Index:  0 1 2 3 4
 * Key = 2 -> [2,4]     Sum = 6
 * Key = 4 -> [5,7,8]   Sum = 20
 */
public class Solution05 {
    public static void main(String[] args) {
      List<Integer> stockPrice = List.of(2, 5, 4, 7, 8); //output 20
//        List<Integer> stockPrice = List.of(2,  5,  0 , 6 , 3); //output 6
        System.out.println(getMaximumScore(stockPrice));
    }
    private static long getMaximumScore(List<Integer> stockPrice) {
        Map<Long, Long> sumByKey = new HashMap<>();
        long answer = Long.MIN_VALUE;
        for(int i=0; i < stockPrice.size(); i++) {
            long key = (long) stockPrice.get(i) - i;
            long value = sumByKey.getOrDefault(key, 0L) + stockPrice.get(i);
            sumByKey.put(key, value);
            answer = Math.max(answer, value);
        }
        return answer;
    }
}
