/* 
62. Search in Rotated Sorted Array

Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
Example

For [4, 5, 1, 2, 3] and target=1, return 2.

For [4, 5, 1, 2, 3] and target=0, return -1.
Challenge

O(logN) time
*/ 

/* 
	EASY WRONG POINTS: 
		1. In total 6 conditions. 
*/ 

public class Solution {
    /**
     * @param A: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search(int[] A, int target) {
        // write your code here 
        
        if (A == null || A.length == 0) 
            return -1; 
        
        int start = 0, end = A.length - 1; 
        int mid; 
        while (start + 1 < end) {
            mid = start + (end - start) / 2; 
            if (A[mid] == target) {
                return mid;
            } else if (((A[mid] > A[end]) && ((A[mid] > target && A[start] > target) || A[mid] < target))
                        || (A[mid] <= A[end] && A[mid] < target && A[end] >= target)) {
                start = mid; 
            } else {
                end = mid; 
            } 
            
            System.out.println(start + ", " + end); 
        } 
        
        if (A[start] == target) 
            return start; 
        
        if (A[end] == target) 
            return end; 
            
        return  -1; 
    }
}
