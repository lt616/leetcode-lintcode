/* 
64. Merge Sorted Array

Given two sorted integer arrays A and B, merge B into A as one sorted array.
Example

A = [1, 2, 3, empty, empty], B = [4, 5]

After merge, A will be filled as [1, 2, 3, 4, 5]
Notice

You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.
*/ 

/* 
	EASY WRONG POINTS: 
		1. Looping through arrays A and B from m - 1 and n - 1, instead of m and n. 
		*/  

public class Solution {
    /*
     * @param A: sorted integer array A which has m elements, but size of A is m+n
     * @param m: An integer
     * @param B: sorted integer array B which has n elements
     * @param n: An integer
     * @return: nothing
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here 
        
        
        int index = m + n; 
        m --; 
        n --; 
        
        while (m >= 0 && n >= 0) { 
            if (A[m] >= B[n]) {
                A[-- index] = A[m --]; 
            } else {
                A[-- index] = B[n --]; 
            } 
        } 
        
        for (int i = m;i >= 0;i --) {
            A[-- index] = A[i]; 
        } 
        
        for (int i = n;i >= 0;i --) {
            A[-- index] = B[i]; 
        }  
    }
}

