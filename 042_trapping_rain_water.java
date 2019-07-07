class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        
        int left = 0;
        int right = height.length - 1;
        
        int leftMax = 0;
        int rightMax = 0;
        
        int total = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = (height[left] > leftMax) ? height[left] : leftMax;
                total += leftMax - height[left];
                left ++;
            } else {
                rightMax = (height[right] > rightMax) ? height[right] : rightMax;
                total += rightMax - height[right];
                right --;
            }
        }
        
        return total;
    }
}