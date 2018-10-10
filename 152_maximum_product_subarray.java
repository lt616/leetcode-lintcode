/* 
Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
*/ 

class Solution {
    public int maxProduct(int[] nums) {
        int[] dp_max = new int[nums.length + 1]; 
        int[] dp_min = new int[nums.length + 1]; 
        dp_max[0] = 1; 
        dp_min[0] = 1; 
        
        int max_product = Integer.MIN_VALUE; 
        for (int i = 1;i <= nums.length;i ++) {
            dp_max[i] = max(nums[i - 1], nums[i - 1] * dp_max[i - 1], nums[i - 1] * dp_min[i - 1]); 
            max_product = (dp_max[i] > max_product) ? dp_max[i] : max_product; 
            dp_min[i] = min(nums[i - 1], nums[i - 1] * dp_max[i - 1], nums[i - 1] * dp_min[i - 1]); 
        } 
        
        return max_product;  
    } 
    
    private int max(int a, int b, int c) {
        int temp = (a > b) ? a : b; 
        return (temp > c) ? temp : c; 
    } 
    
    private int min(int a, int b, int c) {
        int temp = (a < b) ? a : b; 
        return (temp < c) ? temp : c; 
    }
} 
