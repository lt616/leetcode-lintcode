/* 
1472. Twins Strings

Given two strings s and t, each time you can exchange the characters on the odd or even bits of s, that is, the characters on the odd bits can be swaped with the characters of other odd bits, and even bits characters can be swaped with other even bits characters. Ask if you can exchange s to t after several exchanges.
Example

Give s="abcd"，t="cdab"，return"Yes".

Explanation:
Firstly exchange a and c, then exchange b and d.

Give s="abcd"，t="bcda"，return"No"。

Explanation:
No matter how you exchange, you can't get bcda.

Notice

    The string length does not exceed 100000100000100000
    Strings can be composed of uppercase letters, lowercase letters, and numbers
*/ 

public class Solution {
    /**
     * @param s: the first string
     * @param t: the second string
     * @return: If they are twin strings
     */
    public String isTwin(String s, String t) {
        // Write your code here 
        
        if (s.equals(t)) {
            return "Yes"; 
        }
        
        if (s == null || t == null || s.length() != t.length()) {
            return "No"; 
        }
        
        Map<Character, Integer> odd_map = new HashMap<Character, Integer>(); 
        Map<Character, Integer> even_map = new HashMap<Character, Integer>(); 
        
        boolean is_odd = true; 
        for (int i = 0;i < s.length();i ++) {
            if (is_odd) {
                insertToMap(odd_map, s.charAt(i)); 
            } else {
                insertToMap(even_map, s.charAt(i)); 
            } 
            
            is_odd = ! is_odd; 
        } 
        
        is_odd = true; 
        for (int i = 0;i < t.length();i ++) {
            if (is_odd) { 
                if (! delFromMap(odd_map, t.charAt(i))) {
                    return "No"; 
                }
            } else {
                if (! delFromMap(even_map, t.charAt(i))) {
                    return "No"; 
                } 
            } 
            
            is_odd = ! is_odd; 
        } 
        
        return "Yes"; 
    } 
    
    private void insertToMap(Map<Character, Integer> map, char c) {
        if (! map.containsKey(c)) {
            map.put(c, 0); 
        } 
        
        map.put(c, map.get(c) + 1); 
    } 
    
    private boolean delFromMap(Map<Character, Integer> map, char c) {
        if (! map.containsKey(c)) {
            return false; 
        } 
        
        map.put(c, map.get(c) - 1); 
        if (map.get(c) == 0) {
            map.remove(c); 
        } 
        
        return true; 
    }
} 
