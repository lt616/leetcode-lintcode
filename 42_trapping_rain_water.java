/* 
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
*/ 

/* Solution 01: 2-pointer */ 
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0; 
        } 
        
        int left = 0, right = height.length - 1; 
        List<Integer> sum = new ArrayList<Integer>(); 
        while (left != right) {
            left = trapWater(height, left, right, sum); 
            if (left == right) {
                break; 
            } 
            
            right = trapWaterReverse(height, left, right, sum); 
        } 
        
        int res = 0; 
        for (Integer num : sum) {
            res += num; 
        }
        
        return res; 
    } 
    
    private int trapWater(int[] height, int left, int right, List<Integer> sum) {
        int temp_sum = 0, total = 0; 
        int highest = height[left], start = left; 
        for (int i = left;i <= right;i ++) {
            if (height[i] >= highest) {
                total += temp_sum; 
                highest = height[i]; 
                start = i; 
                temp_sum = 0; 
            } else {
                temp_sum += highest - height[i]; 
            } 
        } 
        sum.add(total); 
        return start; 
    } 
    
    private int trapWaterReverse(int[] height, int left, int right, List<Integer> sum) {
        int temp_sum = 0, total = 0; 
        int highest = height[right], start = right; 
        for (int i = right;i >= left;i --) {
            if (height[i] >= highest) {
                total += temp_sum; 
                highest = height[i]; 
                start = i; 
                temp_sum = 0; 
            } else {
                temp_sum += highest - height[i]; 
            }
        } 
        sum.add(total); 
        return start; 
    }
} 
