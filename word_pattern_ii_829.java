/* 
829. Word Pattern II

Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.(i.e if a corresponds to s, then b cannot correspond to s. For example, given pattern = "ab", str = "ss", return false.)
Example

Given pattern = "abab", str = "redblueredblue", return true.
Given pattern = "aaaa", str = "asdasdasdasd", return true.
Given pattern = "aabb", str = "xyzabcxzyabc", return false.
Notice

You may assume both pattern and str contains only lowercase letters.
*/ 

/* 
    EASY WRONG POINTS: 
        1. Don't forget to clear the buffer when return to previous recursion. 
Y
*/ 

public class Solution {
    /**
     * @param pattern: a string,denote pattern string
     * @param str: a string, denote matching string
     * @return: a boolean
     */ 
    
    Map<Character, String> pattern_to_str; 
    Map<String, Character> str_to_pattern; 
    
    public boolean wordPatternMatch(String pattern, String str) {
        // write your code here 
        
        if (pattern.length() == 0 && str.length() == 0) {
            return true; 
        } 
        
        if (pattern == null || pattern.length() == 0 || str == null || str.length() == 0) {
            return false; 
        } 
        
        pattern_to_str = new HashMap(); 
        str_to_pattern = new HashMap(); 
        
        return combinationDFS(pattern, str, 0, 0); 
    } 
    
    private boolean combinationDFS(String pattern, String str, int index_p, int index_s) {
        if (index_p == pattern.length()) { 
            return true; 
        } 

        if (pattern_to_str.containsKey(pattern.charAt(index_p))) { 
            String temp = pattern_to_str.get(pattern.charAt(index_p)); 
            int end_index = index_s + temp.length(); 
            
            if (end_index <= str.length() && temp.equals(str.substring(index_s, end_index))) { 
                if (combinationDFS(pattern, str, index_p + 1, end_index)) {
                    return true; 
                } 
            } 
        } else {
            for (int i = index_s;i < str.length();i ++) { 
                String temp = str.substring(index_s, i + 1); 
                if (str_to_pattern.containsKey(temp)) { 
                    continue; 
                } 
                
                pattern_to_str.put(pattern.charAt(index_p), temp); 
                str_to_pattern.put(temp, pattern.charAt(index_p)); 
                
                if (combinationDFS(pattern, str, index_p + 1, i + 1)) { 
                    pattern_to_str.remove(pattern.charAt(index_p)); 
                    str_to_pattern.remove(temp); 
                    return true; 
                } 
                
                pattern_to_str.remove(pattern.charAt(index_p)); 
                str_to_pattern.remove(temp); 
            } 
        } 
        
        return false; 
    } 
} 
