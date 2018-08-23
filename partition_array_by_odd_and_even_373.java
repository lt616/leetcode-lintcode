/* 
373. Partition Array by Odd and Even

Partition an integers array into odd number first and even number second.
Example

Given [1, 2, 3, 4], return [1, 3, 2, 4]
Challenge

Do it in-place.
*/ 

/* BUG FREE !! */ 

public class Solution {
    /*
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        // write your code here 
        
        int start = 0, end = nums.length - 1; 
        while (start < end) {
            while (start < end && nums[start] % 2 == 1) {
                start ++; 
            } 
            
            while (start < end && nums[end] % 2 == 0) {
                end --; 
            } 
            
            if (start < end) {
                int temp = nums[end]; 
                nums[end] = nums[start]; 
                nums[start] = temp; 
                
                start ++; 
                end --; 
            } 
        } 
    } 
} 
