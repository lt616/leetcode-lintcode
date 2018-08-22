/* 462. Total Occurrence of Target

Given a target number and an integer array sorted in ascending order. Find the total number of occurrences of target in the array.
Example

Given [1, 3, 3, 4, 5] and target = 3, return 2.

Given [2, 2, 3, 4, 6] and target = 4, return 1.

Given [1, 2, 3, 4, 5] and target = 6, return 0.
Challenge

Time complexity in O(logn)
*/ 

public class Solution {
    /**
     * @param A: A an integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int totalOccurrence(int[] A, int target) {
        // write your code here 
        
        if (A == null || A.length == 0) 
            return 0; 
        
        int[] res = new int[2]; 
        
        /* Find left bound */ 
        int start_left = 0, end_left = A.length - 1; 
        int mid_left; 
        while (start_left + 1 < end_left) {
            mid_left = start_left + (end_left - start_left) / 2; 
            if (A[mid_left] >= target) {
                end_left = mid_left; 
            } else {
                start_left = mid_left; 
            } 
        } 
        
        if (A[start_left] == target) {
            res[0] = start_left; 
        } else if(A[end_left] == target) {
            res[0] = end_left; 
        } else {
            return 0; 
        } 
        
        /* Find right bound */ 
        int start_right = 0, end_right = A.length - 1; 
        int mid_right; 
        while (start_right + 1 < end_right) {
            mid_right = start_right + (end_right - start_right) / 2; 
            if (A[mid_right] <= target) {
                start_right = mid_right; 
            } else {
                end_right = mid_right; 
            } 
        } 
        
        if (A[end_right] == target) {
            res[1] = end_right; 
        } else if (A[start_right] == target) {
            res[1] = start_right; 
        } else {
            return 0;  
        } 
        
        return res[1] - res[0] + 1;  
    }
}
