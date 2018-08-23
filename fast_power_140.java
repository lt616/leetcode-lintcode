/* 
140. Fast Power

Calculate the an % b where a, b and n are all 32bit integers.
Example

For 231 % 3 = 2

For 1001000 % 1000 = 0
Challenge

O(logn) 
*/ 

/* 
	EASY WRONG POINTS: 
		1. Modulo operations. 
		2. Avoid overflow when (mod % c) * (mod % c). 
*/ 

/* Solution 01: recursion */ 
public class Solution {
    /**
     * @param a: A 32bit integer
     * @param b: A 32bit integer 
     * @param n: A 32bit integer
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {
        // write your code here 
        
        return (int) fastPowerRecursion(a, b, n); 
    } 
    
    private long fastPowerRecursion(int a, int b, int n) {
        if (n == 0) 
            return 1 % b;  
        
        long old_mod = fastPowerRecursion(a, b, n / 2); 
        long mod = (old_mod * old_mod) % b; 
        if (n % 2 == 1) 
            return (mod * (a % b)) % b; 
        else 
            return mod; 
    }
} 

/* Solution 01: non-recursion */ 
public class Solution {
    /**
     * @param a: A 32bit integer
     * @param b: A 32bit integer 
     * @param n: A 32bit integer
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {
        // write your code here 
        
        if (n == 0) {
            return 1 % b; 
        } 
        
        if (n == 1) {
            return a % b; 
        } 
        
        long mod = 1, base = a;   
        while (n > 0) { 

            if (n % 2 == 1) {
                mod = (mod * base) % b;
            } 
            n /= 2; 
            base = (base * base) % b; 
        } 
        
        return (int) mod; 
    } 
} 
