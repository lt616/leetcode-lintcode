/* 
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 

Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/ 

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max_len = 0; 
        
        if (s == null) {
            return max_len; 
        } 
        
        Set<Character> visited = new HashSet<Character>(); 
        
        int j = 0; 
        for (int i = 0;i < s.length();i ++) {
            while (j < s.length() && ! visited.contains(s.charAt(j))) {
                visited.add(s.charAt(j)); 
                j ++; 
            } 
            
            if (j <= s.length()) { 
                int count = j - i; 
                max_len = (count > max_len) ? count : max_len; 
            } 
            
            visited.remove(s.charAt(i)); 
        } 
        
        return max_len; 
    }
} 
