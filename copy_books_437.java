/* 
437. Copy Books

Given n books and the ith book has A[i] pages. You are given k people to copy the n books.

n books list in a row and each person can claim a continous range of the n books. For example one copier can copy the books from ith to jth continously, but he can not copy the 1st book, 2nd book and 4th book (without 3rd book).

They start copying books at the same time and they all cost 1 minute to copy 1 page of a book. What's the best strategy to assign books so that the slowest copier can finish at earliest time?
Example

Given array A = [3,2,4], k = 2.

Return 5( First person spends 5 minutes to copy book 1 and book 2 and second person spends 4 minutes to copy book 3. )
*/ 

/* 
	EASY WRONG POINTS: 
		1. Binary search enumeration: O(nlog n). 
		Enumeration each possible answer between min(pages) && sum(pages). 
		2. DP. 
*/ 



public class Solution {
    /**
     * @param pages: an array of integers
     * @param k: An integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        // write your code here 
        
        /* Binary search enumeration */ 
        if (pages == null || pages.length == 0) 
            return 0; 
        
        /* Calculate sum & max*/ 
        int sum = 0, max = Integer.MIN_VALUE;  
        for (int i = 0;i < pages.length;i ++) { 
            sum += pages[i]; 
            max = (pages[i] > max) ? pages[i] : max;    
        }
        
        /* Binary search enumeration */ 
        int start = max, end = sum; 
        int mid; 
        int min = Integer.MAX_VALUE; 
        while (start + 1 < end) { 
            mid = start + (end - start) / 2; 
            if (checkCopiesIfEnough(pages, mid, k)) {
                min = (mid < min) ? mid : min; 
                end = mid; 
            } else { 
                start = mid; 
            }
        } 
        
        if (checkCopiesIfEnough(pages, start, k)) { 
            min = (start < min) ? start : min; 
        } 
        
        if (checkCopiesIfEnough(pages, end, k)) {
           min = (end < min) ? end : min; 
        }
        
        return min; 
    } 
    
    private boolean checkCopiesIfEnough(int[] pages, int min, int k) {
        int i = 0, count = 1, sum = 0;  
        while (count <= k && i < pages.length) { 
            sum += pages[i]; 
            if (sum > min) { 
                count ++; 
                sum = pages[i];  
            } 
            i ++; 
        } 
        
        return count <= k; 
    }
} 

