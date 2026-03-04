package org.example;

/*
Given an input string s, reverse the order of the words.
A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
Return a string of the words in reverse order concatenated by a single space.
Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

Example 1:
Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
*/
public class Solution03 {
    public static void main(String[] args) {
        System.out.printf("**reverseWords**");
        String input ="a good   example";
        System.out.println(" My output: " + reverseWords(input));
    }

    private static String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        int slow =0, fast = 0;

        while (fast <n) {
            while (fast <n && arr[fast] == ' ') fast++;

            while (fast <n && arr[fast] != ' ') {
                arr[slow++] = arr[fast++];
            }

            while (fast < n && arr[fast] ==' ') fast++;

            if(fast < n) arr[slow++] = ' ';
        }
        int newLen = slow;
        reverse(arr, 0, newLen-1);

        int start = 0;
        for(int end =0; end <= newLen; end++) {
            if(end == newLen || arr[end] == ' ') {
                reverse(arr, start, end -1);
                start = end +1;
            }
        }
        return new String(arr, 0, newLen);
    }

    private static void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = temp;
        }
    }
}
