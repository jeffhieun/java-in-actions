package org.example;


import java.util.HashMap;
import java.util.Map;

public class Solution04 {
    public static void main(String[] args) {
        System.out.printf("**firstUniqCharacterLowerCase**");
        String input1 ="leetcode"; // 0
        System.out.println("firstUniqCharacterLowerCase==>> My output 1: " + firstUniqCharacterLowerCase(input1));

        String input2 ="Google"; // 0
        System.out.println("findAnyCase==>> My output 1: " + findAnyCase(input2));
    }

    private static int firstUniqCharacterLowerCase(String input) {
        int[] freq = new int[26]; //0-25 lowercase

        for(int i=0; i< input.length(); i++) {
            freq[input.charAt(i) - 'a'] ++;
        }

        for (int i=0; i < input.length(); i++) {
            if(freq[input.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    private static int findAnyCase(String input) {
        Map<Character, Integer> count = new HashMap<>();

        for(char c : input.toCharArray()) {
            count.put(c, count.getOrDefault(c,0) + 1);
        }

        for(int i=0; i< input.length(); i++) {
            if(count.get(input.charAt(i)) == 1) {
                return 1;
            }
        }
        return -1;
    }

}
