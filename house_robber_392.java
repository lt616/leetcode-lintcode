/* 
392. House Robber

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
Example

Given [3, 8, 4], return 8.
Challenge

O(n) time and O(1) memory.
*/ 

public class Solution {
    /**
     * @param A: An array of non-negative integers
     * @return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] A) {
        // write your code here 
        
        long res = 0; 
        if (A == null || A.length == 0) {
            return res;  
        } 
        
        long[] max_values = new long[A.length + 1]; 
        max_values[0] = 0; 
        max_values[1] = A[0]; 
        
        for (int i = 2;i <= A.length;i ++) {
            max_values[i] = max(max_values[i - 1], max_values[i - 2] + A[i - 1]); 
        } 
        
        return max_values[A.length]; 
    } 
    
    private long max(long a, long b) {
        return (a > b) ? a : b; 
    }
} 
