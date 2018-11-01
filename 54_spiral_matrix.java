/* 
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
*/ 

class Solution { 
    List<Integer> res; 
    public List<Integer> spiralOrder(int[][] matrix) {
        res = new ArrayList<Integer>(); 
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res; 
        } 
        
        int row_left = 0, row_right = matrix.length - 1, col_left = 0, col_right = matrix[0].length - 1; 
        while (row_left <= row_right && col_left <= col_right) {
            for (int i = col_left;i <= col_right;i ++) {
                res.add(matrix[row_left][i]); 
            } 
             
            for (int i = row_left + 1;i <= row_right;i ++) {
                res.add(matrix[i][col_right]); 
            } 

            if (row_left != row_right) {
                for (int i = col_right - 1;i > col_left;i --) {
                    res.add(matrix[row_right][i]); 
                }                 
            }

            if (col_left != col_right) {
                for (int i = row_right;i > row_left;i --) {
                    res.add(matrix[i][col_left]); 
                }                 
            }
            
            row_left ++; 
            col_right --; 
            col_left ++; 
            row_right --; 
        } 
            
        return res; 
    } 
} 
