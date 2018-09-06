/* 
6. Merge Two Sorted Arrays

Merge two given sorted integer array A and B into a new sorted integer array.
Example

A=[1,2,3,4]

B=[2,4,5,6]

return [1,2,2,3,4,4,5,6]
Challenge

How can you optimize your algorithm if one array is very large and the other is very small?
*/ 

public class Solution {
    /**
     * @param A: sorted integer array A
     * @param B: sorted integer array B
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        // write your code here 
        
        if (A == null || A.length == 0) {
            return B; 
        } 
        
        if (B == null || B.length == 0) {
            return A; 
        } 
        
        int size_A = A.length, size_B = B.length; 
        int i = 0, j = 0; 
        
        int[] res = new int[size_A + size_B]; 
        int index = -1; 
        while (i < size_A && j < size_B) {
            if (A[i] <= B[j]) { 
                res[++ index] = A[i]; 
                i ++; 
            } else { 
                res[++ index] = B[j]; 
                j ++; 
            } 
        } 
        
        for (int m = i;m < size_A;m ++) {
            res[++ index] = A[m]; 
        } 
        
        for (int m = j;m < size_B;m ++) {
            res[++ index] = B[m];  
        } 
        
        return res; 
    }
} 
