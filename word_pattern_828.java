/* 
828. Word Pattern

Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
Example

Given pattern = "abba", str = "dog cat cat dog", return true.
Given pattern = "abba", str = "dog cat cat fish", return false.
Given pattern = "aaaa", str = "dog cat cat dog", return false.
Given pattern = "abba", str = "dog dog dog dog", return false.
Notice

You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
*/ 

public class Solution {
    /**
     * @param pattern: a string, denote pattern string
     * @param teststr: a string, denote matching string
     * @return: an boolean, denote whether the pattern string and the matching string match or not
     */
    public boolean wordPattern(String pattern, String teststr) {
        // write your code here 
        
        if (pattern.length() == 0 || teststr.length() == 0) {
            return true; 
        }
        
        if (pattern == null || teststr == null) {
            return false; 
        } 
        
        int size_pattern = pattern.length(); 
        String[] test_strs = teststr.split(" "); 
        int size_str = test_strs.length; 
        
        if (size_pattern != size_str) {
            return false; 
        } 
        
        Map<Character, String> hash = new HashMap(); 
        Map<String, Character> reverse_hash = new HashMap(); 
        
        for (int i = 0;i < size_pattern;i ++) {
            if (! hash.containsKey(pattern.charAt(i))) { 
                if (reverse_hash.containsKey(test_strs[i])) {
                    return false; 
                }
                hash.put(pattern.charAt(i), test_strs[i]); 
                reverse_hash.put(test_strs[i], pattern.charAt(i)); 
            } else {
                if (! hash.get(pattern.charAt(i)).equals(test_strs[i])) { 
                    return false; 
                } 
            } 
        } 
        
        return true; 
    }
} 
