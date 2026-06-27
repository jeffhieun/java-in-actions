package org.example;

import java.util.*;

/*
Test Case 1:
String[][] instructions = {
    {"Jeff", "B"},
    {"Peter", "B"},
    {"Mary", "D"},
    {"Hieu", "D"}
};
String[] wc = {"D"};
*/
public class Solution07 {

    private static List<String> findWC(String[][] wayWCs, String[] wc) {
        Set<String> wcSet = new HashSet<>(Arrays.asList(wc));
//        Set<String> wcSet = Set.of(wc);
        Map<String, String> nextWcMap = new HashMap<>();
        Map<String, Integer>  integerMap = new HashMap<>();
        for(String[] wayWC: wayWCs) {
            String fromWayWC = wayWC[0];
            String toWayWC = wayWC[1];
            nextWcMap.put(fromWayWC, toWayWC);
            if(!fromWayWC.equals(toWayWC)) {
                integerMap.put(toWayWC, integerMap.getOrDefault(toWayWC, 0) + 1);
            }
        }

        List<String> result = new ArrayList<>();;
        for(Map.Entry<String, String> entry : nextWcMap.entrySet()) {
            String fromWayWC = entry.getKey();
            String toWayWC = entry.getValue();
            if(integerMap.getOrDefault(fromWayWC,0) >=2 && wcSet.contains(toWayWC)) {
                result.add(fromWayWC);
            }
        }
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
//        String[][] wayToWC = {
//                {"Jeff", "B"},
//                {"Peter", "B"},
//                {"B", "D"},
//                {"D", "D"},
//                {"D", "E"}
//        };
//        String[] wc = {"D"};
//        List<String> result = findWC(wayToWC, wc);
//        System.out.println(result); // Output: [B]

        String[][] wayToWC01 = {
                {"A", "E"},
                {"B", "D"},
                {"C", "1"},
                {"F", "1"},
                {"1", "T"}
        }; // []
        String[] wc01 = {"T"};
        List<String> result01 = findWC(wayToWC01, wc01);
        System.out.println(result01); // Output: []

    }


}
