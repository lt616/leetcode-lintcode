/* 
32. Minimum Window Substring

Given a string source and a string target, find the minimum window in source which will contain all the characters in target.
Example

For source = "ADOBECODEBANC", target = "ABC", the minimum window is "BANC"
Challenge

Can you do it in time complexity O(n) ?
Clarification

Should the characters in minimum window has the same order in target?

    Not necessary.

Notice

If there is no such window in source that covers all characters in target, return the emtpy string "".
If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in source.
The target string may contain duplicate characters, the minimum window should cover all characters including the duplicate characters in target.
*/ 

public class Solution {
    /**
     * @param source : A string
     * @param target: A string
     * @return: A string denote the minimum window, return "" if there is no such a string
     */
    
    public String minWindow(String source , String target) {
        // write your code here 
        
        if (source == null || target == null) {
            return ""; 
        } 
        
        int[] target_chars = new int[150]; 
        int[] source_chars = new int[150]; 
        Set<Character> dict = new HashSet<Character>(); 
        
        for (int i = 0;i < target.length();i ++) { 
            char c = target.charAt(i); 
            dict.add(c); 
            target_chars[c] ++; 
        } 
        
        int j = 0, min_len = Integer.MAX_VALUE; 
        int start = 0, end = 0; 
        for (int i = 0;i < source.length();i ++) {
            while (j < source.length() && ! dict.isEmpty()) { 
                char c = source.charAt(j); 
                source_chars[c] ++; 
                if (dict.contains(c)) {
                    if (source_chars[c] >= target_chars[c]) {
                        dict.remove(c); 
                    } 
                } 
                j ++; 
            } 
            
            if (j <= source.length() && dict.isEmpty()) { 
                if (j - i < min_len) {
                    min_len = j - i; 
                    start = i; 
                    end = j; 
                }
            } 
            
            char c = source.charAt(i); 
            source_chars[c] --; 
            if (source_chars[c] < target_chars[c]) {
                dict.add(c); 
            }
        } 
        
        return source.substring(start, end);  
    }
}  


/* Solution 02: Improved Sliding Window */ 
class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return ""; 
        } 
        
        int[] char_num = new int[150]; 
        Set<Character> t_set = new HashSet<Character>(); 
        for (int i = 0;i < t.length();i ++) { 
            char_num[t.charAt(i) - 'A'] ++; 
            t_set.add(t.charAt(i)); 
        }
        
        int j = 0, min_len = Integer.MAX_VALUE, start = -1, end = -1; 
        for (int i = 0;i < s.length();i ++) {
            while (j < s.length() && ! t_set.isEmpty()) {
                char c = s.charAt(j); 
                char_num[c - 'A'] --; 
                
                if (t_set.contains(c)) { 
                    if (char_num[c - 'A'] == 0) {
                        t_set.remove(c); 
                    } 
                } 
                j ++; 
            } 
            
            if (j <= s.length() && t_set.isEmpty() && j - i < min_len) { 
                min_len = j - i; 
                start = i; 
                end = j; 
            } 
            
            char c = s.charAt(i); 
            char_num[c - 'A'] ++; 
            if (char_num[c - 'A'] == 1) {
                t_set.add(c); 
            }
        } 
        
        return (start == -1) ? "" : s.substring(start, end); 
    }
} 
