/* 
159. Find Minimum in Rotated Sorted Array

Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.
Example

Given [4, 5, 6, 7, 0, 1, 2] return 0
Notice

You may assume no duplicate exists in the array.
*/ 

/* 
	EASY WRONG POINTS: 
		1. ATTENTION! consider all the conditions. 
*/ 

public class Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here 
        
        if (nums == null || nums.length == 0) 
            return -1; 
        
        int start = 0, end = nums.length - 1; 
        int mid; 
        while (start + 1 < end) {
            mid = start + (end - start) / 2; 
            if (nums[mid] >= nums[start]) {
                if (nums[mid] > nums[end]) {
                    start = mid; 
                } else {
                    return nums[start]; 
                }
            } else { 
                end = mid; 
            } 
            System.out.println(start + ", " + end); 
        } 
        
        return (nums[start] < nums[end]) ? nums[start] : nums[end]; 
    }
}
