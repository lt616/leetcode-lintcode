class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int[][] widths = new int[matrix.length][matrix[0].length];
        int sum;
        for (int i = 0; i < matrix.length; i++) {
            sum = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    widths[i][j] = ++ sum;
                } else {
                    sum = 0;
                    widths[i][j] = 0;
                }
            }
        }
                    
        int[][] dp = new int[matrix.length][matrix[0].length];
        int maxArea = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    int minWidth = widths[i][j];
                    for (int k = i; k >= 0; k--) {
                        minWidth = Math.min(minWidth, widths[k][j]);
                        if (minWidth == 0) {
                            break;
                        }
                        maxArea = Math.max(maxArea, minWidth * (i - k + 1));
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        
        return maxArea;
    }
}