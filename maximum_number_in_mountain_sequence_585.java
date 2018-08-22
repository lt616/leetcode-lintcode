/* 
585. Maximum Number in Mountain Sequence

Given a mountain sequence of n integers which increase firstly and then decrease, find the mountain top.
Example

Given nums = [1, 2, 4, 8, 6, 3] return 8
Given nums = [10, 9, 8, 7], return 10
*/ 

public class Solution {
    /**
     * @param nums: a mountain sequence which increase firstly and then decrease
     * @return: then mountain top
     */
    public int mountainSequence(int[] nums) {
        // write your code here 
        
        if (nums == null || nums.length == 0) 
            return -1; 
            
        int start = 0, end = nums.length - 1; 
        int mid; 
        while (start + 1 < end) { 
            mid = start + (end - start) / 2; 
            
            if (nums[mid - 1] < nums[mid]) 
                start = mid; 
            else 
                end = mid - 1; 
        } 
        
        int res = (nums[start] >= nums[end]) ? nums[start] : nums[end]; 
        
        return res; 
    }
}
