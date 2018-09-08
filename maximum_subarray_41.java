/* 
41. Maximum Subarray

Given an array of integers, find a contiguous subarray which has the largest sum.
Example

Given the array [−2,2,−3,4,−1,2,1,−5,3], the contiguous subarray [4,−1,2,1] has the largest sum = 6.
Challenge

Can you do it in time complexity O(n)?
Notice

The subarray should contain at least one number.
*/ 

/* Solution 01: O(n ^ 2), time limited exceed */ 
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code here 
        
        int[][] memo = new int[nums.length][nums.length]; 
        int temp = 0; 
        for (int j = 0;j < nums.length;j ++) {
            temp += nums[j]; 
            memo[0][j] = temp; 
        } 

        for (int i = 1;i < nums.length;i ++) {
            for (int j = i;j < nums.length;j ++) {
                memo[i][j] = memo[i - 1][j] - nums[i - 1]; 
            } 
        }
        
        int max = Integer.MIN_VALUE;  
        for (int i = 0;i < nums.length;i ++) { 
            for (int j = i;j < nums.length;j ++) {
                int sum = memo[i][j]; 
                max = (sum > max) ? sum : max; 
            } 
        } 
        
        return max; 
    } 
} 


/* Solution 02: sliding window */ 
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code here 
        
        int max = Integer.MIN_VALUE; 
        int sum = 0; 
        for (int i = 0;i < nums.length;i ++) {
            if (sum < 0) {
                sum = 0; 
            } 
            
            sum += nums[i]; 
            max = (sum > max) ? sum : max; 
        } 
        
        return max; 
    } 
} 

