/* 
460. Find K Closest Elements

Given a target number, a non-negative integer k and an integer array A sorted in ascending order, find the k closest numbers to target in A, sorted in ascending order by the difference between the number and target. Otherwise, sorted in ascending order by number if the difference is same.
Example

Given A = [1, 2, 3], target = 2 and k = 3, return [2, 1, 3].

Given A = [1, 4, 6, 8], target = 3 and k = 3, return [4, 1, 6].
Challenge

O(logn + k) time complexity.
Notice

    The value k is a non-negative integer and will always be smaller than the length of the sorted array.
    Length of the given array is positive and will not exceed 10^4
    Absolute value of elements in the array and x will not exceed 10^4
*/ 

/* 
    EASY WRONG POINTS: 
        1. Optimization: when one side rearches the bound, no need to 
            continue the comparison. 
*/ 

public class Solution {
    /**
     * @param A: an integer array
     * @param target: An integer
     * @param k: An integer
     * @return: an integer array
     */
    public int[] kClosestNumbers(int[] A, int target, int k) {
        // write your code here 
        
        if (A == null || A.length == 0) 
            return new int[0]; 
            
        /* Find the closest position */ 
        int start = 0, end = A.length -1; 
        int mid; 
        while (start + 1 < end) {
            mid = start + (end - start) / 2; 
            
            if (A[mid] == target) { 
                start = mid - 1; 
                end = mid; 
                break; 
            } else if (A[mid] < target) {
                start = mid; 
            } else {
                end = mid; 
            } 
        } 
        
        /* Find K closest elements */ 
        int[] res = new int[k]; 
        int next_element = 0; 
        for (int i = 0;i < k;i ++) {  
            if (end > A.length - 1) {
                res[i] = A[start]; 
                start --; 
            } else if (start < 0 || target - A[start] > A[end] - target) { 
                res[i] = A[end]; 
                end ++; 
            } else { 
                res[i] = A[start]; 
                start --; 
            }
        } 
        
        return res; 
    } 
}  

/* Optimization */ 
public class Solution {
    /**
     * @param A: an integer array
     * @param target: An integer
     * @param k: An integer
     * @return: an integer array
     */
    public int[] kClosestNumbers(int[] A, int target, int k) {
        // write your code here 
        
        if (A == null || A.length == 0) 
            return new int[0]; 
            
        /* Find the closest position */ 
        int start = 0, end = A.length -1; 
        int mid; 
        while (start + 1 < end) {
            mid = start + (end - start) / 2; 
            
            if (A[mid] == target) { 
                start = mid - 1; 
                end = mid; 
                break; 
            } else if (A[mid] < target) {
                start = mid; 
            } else {
                end = mid; 
            } 
        } 
        
        /* Find K closest elements */ 
        int[] res = new int[k]; 
        int next_element = 0; 
        for (int i = 0;i < k;i ++) { 
            if (end > A.length - 1) { 
                while (start >= 0 && i < k)
                    res[i ++] = A[start --]; 
                return res; 
            } else if (start < 0) {
                while (end < A.length && i < k) 
                    res[i ++] = A[end ++]; 
                return res; 
            } else if (target - A[start] > A[end] - target) { 
                res[i] = A[end]; 
                end ++; 
            } else { 
                res[i] = A[start]; 
                start --; 
            } 
        } 
        
        return res; 
    } 
}
