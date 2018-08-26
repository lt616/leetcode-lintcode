/* 
625. Partition Array II

Partition an unsorted integer array into three parts:

    The front part < low
    The middle part >= low & <= high
    The tail part > high

Return any of the possible solutions.
Example

Given [4,3,4,1,2,3,1,2], and low = 2 and high = 3.

Change to [1,1,2,3,2,3,4,4].

([1,1,2,2,3,3,4,4] is also a correct answer, but [1,2,1,2,3,3,4,4] is not)
Challenge

    Do it in place.
    Do it in one pass (one loop).

Notice

low <= high in all testcases.
*/ 

public class Solution {
    /**
     * @param nums: an integer array
     * @param low: An integer
     * @param high: An integer
     * @return: nothing
     */
    public void partition2(int[] nums, int low, int high) {
        // write your code here 
        
        int index_left = -1, index_right = nums.length, i = 0; 
        while (i < index_right) {
            if (nums[i] < low) { 
                swap(nums, i, ++ index_left); 
                i ++; 
            } else if (nums[i] > high) {
                swap(nums, i, -- index_right);
            } else {
                i ++; 
            }
        } 
    } 
    
    private void swap(int[] nums, int a, int b) { 
        /*System.out.println(a + ", " + b); */
        int temp = nums[b]; 
        nums[b] = nums[a]; 
        nums[a] = temp; 
    }
} 
