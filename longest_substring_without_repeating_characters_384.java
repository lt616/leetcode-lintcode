/* 
384. Longest Substring Without Repeating Characters

Given a string, find the length of the longest substring without repeating characters.
Example

For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.

For "bbbbb" the longest substring is "b", with the length of 1.
Challenge

O(n) time
*/ 

public class Solution {
    /**
     * @param s: a string
     * @return: an integer
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here 
        
        if (s == null || s.length() == 0) {
            return 0; 
        } 
        
        Set<Character> set = new HashSet(); 
        
        int max_count = 0; 
        int j = 0; 
        for (int i = 0;i < s.length();i ++) { 

            while (j < s.length() && ! set.contains(s.charAt(j))) { 
                set.add(s.charAt(j)); 
                j ++; 
            } 
            
            max_count = max(max_count, j - i); 
            
            set.remove(s.charAt(i)); 
        } 
        
        return max_count; 
    } 
    
    private int max(int a, int b) {
        return (a > b) ? a : b; 
    }
} 
