/* 
405. Submatrix Sum

Given an integer matrix, find a submatrix where the sum of numbers is zero. Your code should return the coordinate of the left-up and right-down number.
Example

Given matrix

[
  [1 ,5 ,7],
  [3 ,7 ,-8],
  [4 ,-8 ,9],
]

return [(1,1), (2,2)]
Challenge

O(n3) time.
*/ 

/* 
    EASY WRONG POINTS: 
        1. When building prefix sum matrix, expand rows and colums by one 
        for bound cases. i.e. when #row || #colum == 1. 
*/ 

public class Solution {
    /*
     * @param matrix: an integer matrix
     * @return: the coordinate of the left-up and right-down number
     */
    public int[][] submatrixSum(int[][] matrix) {
        // write your code here 
        
        int[][] res = new int[2][2]; 
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res; 
        } 
        
        int num_row = matrix.length; 
        int num_column = matrix[0].length; 
        
        int[][] sum_matrix = new int[num_row + 1][num_column + 1]; 
        for (int i = 0;i <= num_row;i ++) {
            sum_matrix[i][0] = 0; 
        } 
        
        for (int j = 0;j <= num_column;j ++) {
            sum_matrix[0][j] = 0; 
        } 
        
        for (int i = 1;i <= num_row;i ++) { 
            for (int j = 1;j <= num_column;j ++) { 
                sum_matrix[i][j] = sum_matrix[i - 1][j] + sum_matrix[i][j - 1] - sum_matrix[i - 1][j - 1] + matrix[i - 1][j - 1]; 
            } 
        } 
        
        /* for (int i = 0;i <= num_row;i ++) {
            for (int j = 0;j <= num_column;j ++) {
                System.out.print(sum_matrix[i][j]); 
            } 
            System.out.println(""); 
        } */ 
        
        for (int i1 = 0;i1 < num_row; i1 ++) { 
            for (int i2 = i1 + 1;i2 <= num_row; i2 ++) { 
                Map<Integer, Integer> diff_map = new HashMap(); 
                
                for (int j1 = 0;j1 <= num_column; j1 ++) { 
                    int diff = sum_matrix[i2][j1] - sum_matrix[i1][j1]; 
                    
                    if (diff_map.containsKey(diff)) { 
                        int j2 = diff_map.get(diff); 
                        res[0][0] = i1; 
                        res[0][1] = j2; 
                        res[1][0] = i2 - 1; 
                        res[1][1] = j1 - 1; 
                        
                        return res; 
                    }
                    diff_map.put(diff, j1); 
                } 
            } 
        } 
        return res; 
    }
} 
