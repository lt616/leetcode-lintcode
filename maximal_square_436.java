/* 
436. Maximal Square

Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.
Example

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Return 4.
*/ 

public class Solution {
    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    public int maxSquare(int[][] matrix) {
        // write your code here 
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0; 
        } 
        
        int max_area = 0; 
        
        int[][] max_a = new int[matrix.length][matrix[0].length]; 
        for (int i = 0;i < matrix.length;i ++) {
            for (int j = 0;j < matrix[0].length;j ++) { 
                if (matrix[i][j] == 0) {
                    continue; 
                }
                
                if (i - 1 < 0 || j - 1 < 0) { 
                    max_a[i][j] = 1; 
                    max_area = max(max_area, 1); 

                    continue;
                }
                
                max_a[i][j] = min(max_a[i - 1][j - 1] + 1, max_a[i - 1][j] + 1, max_a[i][j - 1] + 1); 
                max_area = max(max_area, max_a[i][j]); 
            } 
        } 
        
        return max_area * max_area; 
    } 
    
    private int min(int a, int b, int c) {
        int res = (a < b) ? a : b; 
        return (res < c) ? res : c; 
    } 
    
    private int max(int a, int b) {
        return (a > b) ? a : b; 
    }
} 
