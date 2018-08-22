/* 
28. Search a 2D Matrix

Write an efficient algorithm that searches for a value in an m x n matrix.

This matrix has the following properties:

    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.

Example

Consider the following matrix:

[
    [1, 3, 5, 7],
    [10, 11, 16, 20],
    [23, 30, 34, 50]
]

Given target = 3, return true.
Challenge

O(log(n) + log(m)) time
*/ 

/* BUG FREE !! */ 

public class Solution {
    /**
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here 
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) 
            return false; 
        
        int rows =  matrix.length; 
        int columns = matrix[0].length; 
        
        /* Whole view search */ 
        if (matrix[0][0] > target || matrix[rows - 1][columns - 1] < target) 
            return false; 
            
        
        /* Row: binary search */ 
        int start_row = 0, end_row = rows - 1; 
        int mid_row; 
        while (start_row + 1 < end_row) {
            mid_row = start_row + (end_row - start_row) / 2; 
            if (matrix[mid_row][0] == target) 
                return true;  
            else if (matrix[mid_row][0] < target) 
                start_row = mid_row; 
            else 
                end_row = mid_row; 
        } 
        
        if (matrix[start_row][0] == target || matrix[end_row][0] == target) 
            return true; 
        
        mid_row = (target > matrix[end_row][0]) ? end_row : start_row; 
        
        /* Column: binary search */ 
        int start_column = 0, end_column = columns - 1; 
        int mid_column; 
        while (start_column + 1 < end_column) {
            mid_column = start_column + (end_column - start_column) / 2; 
            if (matrix[mid_row][mid_column] == target) 
                return true; 
            else if (matrix[mid_row][mid_column] < target) 
                start_column = mid_column; 
            else 
                end_column = mid_column; 
        } 
        
        if (matrix[mid_row][start_column] == target || matrix[mid_row][end_column] == target) 
            return true; 
            
        return false; 
        
        

        
    }
}
