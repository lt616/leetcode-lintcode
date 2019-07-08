/* Solution 01: BFS */
class Pair {
    int x;
    int y;
    
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int numRow = grid.length;
        int numColumn = grid[0].length;
        
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0;j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count ++;
                    
                    // Remove this island from map
                    Queue<Pair> queue = new LinkedList<>();
                    grid[i][j] = '0';
                    queue.add(new Pair(i, j));
                    while (!queue.isEmpty()) {
                        Pair currentPos = queue.poll();
                        int x = currentPos.x;
                        int y = currentPos.y;
                        
                        if (isValidPos(numRow, numColumn, x + 1, y) && grid[x + 1][y] == '1') {
                            grid[x + 1][y] = '0';
                            queue.add(new Pair(x + 1, y));
                        }
                        
                        if (isValidPos(numRow, numColumn, x - 1, y) && grid[x - 1][y] == '1') {
                            grid[x - 1][y] = '0';
                            queue.add(new Pair(x - 1, y));
                        }
                        
                        if (isValidPos(numRow, numColumn, x, y + 1) && grid[x][y + 1] == '1') {
                            grid[x][y + 1] = '0';
                            queue.add(new Pair(x, y + 1));
                        }
                        
                        if (isValidPos(numRow, numColumn, x, y - 1) && grid[x][y - 1] == '1') {
                            grid[x][y - 1] = '0';
                            queue.add(new Pair(x, y - 1));
                        }
                    }
                    
                }
            }
        }
        
        return count;
    }
    
    private boolean isValidPos(int numRow, int numColumn, int x, int y) {
        return x >= 0 && x < numRow && y >= 0 && y < numColumn;
    }
}

/* Solution 02: Union-find */
class Pair {
    int x;
    int y;
    
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    int[] roots;
    int numRow;
    int numColumn;
    int count;
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        numRow = grid.length;
        numColumn = grid[0].length;
        
        roots = new int[numRow * numColumn];
        for (int i = 0;i < roots.length;i ++) {
            roots[i] = i;
        }
        
        for (int i = 0;i < grid.length;i ++) {
            for (int j = 0;j < grid[0].length;j ++) {
                if (grid[i][j] == '0') 
                    continue;
                
                count ++;
                if (isValidPos(i - 1, j) && grid[i - 1][j] == '1')
                    union(pairToSingle(i - 1, j), pairToSingle(i, j));
                
                if (isValidPos(i, j - 1) && grid[i][j - 1] == '1')
                    union(pairToSingle(i, j - 1), pairToSingle(i, j));
            }
        }
        
        return count;
    }
    
    private void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        
        if (rootA != rootB) {
            roots[rootA] = rootB;
            count --;
        }
    }
    
    private int find(int a) {
        if (a == roots[a]) {
            return a;
        }
        return roots[a] = find(roots[a]);
    }
    
    private boolean isValidPos(int x, int y) {
        return x >= 0 && x < numRow && y >= 0 && y < numColumn;
    }

    private int pairToSingle(int x, int y) {
        return x * numColumn + y;
    }
}