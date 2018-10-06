/* 
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

 

The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

 

Example:

Input: [1,8,6,2,5,4,8,3,7]
Output: 49
*/ 

/* Solution 01: Brute force */ 
class Solution {
    public int maxArea(int[] height) {
        if (height == null) {
            return 0; 
        } 
        
        int max_area = Integer.MIN_VALUE; 
        for (int i = 0;i < height.length;i ++) {
            for (int j = i + 1;j < height.length;j ++) {
                int a = Math.min(height[i], height[j]); 
                max_area = Math.max(a * (j - i), max_area); 
            } 
        } 
        
        return max_area; 
    }
} 


/* Solution 02: 2-pointer */ 
class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0; 
        } 
        
        int left = 0, right = height.length - 1; 
        int max_area = Integer.MIN_VALUE; 
        while (left < right) {
            max_area = Math.max(max_area, Math.min(height[left], height[right]) * (right - left)); 
            if (height[left] < height[right]) {
                left ++; 
            } else {
                right --; 
            }
        }
        
        return max_area; 
    }
} 
