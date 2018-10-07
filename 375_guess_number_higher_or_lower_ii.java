/* 
We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.

However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.

Example:

n = 10, I pick 8.

First round:  You guess 5, I tell you that it's higher. You pay $5.
Second round: You guess 7, I tell you that it's higher. You pay $7.
Third round:  You guess 9, I tell you that it's lower. You pay $9.

Game over. 8 is the number I picked.

You end up paying $5 + $7 + $9 = $21.

Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.
*/ 

class Solution { 
    int[][] dp_array; 
    boolean[][] visited; 
    public int getMoneyAmount(int n) {
        if (n == 0 || n == 1) {
            return 0; 
        } 
        
        visited = new boolean[n + 1][n + 1];  
        dp_array = new int[n + 1][n + 1]; 
        
        return findMaxMoneyDP(1, n); 
    } 
    
    private int findMaxMoneyDP(int start, int end) { 
        if (visited[start][end]) {
            return dp_array[start][end]; 
        } 
        
        if (start == end) { 
            dp_array[start][end] = 0; 
            visited[start][end] = true; 
            return 0; 
        }
        
        if (start + 1 == end) { 
            dp_array[start][end] = start; 
            visited[start][end] = true; 
            return start; 
        } 
        
        if (start + 2 == end) { 
            dp_array[start][end] = start + 1; 
            visited[start][end] = true; 
            return start + 1; 
        } 
        
        dp_array[start][end] = Integer.MAX_VALUE; 
        for (int i = start + 1; i < end;i ++) {
            int temp = i + Math.max(findMaxMoneyDP(start, i - 1), findMaxMoneyDP(i + 1, end)); 
            dp_array[start][end] = Math.min(dp_array[start][end], temp); 
        } 
        
        visited[start][end] = true; 
        return dp_array[start][end]; 
    } 
    
    private int max(int a, int b, int c) {
        int res = (a > b) ? a : b; 
        return (res > c) ? res : c; 
    }
} 
