/* 
539. Move Zeroes

Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Example

Given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
Notice

    You must do this in-place without making a copy of the array.
    Minimize the total number of operations.
*/ 

public class Solution {
    /**
     * @param nums: an integer array
     * @return: nothing
     */
    public void moveZeroes(int[] nums) {
        // write your code here 
        
        int second_ptr = 0; 
        for (int i = 0;i < nums.length;i ++) {
            if(nums[i] != 0) 
                nums[second_ptr ++] = nums[i]; 
        } 
        
        for (int i = second_ptr;i < nums.length;i ++) 
            nums[i] = 0; 
    }
} 
