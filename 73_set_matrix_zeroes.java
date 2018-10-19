/* 
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

Example 1:

Input: 
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output: 
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]

Example 2:

Input: 
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
Output: 
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]

Follow up:

    A straight forward solution using O(mn) space is probably a bad idea.
    A simple improvement uses O(m + n) space, but still not the best solution.
    Could you devise a constant space solution?
*/ 

class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return; 
        } 
        
        boolean zero_horizon = false, zero_vert = false; 
        for (int i = 0;i < matrix.length;i ++) {
            for (int j = 0;j < matrix[0].length;j ++) { 
                if (matrix[i][j] == 0) { 
                    if (i == 0) {
                        zero_horizon = true; 
                    } 
                    
                    if (j == 0) {
                        zero_vert = true; 
                    } 
                    
                    matrix[0][j] = 0; 
                    matrix[i][0] = 0; 
                } 
            } 
        } 
        
        for (int i = 1;i < matrix.length;i ++) { 
            if (matrix[i][0] == 0) {
                for (int j = 1;j < matrix[0].length;j ++) {
                    matrix[i][j] = 0; 
                }                 
            } 
        } 
        
        for (int i = 1;i < matrix[0].length;i ++) { 
            if (matrix[0][i] == 0) {
                for (int j = 1;j < matrix.length;j ++) {
                    matrix[j][i] = 0; 
                }
            } 
        } 
        
        if (zero_vert) {
            for (int i = 0;i < matrix.length;i ++) {
                matrix[i][0] = 0; 
            } 
        } 
        
        if (zero_horizon) { 
            for (int i = 0;i < matrix[0].length;i ++) {
                matrix[0][i] = 0; 
            }
        }
    }
} 
