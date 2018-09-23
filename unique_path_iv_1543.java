/* 
1543. Unique Path IV

Give two integers to represent the height and width of the grid. The starting point is in the upper left corner and the ending point is in the upper right corner. You can go to the top right, right or bottom right. Find out the number of paths you can reach the end. And the result needs to mod 1000000007.
Example

input:
height = 3
width = 3
output:
2

Notice

width > 1, height > 1
*/ 

public class Solution {
    /**
     * @param height: the given height
     * @param width: the given width
     * @return: the number of paths you can reach the end
     */ 
    
    long MOD = 1000000007; 
    
    public int uniquePath(int height, int width) {
        // Write your code here 
        
        if (height <= 0 || width <= 0) {
            return 0; 
        } 
        
        long[][] dp_array = new long[height + 2][width + 2]; 
        dp_array[0][0] = 1; 
        
        for (int j = 1;j <= width;j ++) {
            for (int i = 1;i <= height;i ++) {
                dp_array[i][j] = dp_array[i - 1][j - 1] + dp_array[i][j - 1] + dp_array[i + 1][j - 1]; 
                dp_array[i][j] %= MOD; 
            } 
        } 
        
        return (int) dp_array[1][width]; 
    }
} 
