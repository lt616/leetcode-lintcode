class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int numRow = matrix.length;
        int numColumn = matrix[0].length;
        
        int row = numRow - 1;
        int column = 0;
        
        while (row >= 0 && row < numRow && column >= 0 && column < numColumn) {
            if (matrix[row][column] == target) {
                return true;
            } else if (matrix[row][column] < target) {
                column ++;
            } else {
                row --;
            }
        }
        
        return false;
    }
}