class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int rows = matrix.length + 1;
        int columns = matrix[0].length + 1;
        
        int[][] dpArray = new int[rows][columns];
        
        for (int i = 0; i < columns; i++) {
            dpArray[0][i] = 0;
        }
        
        for (int i = 0; i < rows; i++) {
            dpArray[i][0] = 0;
        }
        
        int maxLen = 0;
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                if (matrix[i - 1][j - 1] != '1') {
                    dpArray[i][j] = 0;
                } else {
                    dpArray[i][j] = min(dpArray[i - 1][j - 1], dpArray[i - 1][j], dpArray[i][j - 1]) + 1;
                }
                maxLen = (dpArray[i][j] > maxLen) ? dpArray[i][j] : maxLen;
            }
        }
        
        return maxLen * maxLen;
    }
    
    private int min(int a, int b, int c) {
        int subMin = (a < b) ? a : b;
        return (subMin < c) ? subMin : c;
    }
}