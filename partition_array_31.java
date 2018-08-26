/* 
31. Partition Array

Given an array nums of integers and an int k, partition the array (i.e move the elements in "nums") such that:

    All elements < k are moved to the left
    All elements >= k are moved to the right

Return the partitioning index, i.e the first index i nums[i] >= k.
Example

If nums = [3,2,2,1] and k=2, a valid answer is 1.
Challenge

Can you partition the array in-place and in O(n)?
Notice

You should do really partition in array nums instead of just counting the numbers of integers smaller than k.

If all elements in nums are smaller than k, then return nums.length
*/ 


/* Solution 01: quick select */ 
public class Solution {
    /**
     * @param nums: The integer array you should partition
     * @param k: An integer
     * @return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        // write your code here 
        
        if (nums == null || nums.length == 0) {
            return 0;  
        } 
        
        int index = -1;  
        for (int i = 0;i < nums.length;i ++) {
            if (nums[i] < k) {
                swap(nums, i, ++ index); 
            } 
        } 
        
        if (index == nums.length - 1) {
            return nums.length; 
        }
        
        return index + 1;   
    } 
    
    private void swap(int[] nums, int a, int b) {
        int temp = nums[b]; 
        nums[b] = nums[a]; 
        nums[a] = temp; 
    } 
} 


/* Solution 02: partition */ 
public class Solution {
    /**
     * @param nums: The integer array you should partition
     * @param k: An integer
     * @return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        // write your code here 
        
        if (nums == null || nums.length == 0) {
            return 0;  
        } 
        
        int left = 0, right = nums.length - 1; 
        while (left <= right) {
            while (left <= right && nums[left] < k) {
                left ++; 
            } 
            
            while (left <= right && nums[right] >= k) {
                right --; 
            } 
            
            if (left <= right) {
                swap(nums, left, right); 
                left ++; 
                right --; 
            } 
        } 
        
        return left; 
        
    } 
    
    private void swap(int[] nums, int a, int b) {
        int temp = nums[b]; 
        nums[b] = nums[a]; 
        nums[a] = temp; 
    } 
} 
