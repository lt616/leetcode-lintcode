/* 
534. House Robber II

After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
Example

nums = [3,6,4], return 6
Notice

This is an extension of House Robber.
*/ 

/* 
	EASY WRONG POINTS: 
		1. How to DP loop cycle? 
		Split array[0 .. end] into array[0 .. end - 1] & array[1 .. end]. 
*/ 

public class Solution {
    /**
     * @param nums: An array of non-negative integers.
     * @return: The maximum amount of money you can rob tonight
     */
    public int houseRobber2(int[] nums) {
        // write your code here 
        
        int res = 0; 
        
        if (nums == null || nums.length == 0) {
            return res; 
        } 
        
        if (nums.length == 1) {
            return nums[0]; 
        }
        
        int[] first = new int[nums.length]; 
        int[] second = new int[nums.length]; 
        
        first[0] = 0; 
        first[1] = nums[0]; 
        
        for (int i = 2;i < nums.length;i ++) {
            first[i] = max(first[i - 1], first[i - 2] + nums[i - 1]); 
        } 
        
        second[0] = 0; 
        second[1] = nums[1]; 
        
        for (int i = 2; i < nums.length;i ++) {
            second[i] = max(second[i - 1], second[i - 2] + nums[i]); 
        } 
        
        return max(first[nums.length - 1], second[nums.length - 1]); 
    } 
    
    private int max(int a, int b) {
        return (a > b) ? a : b; 
    }
} 
