/* 
Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true

Example 2:

Input: s = "rat", t = "car"
Output: false

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
*/ 

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.equals(t)) {
            return true; 
        } 
        
        if (s.length() != t.length()) {
            return false; 
        } 
        
        int[] num_char = new int[26]; 
        for (int i = 0;i < s.length();i ++) {
            num_char[s.charAt(i) - 'a'] ++; 
        } 
        
        for (int i = 0;i < t.length();i ++) {
            num_char[t.charAt(i) - 'a'] --; 
            if (num_char[t.charAt(i) - 'a'] < 0) {
                return false; 
            } 
        } 
        
        return true; 
    }
} 
