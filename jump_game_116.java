/* 
116. Jump Game

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.
Example

A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
Notice

This problem have two method which is Greedy and Dynamic Programming.

The time complexity of Greedy method is O(n).

The time complexity of Dynamic Programming method is O(n^2).

We manually set the small data set to allow you pass the test in both ways. This is just to let you learn how to use this problem in dynamic programming ways. If you finish it in dynamic programming ways, you can try greedy method to make it accept again.
*/ 


/* Solution 01: Greedy */ 
public class Solution {
    /**
     * @param A: A list of integers
     * @return: A boolean
     */ 
    
    boolean[] visited; 
    boolean[] is_reached; 
    boolean res; 
    
    public boolean canJump(int[] A) {
        // write your code here 
        
        if (A == null || A.length == 0) {
            return true; 
        } 
        
        int fastest = A[0]; 
        for (int i = 1;i < A.length;i ++) {
            if (i <= fastest && i + A[i] > fastest) {
                fastest = i + A[i]; 
            } 
        } 
        
        return (fastest >= A.length - 1); 
    } 
} 


/* Solution 02: DP */ 
public class Solution {
    /**
     * @param A: A list of integers
     * @return: A boolean
     */ 
    
    boolean[] visited; 
    boolean[] is_reached; 
    boolean res; 
    
    public boolean canJump(int[] A) {
        // write your code here 
        
        if (A == null || A.length == 0) {
            return true; 
        } 
        
        visited = new boolean[A.length]; 
        is_reached = new boolean[A.length]; 
        
        return dpDFS(A, 0); 
    } 
    
    private boolean dpDFS(int[] nums, int index) {
        if (index >= nums.length - 1) {
            return true; 
        } 
        
        if (visited[index]) {
            return is_reached[index]; 
        }
        
        int step_len = nums[index]; 
        for (int i = 1;i <= step_len;i ++) {
            if(dpDFS(nums, index + i)) { 
                visited[index] = true; 
                is_reached[index] = true; 
                return true; 
            } 
        } 
        
        visited[index] = true; 
        is_reached[index] = false; 
        return false; 
    }
} 
