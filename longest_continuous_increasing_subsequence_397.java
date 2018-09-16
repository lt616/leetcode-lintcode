/* 
397. Longest Continuous Increasing Subsequence

Give an integer array，find the longest increasing continuous subsequence in this array.

An increasing continuous subsequence:

    Can be from right to left or from left to right.
    Indices of the integers in the subsequence should be continuous.

Example

For [5, 4, 2, 1, 3], the LICS is [5, 4, 2, 1], return 4.

For [5, 1, 2, 3, 4], the LICS is [1, 2, 3, 4], return 4.
Challenge

O(n) time and O(1) extra space.
*/ 

public class Solution {
    /**
     * @param A: An array of Integer
     * @return: an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // write your code here 
        
        if (A == null || A.length == 0) {
            return 0; 
        } 
        
        int[] ascend = new int[A.length]; 
        int[] descend = new int[A.length]; 
        
        ascend[0] = 1; 
        descend[0] = 1; 
        
        int max = 1; 
        for (int i = 1;i < A.length;i ++) {
            if (A[i - 1] < A[i]) { 
                ascend[i] = ascend[i - 1] + 1; 
            } else {
                ascend[i] = 1; 
            } 
            max = (ascend[i] > max) ? ascend[i] : max; 
            
            if (A[i] < A[i - 1]) {
                descend[i] = descend[i - 1] + 1; 
            } else {
                descend[i] = 1; 
            } 
            max = (descend[i] > max) ? descend[i] : max; 
        } 
        
        return max; 
    }
} 
