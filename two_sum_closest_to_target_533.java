/* 
533. Two Sum - Closest to target

Given an array nums of n integers, find two integers in nums such that the sum is closest to a given number, target.

Return the difference between the sum of the two integers and the target.
Example

Given array nums = [-1, 2, 1, -4], and target = 4.

The minimum difference is 1. (4 - (2 + 1) = 1).
Challenge

Do it in O(nlogn) time complexity.
*/ 

public class Solution {
    /**
     * @param nums: an integer array
     * @param target: An integer
     * @return: the difference between the sum and the target
     */
    public int twoSumClosest(int[] nums, int target) {
        // write your code here 
        
        if (nums == null || nums.length == 0) 
            return 0; 
        
        Arrays.sort(nums); 
        
        int start = 0, end = nums.length - 1; 
        int diff_min = Integer.MAX_VALUE; 
        int diff, sum; 
        while (start < end) { 
            sum = nums[start] + nums[end]; 
            if (sum == target) {
                return 0; 
            } else if (sum < target) { 
                diff = Math.abs(sum - target); 
                diff_min = (diff < diff_min) ? diff : diff_min; 
                start ++; 
            } else { 
                diff = Math.abs(sum - target); 
                diff_min = (diff < diff_min) ? diff : diff_min; 
                end --; 
            } 
        } 
        
        return diff_min;   
    }
} 
