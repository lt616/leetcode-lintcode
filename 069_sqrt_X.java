class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        
        long start = 0;
        long end = x / 2;
        long xLong = x;
        while (start + 1 < end) {
            long mid = (start + end) / 2;
            long multiplication = mid * mid;
            if (multiplication == xLong) {
                return (int) mid;
            } else if (multiplication < xLong) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (end * end <= xLong)
            return (int) end;
        
        return (int) start;
    }
}
