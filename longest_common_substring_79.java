/* 
79. Longest Common Substring

Given two strings, find the longest common substring.

Return the length of it.
Example

Given A = "ABCD", B = "CBCE", return 2.
Challenge

O(n x m) time and memory.
Notice

The characters in substring should occur continuously in original string. This is different with subsequence.
*/ 

public class Solution {
    /**
     * @param A: A string
     * @param B: A string
     * @return: the length of the longest common substring.
     */ 
    
    public int longestCommonSubstring(String A, String B) {
        // write your code here 
        
        if (A == null || B == null) {
            return 0; 
        } 
        
        int max_v = 0; 
        int[][] dp_array = new int[A.length() + 1][B.length() + 1]; 
        for (int i = 1;i <= A.length();i ++) {
            for (int j = 1;j <= B.length();j ++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) { 
                    dp_array[i][j] = dp_array[i - 1][j - 1] + 1; 
                } 
                max_v = (dp_array[i][j] > max_v) ? dp_array[i][j] : max_v; 
            }
        }
        
        return max_v; 
    } 
    
    private int max(int a, int b, int c) {
        int res = (a > b) ? a : b; 
        return (res > c) ? res : c; 
    }
} 
