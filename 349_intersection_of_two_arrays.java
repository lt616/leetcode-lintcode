class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
    
        int ans = -1;
        int sign = 1;
        if (dividend > 0) {
            sign = opposite(sign);
            dividend = opposite(dividend);
        }
        if (divisor > 0) {
            sign = opposite(sign);
            divisor = opposite(divisor);
        }   

        int origin_dividend = dividend;
        int origin_divisor = divisor;
        if (dividend > divisor) {
            return 0;
        } 

        dividend -= divisor;
        while (divisor >= dividend) {
            ans = ans + ans;
            divisor += divisor;
            dividend -= divisor;
        }
        //此时我们传进的是两个负数，正常情况下，它就返回正数，但我们是在用负数累加，所以要取相反数
        int a = ans + opposite(divide(origin_dividend - divisor, origin_divisor));
        if(sign > 0){
            return opposite(a);
        }else{
            return a;
        }
    }
    public int opposite(int x) {
        return ~x + 1;
    }
}
