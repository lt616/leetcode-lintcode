/* 
110. Minimum Path Sum

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
Notice

You can only move either down or right at any point in time.
*/ 

public class Solution {
    /**
     * @param grid: a list of lists of integers
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        // write your code here 
        
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0; 
        } 
        
        int[][] path_sum = new int[grid.length][grid[0].length]; 
        path_sum[0][0] = grid[0][0]; 
        int sum = path_sum[0][0]; 
        for (int i = 1;i < grid[0].length;i ++) {
            sum += grid[0][i]; 
            path_sum[0][i] = sum; 
        } 
        
        sum = path_sum[0][0]; 
        for (int i = 1;i < grid.length;i ++) {
            sum += grid[i][0]; 
            path_sum[i][0] = sum; 
        } 
        
        for (int i = 1;i < grid.length;i ++) {
            for (int j = 1;j < grid[0].length;j ++) {
                path_sum[i][j] = min(path_sum[i - 1][j], path_sum[i][j - 1]) + grid[i][j]; 
            } 
        } 
        
        return path_sum[grid.length - 1][grid[0].length - 1]; 
    } 
    
    private int min(int a, int b) {
        return (a < b) ? a : b; 
    }
} 
