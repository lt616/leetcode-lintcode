/* 
640. One Edit Distance

Given two strings S and T, determine if they are both one edit distance apart.
Example

Given s = "aDb", t = "adb"
return true
*/ 

public class Solution {
    /**
     * @param s: a string
     * @param t: a string
     * @return: true if they are both one edit distance apart or false
     */ 
    
    boolean edited = false; 
    
    public boolean isOneEditDistance(String s, String t) {
        // write your code here 
        
        if (s == null || t == null) {
            return false; 
        } 
        
        return DFS(s, t, 0, 0) && edited; 
    } 
    
    private boolean DFS(String s, String t, int i, int j) {
        if (i == s.length() && j == t.length()) {
            return true; 
        } 
        
        if (i == s.length() || j == t.length()) { 
            if (! edited && (t.length() - j == 1 || s.length() - i == 1)) { 
                edited = true; 
                return true; 
            }
            return false; 
        } 
        
        if (s.charAt(i) == t.charAt(j)) {
            return DFS(s, t, i + 1, j + 1); 
        } else { 
            if (edited) {
                return false; 
            } 
            edited = true; 
            return (DFS(s, t, i + 1, j + 1) || DFS(s, t, i, j + 1) || DFS(s, t, i + 1, j)); 
        }
    }
} 
