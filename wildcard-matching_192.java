/* 
192. Wildcard Matching

Implement wildcard pattern matching with support for '?' and '*'.

    '?' Matches any single character.
    '*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).
Example

isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
*/ 

/* 
	EASY WRONG POINTS: 
		1. When '*': is match '*' with index = 0 -> s.length(), then in next comparison, 
		match ???? 
		2. use memorization to optimise. 
*/ 

public class Solution {
    /**
     * @param s: A string 
     * @param p: A string includes "?" and "*"
     * @return: is Match?
     */ 
    
    boolean[][] memo; 
    boolean[][] is_visited; 
    
    public boolean isMatch(String s, String p) {
        // write your code here 
        
        if (s == null || p == null) {
            return false; 
        } 
        
        memo = new boolean[s.length()][p.length()]; 
        is_visited = new boolean[s.length()][p.length()]; 
        
        return combinationDFS(s, p, 0, 0); 
    } 
    
    private boolean combinationDFS(String s, String p, int s_index, int p_index) { 
        System.out.println(s_index + ", " + p_index); 
        if (s_index == s.length() && (p_index == p.length() || checkOnlyStarLeft(p, p_index))) {
            return true; 
        } else if (s_index == s.length() || p_index == p.length()) {
            return false; 
        } 
        
        if (is_visited[s_index][p_index]) {
            return memo[s_index][p_index]; 
        }
        
        boolean res = false; 
        if (s.charAt(s_index) == p.charAt(p_index) || p.charAt(p_index) == '?') {
            res = combinationDFS(s, p, s_index + 1, p_index + 1); 
        } else if (p.charAt(p_index) == '*') { 
            res = (combinationDFS(s, p, s_index, p_index + 1) || combinationDFS(s, p, s_index + 1, p_index)); 
            /*for (int i = s_index; i <= s.length();i ++) {
                res = combinationDFS(s, p, i, p_index + 1); 
                if (res) {
                    break; 
                }
            }*/
        } 
        
        is_visited[s_index][p_index] = true; 
        memo[s_index][p_index] = res; 
        
        return res;  
    } 
    
    private boolean checkOnlyStarLeft(String p, int index) { 
        for (int i = index;i < p.length();i ++) {
            if (p.charAt(i) != '*') {
                return false; 
            } 
        } 
        
        return true; 
    }
} 
