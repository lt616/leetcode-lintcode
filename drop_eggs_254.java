/* 
254. Drop Eggs

There is a building of n floors. If an egg drops from the k th floor or above, it will break. If it's dropped from any floor below, it will not break.

You're given two eggs, Find k while minimize the number of drops for the worst case. Return the number of drops in the worst case.
Example

Given n = 10, return 4.
Given n = 100, return 14.
Clarification

For n = 10, a naive way to find k is drop egg from 1st floor, 2nd floor ... kth floor. But in this worst case (k = 10), you have to drop 10 times.

Notice that you have two eggs, so you can drop at 4th, 7th & 9th floor, in the worst case (for example, k = 9) you have to drop 4 times.
*/ 

/* 
	EASY WRONG POINTS: 
		1. Be care of overflow! 
*/ 

/* Solution 01: binary search */ 
public class Solution {
    /**
     * @param n: An integer
     * @return: The sum of a and b
     */
    public int dropEggs(int n) {
        // write your code here 
        
        if (n == 0) {
            return 0; 
        } 
        
        long start = 0, end = n; 
        long mid; 
        while (start + 1 < end) {
            mid = (start + end) / 2;             
            long test_floors = (mid + 1) * mid / 2; 
            if (test_floors == n) { 
                return (int) mid; 
            } else if (test_floors > n) { 
                end = mid; 
            } else { 
                start = mid; 
            } 
        } 
        
        System.out.println(start + ", " + end); 
        
        if ((start + 1) * start / 2 >= n) {
            return (int) start; 
        }
        
        if ((end + 1) * end / 2 >= n) {
            return (int) end; 
        } 
        
        return -1; 
    }
} 


/* Solution 02: DP */ 
