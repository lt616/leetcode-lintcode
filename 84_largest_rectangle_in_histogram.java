class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int prev = -1;
        stack.push(prev);
        
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[i] <= heights[stack.peek()]) 
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
            stack.push(i);
        }
        
        while (stack.peek() != -1) {
            // System.out.println("height " + heights.length + " stack " + stack.peek());
            maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
            // System.out.println(maxArea);
        }
        
        return maxArea;
    }
}