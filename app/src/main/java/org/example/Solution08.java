package org.example;

import java.util.*;

/**
 * A[] = latency values
 * Window size = Y
 * Threshold = Z
 */

public class Solution08 {

    private static int solution01(int[] A, int Y, int Z) {
        for(int i=0; i <= A.length - Y; i++) {
            int max = A[i];
            int min = A[i];

            for(int j=i; j<i + Y; j++) {
                max = Math.max(max, A[j]);
                min = Math.min(min, A[j]);
            }
            if(max - min > Z) {
                return 1;
            }
        }
        return 0;
    }

    //Monotonic Deque
    private static int solution(int[] A, int Y, int Z) {
        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();

        for(int i=0; i<A.length; i++) {
            while (!maxDeque.isEmpty() && maxDeque.peekFirst() <= i - Y)
                maxDeque.pollFirst();
            while (!minDeque.isEmpty() && minDeque.peekFirst() <= i - Y){
                minDeque.pollFirst();
            }
            while (!maxDeque.isEmpty() && A[maxDeque.peekLast()] <= A[i]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(i);

            while (!minDeque.isEmpty() && A[minDeque.peekLast()] >= A[i]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(i);
            if( i >= Y -1 && !maxDeque.isEmpty() && !minDeque.isEmpty()) {
                int max = A[maxDeque.peekFirst()];
                int min = A[minDeque.peekFirst()];
                if(max - min > Z) {
                    return 1; // Unstable
                }
            }
         }
        return 0; // Stable
    }

    public static void main(String[] args) {

        //System.out.println("Stable:" + solution(new int[]{1, 2, 3, 4, 5}, 2, 4)); // Output: 0; // Stable
        //System.out.println("Unstable: " + solution(new int[]{9, 8, 7, 6, 100}, 3, 50)); //1; // Unstable
        //System.out.println(solution(new int[]{1, 100, 1, 100, 1},3, 50));

        System.out.println("Stable:" + solution01(new int[]{1, 2, 3, 4, 5}, 2, 4)); // Output: 0; // Stable
        System.out.println("Unstable: " + solution01(new int[]{9, 8, 7, 6, 100}, 3, 50)); //1; // Unstable
        System.out.println(solution01(new int[]{1, 100, 1, 100, 1},3, 50));


    }
}
