package org.example;

/*
# **Distribute Energy Packets**
You are given `n` packets, where `packets[i]` represents the size of the i-th energy packet.
Each packet can be split into any number of smaller sub-packets, but you cannot merge packets together.
You are also given `agents`, representing the number of agents who must each receive a packet of the same size.
Each agent must receive their allocation from one sub-packet only, and some packets may go unused.
Return the maximum number of units each agent can receive equally.
---
### Example 1
**Input:**
```
packets = [7, 10, 4]
agents = 4
```
**Output:**
```
4
```
**Explanation:**
* Divide 7 → 4 + 3
* Divide 10 → 4 + 4 + 2
* Now we have 4 packets of size 4
* Assign 4, 4, 4, 4 to 4 agents
*
*/
public class Solution01 {
    public static void main(String[] args) {
        System.out.printf("**Distribute Energy Packets**");

        // Test Case 1
        long[] packets1 = {7, 10, 4};
        long agents1 = 4;
        System.out.println("Test 01: " + solution(packets1, agents1)); // Expected: 4
    }

    private static long solution(long[] packets, long agents) {
        long left = 1;
        long right = 0;

        for(long p: packets) {
            right = Math.max(right, p);
        }

        long result = 0;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if(canDistribute(packets, agents, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }
        return result;
    }

    private static boolean canDistribute(long[] packets, long agents, long size) {
        long count = 0;
        for(long p : packets) {
            count += p/size;
            if(count >= agents) {
                return true;
            }
        }
        return false;
    }
}
