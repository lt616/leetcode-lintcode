/* 
61. Search for a Range

Given a sorted array of n integers, find the starting and ending position of a given target value.

If the target is not found in the array, return [-1, -1].
Example

Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
Challenge

O(log n) time.
*/ 

/* 
	EASY WRONG POINTS: 
		1. When finding the last element: 
			first check "end", next check "start". Beacuse we want to find the last element. 
		2. Better solution: find left bound & right bound. 
*/ 

public class Solution {
    /**
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here 
        int[] res = new int[2]; 
        
        if (A == null || A.length == 0) {
            res[0] = -1; 
            res[1] = -1; 
            return res; 
        }
        
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
        } else if (A[end_left] == target) {
            res[0] = end_left; 
        } else {
            res[0] = -1; 
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
            res[1] = -1; 
        } 
        
        return res; 
    } 

}
