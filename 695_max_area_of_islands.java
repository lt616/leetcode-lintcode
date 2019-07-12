class Solution {
    int[] roots;
    int[] areas;
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int numRow = grid.length;
        int numColumn = grid[0].length;
        
        roots = new int[numRow * numColumn];
        for (int i = 0; i < numRow * numColumn; i++) {
            roots[i] = i;
        }
        
        areas = new int[numRow * numColumn];
        for (int i = 0; i < numRow * numColumn; i ++) {
            areas[i] = 1;
        }
        
        int maxArea = 0;
        for (int i = 0; i < numRow; i++) {
            for (int j = 0; j < numColumn; j++) {
                if (grid[i][j] == 1) {
                    maxArea = (1 > maxArea) ? 1 : maxArea;
                    if (isValidPos(i - 1, j, numRow, numColumn) && grid[i - 1][j] == 1) {
                        int area = union(twoToOne(i - 1, j, numColumn), twoToOne(i, j, numColumn));
                        maxArea = (area > maxArea) ? area : maxArea;
                    }
                    
                    if (isValidPos(i, j - 1, numRow, numColumn) && grid[i][j - 1] == 1) {
                        int area = union(twoToOne(i, j - 1, numColumn), twoToOne(i, j, numColumn));
                        maxArea = (area > maxArea) ? area : maxArea;
                    }
                }
            }
        }
        
        return maxArea;
    }
    
    private int union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            roots[rootA] = rootB;
            areas[rootB] += areas[rootA];
        }
        
        return areas[rootB];
    }

    private int find(int a) {
        if (roots[a] == a)
            return a;
        
        return roots[a] = find(roots[a]);
    }
    
    private int twoToOne(int x, int y, int numColumn) {
        return x * numColumn + y;
    }
    
    private boolean isValidPos(int x, int y, int numRow, int numColumn) {
        return x >= 0 && x < numRow && y >= 0 && y < numColumn;
    }
}