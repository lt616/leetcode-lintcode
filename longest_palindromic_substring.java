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



