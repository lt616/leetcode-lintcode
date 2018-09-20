/* 
91. Minimum Adjustment Cost

Given an integer array, adjust each integers so that the difference of every adjacent integers are not greater than a given number target.

If the array before adjustment is A, the array after adjustment is B, you should minimize the sum of |A[i]-B[i]|
Example

Given [1,4,2,3] and target = 1, one of the solutions is [2,3,2,3], the adjustment cost is 2 and it's minimal.

Return 2.
Notice

You can assume each number in the array is a positive integer and not greater than 100.
*/ 

public class Solution {
    /*
     * @param A: An integer array
     * @param target: An integer
     * @return: An integer
     */
    public int MinAdjustmentCost(List<Integer> A, int target) {
        // write your code here 
        
        if (A == null || A.size() == 0) {
            return 0; 
        } 
        
        int[][] dp_array = new int[A.size()][101]; 
        for (int i = 1;i < 101;i ++) {
            dp_array[0][i] = Math.abs(i - A.get(0)); 
        } 
        
        for (int i = 1;i < A.size();i ++) {
            for (int j = 1;j < 101;j ++) { 
                dp_array[i][j] = Integer.MAX_VALUE; 
                for (int j_p = 1;j_p < 101;j_p ++) { 
                    if (Math.abs(j_p - j) > target) {
                        continue; 
                    } 
                    dp_array[i][j] = Math.min(dp_array[i - 1][j_p] + Math.abs(A.get(i) - j), dp_array[i][j]); 
                } 
            } 
        } 
        
        return min_array(dp_array[A.size() - 1]); 
    } 
    
    private int min(int a, int b) {
        return (a < b) ? a : b; 
    }
    
    private int min_array(int[] nums) {
        int min = Integer.MAX_VALUE; 
        for (int i = 1;i < 101;i ++) { 
            System.out.println(nums[i]); 
            min = (nums[i] < min) ? nums[i] : min; 
        } 
        
        return min; 
    }
} 
