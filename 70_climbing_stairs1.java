class Solution {
    public int climbStairs(int n) {
        if (n == 0) {
            return n;
        }
        
        int[] dpArray = new int[n + 1];
        dpArray[0] = 1;
        dpArray[1] = 1;
        for (int i = 1; i < n; i++) {
            dpArray[i + 1] = dpArray[i - 1] + dpArray[i];
        }
        
        return dpArray[n];
    }
}