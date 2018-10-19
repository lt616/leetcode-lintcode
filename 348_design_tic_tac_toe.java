/* 
Design a Tic-tac-toe game that is played between two players on a n x n grid.

You may assume the following rules:

    A move is guaranteed to be valid and is placed on an empty block.
    Once a winning condition is reached, no more moves is allowed.
    A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.

Example:

Given n = 3, assume that player 1 is "X" and player 2 is "O" in the board.

TicTacToe toe = new TicTacToe(3);

toe.move(0, 0, 1); -> Returns 0 (no one wins)
|X| | |
| | | |    // Player 1 makes a move at (0, 0).
| | | |

toe.move(0, 2, 2); -> Returns 0 (no one wins)
|X| |O|
| | | |    // Player 2 makes a move at (0, 2).
| | | |

toe.move(2, 2, 1); -> Returns 0 (no one wins)
|X| |O|
| | | |    // Player 1 makes a move at (2, 2).
| | |X|

toe.move(1, 1, 2); -> Returns 0 (no one wins)
|X| |O|
| |O| |    // Player 2 makes a move at (1, 1).
| | |X|

toe.move(2, 0, 1); -> Returns 0 (no one wins)
|X| |O|
| |O| |    // Player 1 makes a move at (2, 0).
|X| |X|

toe.move(1, 0, 2); -> Returns 0 (no one wins)
|X| |O|
|O|O| |    // Player 2 makes a move at (1, 0).
|X| |X|

toe.move(2, 1, 1); -> Returns 1 (player 1 wins)
|X| |O|
|O|O| |    // Player 1 makes a move at (2, 1).
|X|X|X|

Follow up:
Could you do better than O(n2) per move() operation? 
*/ 

/* Easy Wrong Points: 
	1. Can be improved further: Diagonal saved in two ints. 
*/ 

class TicTacToe { 
    
    int[] rows; 
    int[] columns; 
    int[] row_player; 
    int[] column_player; 
    int[][] map; 
    
    int size; 
    
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n]; 
        columns = new int[n]; 
        row_player = new int[n]; 
        column_player = new int[n]; 
        map = new int[n][n]; 
        
        size = n; 
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        map[row][col] = player; 
        
        int res; 
        if ((res = checkRowColumn(rows, row_player, row, player)) != 0) {
            return res; 
        } 

        if ((res = checkRowColumn(columns, column_player, col, player)) != 0) {
            return res; 
        } 
        
        return checkDiagon(map, row, col, player); 
    } 
    
    
    private int checkRowColumn(int[] nums, int[] players, int index, int player) {
        if (players[index] == 0 || players[index] == player) {
            players[index] = player; 
            nums[index] ++; 
            if (nums[index] == size) {
                return player; 
            }
        } else {
            players[index] = 3; 
        } 
        
        return 0; 
    } 
    
    private int checkDiagon(int[][] map, int row, int col, int player) {
        if (row != col && row + col != size - 1) { 
            return 0; 
        } 
        
        int temp = map[0][0]; 
        if (temp != 0) {
            int index = 1; 
            while (index < size) {
                if (map[index][index] != temp) {
                    break; 
                }
                index ++; 
            } 
            if (index == size) {
                return player; 
            } 
        } 
        
        temp = map[0][size - 1]; 
        if (temp != 0) { 
            int y = size - 1, x = 0; 
            while (y >= 0) { 
                if (map[x][y] != temp) {
                    break; 
                } 
                x ++; 
                y --; 
            } 
            if (y == -1) {
                return player; 
            } 
        } 
        
        return 0; 
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */ 

