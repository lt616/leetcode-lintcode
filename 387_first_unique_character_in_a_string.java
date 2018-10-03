/* 
 Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.

Note: You may assume the string contain only lowercase letters. 
*/ 

class Solution {
    public int firstUniqChar(String s) { 
        if (s == null || s.length() == 0) {
            return -1; 
        }
        
        Set<Character> unique_char = new HashSet<Character>(); 
        Set<Character> dup_char = new HashSet<Character>(); 
        
        for (int i = 0;i < s.length();i ++) { 
            char c = s.charAt(i); 
            if (unique_char.contains(c)) {
                unique_char.remove(c);  
            } 
            
            if (! dup_char.contains(c)) {
                unique_char.add(c); 
                dup_char.add(c); 
            } 
        } 
        
        for (int i = 0;i < s.length();i ++) {
            if (unique_char.contains(s.charAt(i))) {
                return i; 
            }
        }
        
        return -1; 
    }
} 
