/* 
63. Search in Rotated Sorted Array II

Follow up for Search in Rotated Sorted Array:

What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.
Example

Given [1, 1, 0, 1, 1, 1] and target = 0, return true.
Given [1, 1, 1, 1, 1, 1] and target = 0, return false.
*/ 

/* BEAT 100% submissions! */ 

/* 
	EASY WRONG POINTS: 
		1. When there are duplicates, is the time complexity > O(log n)? 
		The answer is YES. Because if A[mid] == A[start], u cannot really 
		tell if the A[mid] is in the first block or in the second. 
		Under this condition, u have to loop through all the elements in 
		the first/ second block to have a deeper look. 

		2. The time complexity is O(n). 
*/ 

public class Solution {
    /**
     * @param A: an integer ratated sorted array and duplicates are allowed
     * @param target: An integer
     * @return: a boolean 
     */
    public boolean search(int[] A, int target) {
        // write your code here 
        
        if (A == null || A.length == 0) 
            return false; 
        
        int start = 0, end = A.length - 1; 
        int mid; 
        while (start + 1 < end) {
            mid = start + (end - start) / 2; 
            if (A[mid] == target) {
                return true; 
            } else if (A[mid] == A[start]) { 
                /* When A[start] == A[mid], can verify which block the A[mid] is */ 
                boolean flag = true; 
                for (int i = start;i < mid;i ++) {
                    if (A[i + 1] != A[mid]) {
                        flag = false; 
                        break; 
                    } 
                } 
                
                if (flag) {
                    start = mid;   
                } else {
                    end = mid; 
                }
            } else if (A[mid] > A[start]) {
                if (A[mid] > target && A[start] <= target) {
                    end = mid; 
                } else {
                    start = mid;   
                } 
            } else { 
                if (A[mid] < target && A[end] >= target) {
                    start = mid; 
                } else {
                    end = mid; 
                }
            } 
        }  
        
        if (A[start] == target || A[end] == target) 
            return true; 
        
        return false; 
    }
}
