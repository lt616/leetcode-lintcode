/* 
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321

Example 2:

Input: -123
Output: -321

Example 3:

Input: 120
Output: 21

Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
*/ 

class Solution {
    public int reverse(int x) { 
        if (x == -2147483648) {
            return 0; 
        }
        
        long res; 
        if (x < 0) {
            res = 0 - recursiveReverse(-x, 0); 
        } else {
            res = recursiveReverse(x, 0); 
        } 
        return (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) ? 0 : (int) res; 
    } 
    
    private long recursiveReverse(int x, long reverse_x) { 
        int digit = x % 10; 
        if (x / 10 < 1) { 
            
            long res = 10 * reverse_x + digit; 
            
            return res; 
        } 
        
        long res = 10 * reverse_x + digit; 
        return recursiveReverse(x / 10, res); 
    } 
} 
