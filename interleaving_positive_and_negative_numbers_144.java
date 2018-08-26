/* 
144. Interleaving Positive and Negative Numbers

Given an array with positive and negative integers. Re-range it to interleaving with positive and negative integers.
Example

Given [-1, -2, -3, 4, 5, 6], after re-range, it will be [-1, 5, -2, 4, -3, 6] or any other reasonable answer.
Challenge

Do it in-place and without extra memory.
Notice

You are not necessary to keep the original order of positive integers or negative integers.
*/ 

public class Solution {
    /*
     * @param A: An integer array.
     * @return: nothing
     */
    public void rerange(int[] A) {
        // write your code here 
        
        if (A == null || A.length == 0 || A.length == 1) {
            return; 
        } 

        int start = 0, end = A.length - 1; 
        while (start <= end) {
            while (start <= end && A[start] < 0) {
                start ++; 
            } 
            
            while (start <= end && A[end] > 0) {
                end --; 
            } 
            
            if (start <= end) { 
                swap(A, start, end); 
                start ++; 
                end --; 
            } 
        } 
        
        for (int i = 0;i < A.length;i ++) {
            System.out.println(A[i] + " "); 
        }
        
        int mid = (0 + A.length) / 2; 
        start = 0; 
        end = A.length - 1; 
        if (A.length % 2 == 1 && ((A[0] < 0) == (A[mid] < 0))) {
            start ++; 
        } else if (A.length % 2 == 1 && ((A[end] < 0) == (A[mid] < 0))) { 
            end --; 
        } 
        
        while (start < end) {
            swap(A, start, end); 
            start += 2; 
            end -= 2;  
        }
    } 
    
    private void swap(int[] nums, int a, int b) {
        int temp = nums[b]; 
        nums[b] = nums[a]; 
        nums[a] = temp; 
    }
} 
