/* 
461. Kth Smallest Numbers in Unsorted Array

Find the kth smallest number in an unsorted integer array.
Example

Given [3, 4, 1, 2, 5], k = 3, the 3rd smallest numbers is 3.
Challenge

An O(nlogn) algorithm is acceptable, if you can do it in O(n), that would be great.
*/ 

public class Solution {
    /**
     * @param k: An integer
     * @param nums: An integer array
     * @return: kth smallest element
     */
    public int kthSmallest(int k, int[] nums) {
        // write your code here 
        
        if (nums == null || nums.length == 0) {
            return -1; 
        } 
        
        int start = 0, end = nums.length - 1; 
        int mid; 
        while (start < end) { 
            
            int left = start, right = end; 
            mid = left + (right - left) / 2; 
            int privot = nums[mid]; 
            while (left <= right) { 
                while (left <= right && nums[left] < privot) {
                    left ++; 
                } 
                
                while (left <= right && nums[right] > privot) {
                    right --; 
                } 
                
                if (left <= right) {
                    swap(nums, left, right); 
                    left ++; 
                    right --; 
                } 
            } 
            
            if (k <= right) { 
                end = right; 
                continue; 
            } 
            
            if (k >= left) {
                start = left; 
                continue; 
            } 

            return nums[k - 1]; 
        } 
        

        
        return nums[k - 1]; 
    } 
    
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a]; 
        nums[a] = nums[b]; 
        nums[b] = temp; 
    }
} 
