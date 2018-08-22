/* 
428. Pow(x, n)

Implement pow(x, n).
Example

Pow(2.1, 3) = 9.261
Pow(0, 1) = 0
Pow(1, 0) = 1

Challenge

O(logn) time
Notice

You don't need to care about the precision of your answer, it's acceptable if the expected answer and your answer 's difference is smaller than 1e-3.
*/ 

/* 
	EASY WRONG POINTS: 
		1. Avoid MIN_VALUE overflow: 
				n = -(n + 1). 
		2. Convert power from decimal to binary. 
*/ 

/* Solution 01: non-recursion */ 
import java.util.*; 

public class Solution {
    /*
     * @param x: the base number
     * @param n: the power number
     * @return: the result
     */
    public double myPow(double x, int n) {
        // write your code here 
        
        boolean inverse_flag = false;  
        if (n < 0) {
            x = 1 / x; 
            n = -(n + 1);       // Avoid MIN_VALUE overflow 
            inverse_flag = true;  
        } 

        double res = 1, base = x;      
        while (n != 0) { 
            if (n % 2 == 1) 
                res *= base; 
            base *= base; 
            n /= 2; 
        } 
        
        if (inverse_flag) 
            res *= x; 
        
        return res; 
    } 
    
} 

/* Solution 02: Recursion */ 
import java.util.*; 

public class Solution {
    /*
     * @param x: the base number
     * @param n: the power number
     * @return: the result
     */
    public double myPow(double x, int n) {
        // write your code here 
    
        if (n < 0) {
            x = 1 / x; 
            n = 0 - n; 
        }

        return powHelper(x, n); 
    } 
    
    private double powHelper(double x, int n) {
        if (n == 0) {
            return 1; 
        } 
        
        double res = powHelper(x, n / 2); 
        if (n % 2 == 0) 
            res = res * res; 
        else 
            res = res * res * x; 
        
        return res; 
    }
    
} 
