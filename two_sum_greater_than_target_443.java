/* 
443. Two Sum - Greater than target

Given an array of integers, find how many pairs in the array such that their sum is bigger than a specific target number. Please return the number of pairs.
Example

Given numbers = [2, 7, 11, 15], target = 24. Return 1. (11 + 15 is the only pair)
Challenge

Do it in O(1) extra space and O(nlogn) time.
*/ 

public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: An integer
     * @return: an integer
     */
    public int twoSum2(int[] nums, int target) {
        // write your code here 
        int count = 0; 
        
        if (nums == null || nums.length == 0) {
            return count; 
        } 
        
        Arrays.sort(nums); 
        
        int count_sum = 0; 
        for (int i = 0;i < nums.length - 1;i ++) { 
            count_sum += binaryS(nums, i + 1, nums.length - 1, target - nums[i]); 
        } 
        
        return count_sum; 
    } 
    
    private int binaryS(int[] nums, int start, int end, int t) {
        int left = start, right = end; 
        int mid; 
        while (left + 1 < right) {
            mid = left + (right - left) / 2; 
            if (nums[mid] <= t) {
                left = mid; 
            } else if (nums[mid] > t) {
                right = mid; 
            } 
        } 
        
        if (nums[left] > t) {
            return end - left + 1; 
        } 
        
        if (nums[right] > t) {
            return end - right + 1; 
        } 
        
        return 0; 
    }
} 
