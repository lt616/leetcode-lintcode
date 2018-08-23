/* 
609. Two Sum - Less than or equal to target

Given an array of integers, find how many pairs in the array such that their sum is less than or equal to a specific target number. Please return the number of pairs.
Example

Given nums = [2, 7, 11, 15], target = 24.
Return 5.
2 + 7 < 24
2 + 11 < 24
2 + 15 < 24
7 + 11 < 24
7 + 15 < 25
*/ 

public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public int twoSum5(int[] nums, int target) {
        // write your code here 
        
        if (nums == null || nums.length == 0) 
            return 0; 
        Arrays.sort(nums); 
        int start = 0, end = nums.length - 1; 
        int sum, count = 0; 
        while (start < end) { 
            sum = nums[start] + nums[end]; 
            if (sum <= target) { 
                count += (end - start);  
                start ++; 
            } else {
                end --; 
            } 
        } 
        
        return count; 
    }
} 
