/*
200. Longest Palindromic Substring

Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
Example

Given the string = "abcdzdcab", return "cdzdc".
Challenge

O(n2) time is acceptable. Can you do it in O(n) time. 
*/ 

/* Solution 01: enumeration center */ 
public class Solution {
    /**
     * @param s: input string
     * @return: the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        // write your code here 
        if (s.length() == 0 || s == null) 
            return ""; 
            
        int left; 
        int right; 
        int len; 
        int longest = Integer.MIN_VALUE; 
        int start = -1; 
        
        for (int i = 0;i < s.length(); i ++) {
            len = findLongestPalindrome(s, i, i) - 1; 
            
            if (longest < len) {
                longest = len;
                start = i - len / 2; 
            }
            
            len = findLongestPalindrome(s, i, i + 1); 
            
            if (longest < len) {
                longest = len; 
                start = i - len / 2 + 1; 
            } 
        } 
        
        System.out.println(longest + "," + start); 
        return s.substring(start, start + longest);  
    } 
    
    public int findLongestPalindrome(String s, int left, int right) {
        int count = 0; 
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count += 2; 
            left --; 
            right ++;  
        }
            
        return count; 
    }
} 


/* Solution 02: Dynamic programming 
                Reverse s and find the longest common substring with right index */ 
class Solution { 
    
    
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return ""; 
        } 
        
        StringBuilder sb = new StringBuilder(); 
        for (int i = s.length() - 1;i >= 0;i --) {
            sb.append(s.charAt(i)); 
        } 
        
        String rev_s = sb.toString(); 
        
        int[][] dp_array = new int[s.length() + 1][s.length() + 1]; 
        
        int max_len = 1, end = 0; 
        for (int i = 1;i <= s.length();i ++) {
            for (int j = 1;j <= rev_s.length();j ++) {
                if (s.charAt(i - 1) == rev_s.charAt(j - 1)) {
                    int len = dp_array[i - 1][j - 1] + 1; 
                    if (len > max_len && i - len == s.length() - j) {
                        max_len = len; 
                        end = i - 1; 
                    } 
                    
                    dp_array[i][j] = len; 
                }
            }
        } 

        return s.substring(end - max_len + 1, end + 1); 
    } 
} 


