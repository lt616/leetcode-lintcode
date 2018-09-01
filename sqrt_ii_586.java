/* 
586. Sqrt(x) II

Implement double sqrt(double x) and x >= 0.

Compute and return the square root of x.
Example

Given n = 2 return 1.41421356
Notice

You do not care about the accuracy of the result, we will help you to output results.
*/ 

/* 
	EASY WRONG POINTS: 
		1. Be careful: end = 1 if x < 1! 
*/ 

public class Solution {
    /**
     * @param x: a double
     * @return: the square root of x
     */
    public double sqrt(double x) {
        // write your code here 
        
        double start = 0, end = (x < 1) ? 1 : x; 
        double mid; 
        double precision = 1e-14; 
        while (true) {
            mid = (start + end) / 2; 
            double n = mid * mid; 
            
            if (Math.abs(n - x) < precision) { 
                return mid; 
            } else if (n > x) {
                end = mid; 
            } else { 
                start = mid; 
            } 
        } 
    }
} 
