/* 
414. Divide Two Integers

Divide two integers without using multiplication, division and mod operator.

If it is overflow, return 2147483647
Example

Given dividend = 100 and divisor = 9, return 11.
*/ 

/* 
	EASY WRONG POINTS: 
		1. Be care of overflow 
		Use larger data structure, check MIN_VALUE & MAX_VALUE. 
		MAX_VALUE = - MIN_VALUE - 1. 

		2. Use Bit operators 
		<< | <<= increasing; >> | >>= decreasing. 
*/ 

public class Solution {
    /**
     * @param dividend: the dividend
     * @param divisor: the divisor
     * @return: the result
     */
    public int divide(int dividend, int divisor) {
        // write your code here 

        if (dividend == Integer.MIN_VALUE && divisor == -1)     // Only one case to overflow: 
            return Integer.MAX_VALUE; 

        boolean negative_flag = ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)); 
        
        long sum_divisor = Math.abs((long)divisor), sum_dividend = Math.abs((long)dividend); // When n = 0, abs(n) = 0 
        long sum = sum_divisor; 
        int count = 0; 
        while (sum_dividend >= sum_divisor) {
            int temp = 1; 
            while ((sum <<= 1) < sum_dividend)  
                temp <<= 1; 
            sum_dividend -= (sum >> 1); 
            sum = sum_divisor; 
            count += temp; 
        } 
        
        return (negative_flag) ? (0 - count) : count;  
    } 
}
