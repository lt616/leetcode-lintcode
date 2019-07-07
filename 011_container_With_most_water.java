class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0 || height.length == 1)
            return 0;
        
        int start = 0;
        int end = height.length - 1;
        int maxArea = (height.length - 1) * Math.min(height[start], height[end]);
        
        while (start < end) {
            if (height[start] <= height[end]) {
                start ++;
            } else {
                end --;
            }
            if (start >= end) break;
            int area = Math.min(height[start], height[end]) * (end - start);
            maxArea = (area > maxArea) ? area : maxArea;
        }
        
        return maxArea;
    }
}