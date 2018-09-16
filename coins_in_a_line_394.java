/* 
394. Coins in a Line

There are n coins in a line. Two players take turns to take one or two coins from right side until there are no more coins left. The player who take the last coin wins.

Could you please decide the first play will win or lose?
Example

n = 1, return true.

n = 2, return true.

n = 3, return false.

n = 4, return true.

n = 5, return true.
Challenge

O(n) time and O(1) memory
*/ 

public class Solution {
    /**
     * @param n: An integer
     * @return: A boolean which equals to true if the first player will win
     */ 
    
    int[] dp_array; 
    
    public boolean firstWillWin(int n) {
        // write your code here 
        
        dp_array = new int[n + 1]; 
        
        return dpDFS(n); 
    } 
    
    private boolean dpDFS(int n) { 
        if (dp_array[n] == 0) {
            if (n == 0) {
                dp_array[n] = 1;    // n == 0 UNKNOWN / n == 1 false / n == 2 true 
            } else if (n == 1 || n == 2) {
                dp_array[n] = 2; 
            } else if ((dpDFS(n - 1 - 1) && dpDFS(n - 1 - 2)) || (dpDFS(n - 2 - 1) && dpDFS(n - 2 - 2))) {
                dp_array[n] = 2; 
            } else {
                dp_array[n] = 1; 
            }             
        }
        
        if (dp_array[n] == 2) {
            return true; 
        } else {
            return false; 
        }
    }
} 
