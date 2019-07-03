/* Solution 01: Recursion O(log n) */
class Solution {
    
    public double myPow(double x, int n) {
        long num = n;
        if (n < 0) 
            return 1 / myPower(x, -num);
        else
            return myPower(x, num);
    }
    
    private double myPower(double x, long n) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        
        double half = myPower(x, n / 2);
        if (n % 2 == 1) 
            return half * half * x;
        else
            return half * half;
    }
}

/* Solution 02: Iteration O(log n) */
class Solution {
    public double myPow(double x, int n) {
        long num = n;
        if (n < 0) {
            x = 1 / x;
            num = -num;
        }
        
        double powered = 1;
        double power = x;
        for (long i = num; i > 0; i /= 2) {
            if (i % 2 == 1)
                powered *= power;
            power *= power;
        }
        
        return powered;
    }
}
