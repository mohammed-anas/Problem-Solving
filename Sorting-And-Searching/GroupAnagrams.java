package com.programming;

import java.util.*;

public class GroupAnagrams {


    // O(NLogN)
    public static String sortChars(String str1){
        char[] arr = str1.toCharArray();
        Arrays.sort(arr);
        return String.valueOf(arr);
    }
    public static List<String> groupAnagrams(String[] words){
        Map<String, List<String>> map = new TreeMap<>();

        for (String word: words) {

            String sortChars = sortChars(word);
            if(map.get(sortChars) == null) {
                List<String> list = Arrays.asList(word);
                map.put(sortChars, list);
            }
            else {
                List<String> list = new ArrayList<>(map.get(sortChars));
                list.add(word);
                list.sort(Comparator.naturalOrder());
                map.put(sortChars,list);
            }
        }
        List<String> output = new ArrayList<>();
        for (String key:map.keySet()) {
            output.addAll(map.get(key));
        }
        return output;
    }
    public static void main(String[] args) {
        String[] words = {"forest", "earth", "reacted", "heart", "fortes", "created", "resign", "singer"};
        System.out.println(groupAnagrams(words));
    }
}
