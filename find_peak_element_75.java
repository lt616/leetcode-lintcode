/* 
75. Find Peak Element

There is an integer array which has the following features:

    The numbers in adjacent positions are different.
    A[0] < A[1] && A[A.length - 2] > A[A.length - 1].

We define a position P is a peak if:

A[P] > A[P-1] && A[P] > A[P+1]

Find a peak element in this array. Return the index of the peak.
Example

Given [1, 2, 1, 3, 4, 5, 7, 6]

Return index 1 (which is number 2) or 6 (which is number 7)
Challenge

Time complexity O(logN)
Notice

    It's guaranteed the array has at least one peak.
    The array may contain multiple peeks, find any of them.
    The array has at least 3 numbers in it.
*/ 

/* 
	EASY WRONG POINTS: 
		1. Be care of the return requirements. 
*/ 

public class Solution {
    /*
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here 
        
        if (A == null || A.length == 0) 
            return -1;      // should never happen 
        
        int start = 0, end = A.length - 1; 
        int mid; 
        while (start + 1 < end) {
            mid = start + (end - start) / 2; 
            if (A[mid - 1] < A[mid]) {
                start = mid; 
            } else if (A[mid - 1] > A[mid]) {
                end = mid; 
            } else {    // should never happen 
                return -1; 
            } 
        } 
        
        return (A[start] >= A[end]) ? start : end;  
    }
}
