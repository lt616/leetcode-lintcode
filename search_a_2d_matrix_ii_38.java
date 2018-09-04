/* 
38. Search a 2D Matrix II

Write an efficient algorithm that searches for a value in an m x n matrix, return the occurrence of it.

This matrix has the following properties:

    Integers in each row are sorted from left to right.
    Integers in each column are sorted from up to bottom.
    No duplicate integers in each row or column.

Example

Consider the following matrix:

[
  [1, 3, 5, 7],
  [2, 4, 7, 8],
  [3, 5, 9, 10]
]

Given target = 3, return 2.
Challenge

O(m+n) time and O(1) extra space
*/ 

/* Solution 01: very bad binary search */ 
public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param target: An integer you want to search in matrix
     * @return: An integer indicate the total occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here 
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0; 
        } 
        
        printMatrix(matrix); 
        
        /* Binary search in diagonal line */ 
        int min_size = (matrix.length < matrix[0].length) ? matrix.length : matrix[0].length; 
        for (int i = 0;i < min_size;i ++) {
            
        } 
        int start = 0, end = min_size - 1; 
        int mid; 
        int i1, i2, j1, j2; 
        while (start + 1 < end) {
            mid = start + (end - start) / 2; 
            if (matrix[mid][mid] == target) {
                return checkPossibleChars(matrix, target, mid, mid, true); 
            } else if (matrix[mid][mid] < target) {
                start = mid; 
            } else {
                end = mid; 
            } 
        } 
        
        if (matrix[start][start] == target) {
            return checkPossibleChars(matrix, target, start, start, true); 
        } else if (matrix[start][start] > target) {
            return checkPossibleChars(matrix, target, start, -1, false); 
        }
        
        if (matrix[end][end] == target) {
            return checkPossibleChars(matrix, target, end, end, true); 
        } else if (matrix[end][end] < target) {
            return checkPossibleChars(matrix, target, end, -1, true); 
        }
        
        return checkPossibleChars(matrix, target, start, end, true); 
    } 
    
    private int checkPossibleChars(int[][] matrix, int target, int start, int end, boolean is_large) { 
        int occur = 0; 
        
        if (end == -1) {
            if (is_large) {
                for (int i = 0;i < matrix.length;i ++) {
                    for (int j = 0;j < matrix[0].length;j ++) { 
                        if (i < start && j < start) {
                            continue; 
                        } 
                        
                        if (matrix[i][j] == target) {
                            occur ++; 
                        } 
                    } 
                } 
            } else {
                for (int i = 0;i <= start;i ++) {
                    for (int j = 0;j <= start;j ++) {
                        if (matrix[i][j] == target) {
                            occur ++; 
                        } 
                    } 
                } 
            } 
            
            return occur; 
        }
        
        
        int a_i, a_j, b_i, b_j; 
        
        if (start == end) {
            a_i = start + 1; 
            a_j = start - 1; 
            b_i = start + 1; 
            b_j = start - 1; 
            
            if (matrix[start][start] == target) {
                occur ++; 
            } 
        } else {
            a_i = end; 
            a_j = start; 
            b_i = end; 
            b_j = start; 
        } 
        
        if ((a_i < matrix[0].length) && (a_j < matrix.length)) { 
            for (int i = 0;i <= a_j;i ++) {
                for (int j = a_i;j < matrix[0].length;j ++) {
                    if (matrix[i][j] == target) {
                        occur ++; 
                    } 
                } 
            } 
        } 
        
        if ((b_i < matrix.length) && (b_j < matrix[0].length)) { 
            for (int i = b_i;i < matrix.length;i ++) {
                for (int j = 0;j <= b_j;j ++) {
                    if (matrix[i][j] == target) {
                        occur ++; 
                    } 
                } 
            } 
        } 
        
        return occur; 
    } 
    
    private void printMatrix(int[][] matrix) {
        for (int i = 0;i < matrix.length;i ++) {
            for (int j = 0;j < matrix[0].length;j ++) {
                System.out.print(matrix[i][j] + " "); 
            } 
            System.out.println(""); 
        }
    }
} 


/* Solution 02: better sol */ 
public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param target: An integer you want to search in matrix
     * @return: An integer indicate the total occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here 
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0; 
        } 
        
        int num_row = matrix.length; 
        int num_column = matrix[0].length; 
        int x = num_row - 1; 
        int y = 0; 
        
        int occur = 0; 
        while (x >= 0 && y < num_column) { 
            int current = matrix[x][y]; 
            if (current == target) { 
                occur ++; 
                
                x --; 
                y ++; 
            } else if (current < target) {
                y ++; 
            } else {
                x --; 
            } 
        } 
        
        return occur; 
    } 
} 
