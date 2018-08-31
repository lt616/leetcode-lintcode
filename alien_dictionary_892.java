/* 
892. Alien Dictionary

There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.
Example

Given the following words in dictionary,

[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]

The correct order is: "wertf"

Given the following words in dictionary,

[
  "z",
  "x"
]

The correct order is: "zx".
Notice

    You may assume all letters are in lowercase.
    You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
    If the order is invalid, return an empty string.
    There may be multiple valid order of letters, return the smallest in lexicographical order
*/ 

/* 
	EASY WRONG POINTS: 
		1. How to keep the result in lexicographical order? 
		Using priority queue instead of normal queue. 
		2. Don't forget to check it the result is a topological order -- which means no element  
		should be left outside the result data. 
*/ 

public class Solution {
    /**
     * @param words: a list of words
     * @return: a string which is correct order
     */
    public String alienOrder(String[] words) {
        // Write your code here 
        
        if (words == null || words.length == 0 || words.length == 1) {
            return null; 
        } 
        
        Map<Character, List<Character>> dict = new HashMap(); 
        Map<Character, Integer> map = new HashMap(); 
        Queue<Character> queue = new PriorityQueue();       // to keep output in lexicographical order 
        
        for (int i = 0;i < words.length;i ++) {
            for (int j = 0;j < words[i].length();j ++) {
                if (! map.containsKey(words[i].charAt(j))) {
                    map.put(words[i].charAt(j), 0); 
                }
            }
        }
        
        for (int i = 1;i < words.length;i ++) {
            int first_pointer = 0; 
            int second_pointer = 0; 
            
            while (first_pointer < words[i - 1].length() && second_pointer < words[i].length() && words[i - 1].charAt(first_pointer) == words[i].charAt(second_pointer)) {
                first_pointer ++; 
                second_pointer ++; 
            } 
            
            if (first_pointer < words[i - 1].length() && second_pointer < words[i].length()) {
                char u = words[i - 1].charAt(first_pointer); 
                char v = words[i].charAt(second_pointer); 
                if (! dict.containsKey(u)) {
                    dict.put(u, new ArrayList()); 
                } 
                System.out.println(u + ", " + v); 
                dict.get(u).add(v); 
                map.put(v, map.get(v) + 1); 
            } 
        } 
        
        for (Character u : map.keySet()) {
            if (map.get(u) == 0) {
                queue.offer(u); 
            }
        } 
        
        StringBuilder res = new StringBuilder(); 
        while (! queue.isEmpty()) { 
            Character current = queue.poll(); 
            res.append(current); 
            System.out.println(current); 

            if (! dict.containsKey(current)) {      // for the last element 
                continue; 
            } 
            
            List<Character> temp = dict.get(current); 
            for (Character word : temp) { 
                map.put(word, map.get(word) - 1); 
                if (map.get(word) == 0) {
                    queue.offer(word);  
                }
            } 
        } 
        
        for (Character u : map.keySet()) {
            if (map.get(u) != 0) {
                return new String(); 
            }
        }
        
        System.out.println(res.toString()); 
        return res.toString(); 
    }
} 
