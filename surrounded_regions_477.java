/* 
477. Surrounded Regions

Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O''s into 'X''s in that surrounded region.
Example

X X X X
X O O X
X X O X
X O X X

After capture all regions surrounded by 'X', the board should be:

X X X X
X X X X
X X X X
X O X X
*/ 

/* 
	EASY WRONG POINTS: 
		1. Encounter stack overflow when trying DFS. 
*/ 

public class Solution {
    /*
     * @param board: board a 2D board containing 'X' and 'O'
     * @return: nothing
     */ 
    
    boolean[] is_surround; 
    int[] roots; 
    int[] direction_x; 
    int[] direction_y; 
    
    public void surroundedRegions(char[][] board) {
        // write your code here 
        
        if (board == null || board.length == 0 || board[0].length == 0) {
            return; 
        } 
        
        is_surround = new boolean[board.length * board[0].length]; 
        roots = new int[board.length * board[0].length]; 
        
        direction_x = new int[4]; 
        direction_y = new int[4]; 
        direction_x[0] = 0; 
        direction_x[1] = 0; 
        // direction_x[2] = -1; 
        // direction_x[3] = 1; 
        
        direction_y[0] = -1; 
        direction_y[1] = 1; 
        // direction_y[2] = 0; 
        // direction_y[3] = 0; 
        
        for (int i = 0;i < board.length;i ++) {
            for (int j = 0;j < board[0].length;j ++) { 
                if (board[i][j] == 'X') {
                    continue; 
                }
                
                int index = i * board[0].length + j; 
                roots[index] = index; 
                is_surround[index] = checkIfSurround(board, i, j); 
                int x = i - 1, y = j; 
                if (validate(board, x, y) && board[x][y] == 'O') { 
                    union(index, x * board[0].length + y); 
                } 
                
                x = i; 
                y = j - 1; 
                if (validate(board, x, y) && board[x][y] == 'O') { 
                    union(index, x * board[0].length + y); 
                } 
            } 
        } 
        
        for (int i = 0;i < board.length;i ++) {
            for (int j = 0;j < board[0].length;j ++) {
                int index = i * board[0].length + j; 
                
                if (board[i][j] == 'O' && ! is_surround[find(index)]) {
                    board[i][j] = 'X'; 
                }
            }
        }
        
        return; 
    } 
    
    private boolean checkIfSurround(char[][] board, int x, int y) {
        if (x == 0 || x == board.length - 1 || y == 0 || y == board[0].length - 1) {
            return true; 
        } 
        
        return false; 
    }
    
    private void union(int a, int b) {
        int root_a = find(a); 
        int root_b = find(b); 
        
        if (root_a == root_b) {
            return; 
        } 
        
        roots[root_a] = root_b; 
        is_surround[root_b] = (is_surround[root_a] || is_surround[root_b]); 
    } 
    
    private int find(int a) {
        if (roots[a] == a) {
            return a; 
        }
        return roots[a] = find(roots[a]); 
    }
    
    private boolean validate(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return false; 
        } 
        
        return true; 
    } 
} 
