/* 
143. Sort Colors II

Given an array of n objects with k different colors (numbered from 1 to k), sort them so that objects of the same color are adjacent, with the colors in the order 1, 2, ... k.
Example

Given colors=[3, 2, 2, 1, 4], k=4, your code should sort colors in-place to [1, 2, 2, 3, 4].
Challenge

A rather straight forward solution is a two-pass algorithm using counting sort. That will cost O(k) extra memory. Can you do it without using extra memory?
Notice

You are not suppose to use the library's sort function for this problem.

k <= n
*/ 


/* Solution 01: quick sort */ 
public class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here 
        
        if (colors == null || colors.length == 0) {
            return; 
        } 
        
        int start = 0, end = colors.length - 1; 
        quickSort(colors, start, end); 
    } 
    
    private void quickSort(int[] nums, int start, int end) { 
        if (start >= end) { 
            return; 
        } 

        int left = start, right = end; 
        int mid = start + (end - start) / 2; 
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
        
        quickSort(nums, start, left - 1); 
        quickSort(nums, left, end); 
    } 
    
    private void swap(int[] nums, int a, int b) {
        int temp = nums[b]; 
        nums[b] = nums[a]; 
        nums[a] = temp; 
    }
} 


/* Solution 02: bubble sort */ 
public class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here 
        
        if (colors == null || colors.length == 0) {
            return; 
        } 
        
        for (int i = colors.length - 1;i >= 0;i --) {
            bubbleSort(colors, i); 
        } 
    } 
    
    private void bubbleSort(int[] colors, int end) {
        for (int i = 0;i < end;i ++) {
            if (colors[i] > colors[i + 1]) {
                swap(colors, i, i + 1); 
            }
        }
    }
    
    private void swap(int[] nums, int a, int b) {
        int temp = nums[b]; 
        nums[b] = nums[a]; 
        nums[a] = temp; 
    }
} 
