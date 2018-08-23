/* 
183. Wood Cut

Given n pieces of wood with length L[i] (integer array). Cut them into small pieces to guarantee you could have equal or more than k pieces with the same length. What is the longest length you can get from the n pieces of wood? Given L & k, return the maximum length of the small pieces.
Example

For L=[232, 124, 456], k=7, return 114.
Challenge

O(n log Len), where Len is the longest length of the wood.
Notice

You couldn't cut wood into float length.

If you couldn't get >= k pieces, return 0.
*/ 

/* 
	EASY WRONG POINTS: 
		1. Search range: 
			0 < l < max_wood_len 
		The upper bound is max_len instead of min_len, because in some cases short 
		woods can be abandoned. 
*/ 

public class Solution {
    /**
     * @param L: Given n pieces of wood with length L[i]
     * @param k: An integer
     * @return: The maximum length of the small pieces
     */
    public int woodCut(int[] L, int k) {
        // write your code here 
        
        if (L == null || L.length == 0) {
            return 0; 
        } 
        
        int min = Integer.MIN_VALUE;  
        for (int i = 0;i < L.length;i ++) {
            min = (L[i] > min) ? L[i] : min; 
        } 
        
        int start = 1, end = min; 
        int mid, count; 
        while (start + 1 < end) {
            mid = start + (end - start) / 2; 
            count = calculateNumOfPieces(L, mid); 
            if (count < k) {
                end = mid; 
            } else {
                start = mid; 
            } 
        } 
        
        if (calculateNumOfPieces(L, end) >= k) {
            return end;            
        }
        
        if (calculateNumOfPieces(L, start) >= k) {
            return start; 
        }
        
        return 0; 
    } 
    
    private int calculateNumOfPieces(int[] L, int unit_len) {
        int count = 0; 
        for (int i = 0;i < L.length;i ++) {
            count += (L[i] / unit_len); 
        } 
        
        return count; 
    }
}
