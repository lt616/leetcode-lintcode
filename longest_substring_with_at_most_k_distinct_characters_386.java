/* 
386. Longest Substring with At Most K Distinct Characters

Given a string s, find the length of the longest substring T that contains at most k distinct characters.
Example

For example, Given s = "eceba", k = 3,

T is "eceb" which its length is 4.
Challenge

O(n), n is the size of the string s.
*/ 

public class Solution {
    /**
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here 
        
        if (s == null || s.length() == 0 || k == 0) {
            return 0; 
        } 
        
        int max_len = Integer.MIN_VALUE; 
        Map<Character, Integer> num_count = new HashMap(); 
        Set<Character> unique_num = new HashSet(); 
        
        int j = 0; 
        for (int i = 0;i < s.length();i ++) {
            while (j < s.length() && (unique_num.size() < k || unique_num.contains(s.charAt(j)))) { 
                char c = s.charAt(j); 

                if (! num_count.containsKey(c)) { 
                    unique_num.add(c); 
                    num_count.put(c, 1); 
                } else { 
                    num_count.put(c, num_count.get(c) + 1);
                } 
                
                j ++; 
            } 
            
            
            if (j - i > max_len) { 
                max_len = j - i; 
            }
            
            char c = s.charAt(i);
            num_count.put(c, num_count.get(c) - 1); 
            if (num_count.get(c) == 0) {
                num_count.remove(c); 
                unique_num.remove(c); 
            } 
        } 
        
        return max_len; 
    }
} 
