/* 
123. Word Search

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
Example

Given board =

[
  "ABCE",
  "SFCS",
  "ADEE"
]

word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false. 
*/ 

/* 
	EASY WRONG POINTS: 
		1. DFS instead of BFS. 
*/ 

class Pair {
    int x; 
    int y; 
    
    public Pair(int x, int y) {
        this.x = x; 
        this.y = y; 
    }
}

public class Solution {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */ 
    
    Pair[] direction; 
    
    public boolean exist(char[][] board, String word) {
        // write your code here 
        
        if (board == null || board.length == 0 || board[0].length == 0 || word.length() == 0) {
            return false; 
        } 
        
        direction = new Pair[4]; 
        direction[0] = new Pair(0, -1); 
        direction[1] = new Pair(0, 1); 
        direction[2] = new Pair(-1, 0);
        direction[3] = new Pair(1, 0); 
        
        Map<Character, List<Pair>> dict = new HashMap(); 
        boolean[][] is_visited = new boolean[board.length][board[0].length]; 
        
        for (int i = 0;i < board.length;i ++) {
            for (int j = 0;j < board[0].length;j ++) {
                if (! dict.containsKey(board[i][j])) {
                    dict.put(board[i][j], new ArrayList()); 
                } 
                dict.get(board[i][j]).add(new Pair(i, j)); 
            } 
        } 
        
        if (! dict.containsKey(word.charAt(0))) {
            return false; 
        }
        
        List<Pair> starts = dict.get(word.charAt(0)); 
        
        for (Pair start : starts) { 
            for (int m = 0;m < board.length;m ++) {
                for (int n = 0;n < board[0].length;n ++) {
                    is_visited[m][n] = false; 
                }
            }
            
            if (searchStringDFS(board, word, 0, is_visited, start)) {
                return true; 
            } 
        } 
        
        return false; 
    } 
    
    private boolean searchStringDFS(char[][] board, String word, int index, boolean[][] is_visited, Pair current) { 
        if (board[current.x][current.y] != word.charAt(index)) {
            return false; 
        } 
        
        if (index == word.length() - 1) { 
            return true; 
        }      

        for (int i = 0;i < direction.length;i ++) {
            int x = current.x + direction[i].x; 
            int y = current.y + direction[i].y; 
            
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || is_visited[x][y]) {
                continue; 
            } 
            
            is_visited[x][y] = true; 
            
            if (searchStringDFS(board, word, index + 1, is_visited, new Pair(x, y))) {
                return true; 
            } 
            
            is_visited[x][y] = false; 
        } 
        
        return false; 
    }
        
} 
