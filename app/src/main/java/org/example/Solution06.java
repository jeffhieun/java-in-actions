package org.example;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*
API Rate-Limiting
Input:
capacity = [5,3,2]
requestInterval = 10

Start:
heap = [5,3,2], seconds = 0

Iteration 1:
currentCapacity = 5
requestInterval: 10 -> 5
seconds: 0 -> 1
reinsert: 5/2 = 2
heap = [3,2,2]

Iteration 2:
currentCapacity = 3
requestInterval: 5 -> 2
seconds: 1 -> 2
reinsert: 3/2 = 1
heap = [2,2,1]

Iteration 3:
currentCapacity = 2
requestInterval: 2 -> 0
seconds: 2 -> 3
reinsert: 2/2 = 1
heap = [2,1,1]

Result:
return 3
*/
public class Solution06 {
    public static void main(String[] args) {

        List<Integer> capacity = List.of(5, 3, 2); // Expected: 3
        long requestInterval = 10;
//        List<Integer> capacity = List.of(3,1,7,2,4); // Expected: 3
//        long requestInterval = 15;
//        List<Integer> capacity = List.of(2,1,5,3,1); // Expected: 9
//        long requestInterval = 17;
//        List<Integer> capacity = List.of(3,1,4,2); // Expected: 9
//        long requestInterval = 3;

        System.out.println(calculateSchedulingTime(capacity, requestInterval));
    }

    private static int calculateSchedulingTime(List<Integer> capacity, long requestInterval) {
        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int cap : capacity) {
            maxHeap.offer((long)cap);
        }
        int seconds = 0;
        while(requestInterval >0) {
            long currentCapacity = maxHeap.poll();
            requestInterval -= currentCapacity;
            seconds++;
            maxHeap.offer(currentCapacity / 2);
        }
        return seconds;
    }
}
