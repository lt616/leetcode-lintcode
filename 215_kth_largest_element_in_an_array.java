/* 
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5

Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4

Note:
You may assume k is always valid, 1 ≤ k ≤ array's length.
*/ 

class Solution {
    public int findKthLargest(int[] nums, int k) {
        return partition(nums, 0, nums.length - 1, k - 1); 
    } 
    
    private int partition(int[] nums, int start, int end, int k) {
        int left = start, right = end; 
        int privot = nums[start + (end - start) / 2]; 
        while (left <= right) {
            while (left <= right && nums[left] > privot) {
                left ++; 
            } 
            
            while (left <= right && nums[right] < privot) {
                right --; 
            } 
            
            if (left <= right) {
                swap(nums, left, right); 
                left ++; 
                right --; 
            } 
        } 
        
        if (k <= right) {
            return partition(nums, start, right, k); 
        } 
        
        if (k >= left) {
            return partition(nums, left, end, k); 
        } 
        
        return nums[k];  
    } 
    
    private void swap(int[] nums, int a, int b) {
        int temp = nums[b]; 
        nums[b] = nums[a]; 
        nums[a] = temp; 
    }
} 
