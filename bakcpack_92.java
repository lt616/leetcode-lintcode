/* 
92. Backpack

Given n items with size Ai, an integer m denotes the size of a backpack. How full you can fill this backpack?
Example

If we have 4 items with size [2, 3, 5, 7], the backpack size is 11, we can select [2, 3, 5], so that the max size we can fill this backpack is 10. If the backpack size is 12. we can select [2, 3, 7] so that we can fulfill the backpack.

You function should return the max size we can fill in the given backpack.
Challenge

O(n x m) time and O(m) memory.

O(n x m) memory is also acceptable if you do not know how to optimize memory.
Notice

You can not divide any item into small pieces.
*/ 

public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */ 
    public int backPack(int m, int[] A) {
        // write your code here 
        
        if (A == null || A.length == 0) {
            return 0; 
        } 
        
        Arrays.sort(A); 
        
        boolean[][] dp_array = new boolean[A.length + 1][m + 1]; 
        dp_array[0][0] = true; 
        for (int i = 0;i <= A.length;i ++) {
            dp_array[i][0] = true; 
        }
        
        for (int i = 1;i <= A.length;i ++) {
            for (int j = 0;j <= m;j ++) {
                dp_array[i][j] = dp_array[i - 1][j]; 
                
                if (j - A[i - 1] >= 0 && dp_array[i - 1][j - A[i - 1]]) {
                    dp_array[i][j] = true; 
                }
            }
        }
        
        for (int i = m;i >= 0;i --) {
            if (dp_array[A.length][i]) {
                return i; 
            }
        }
        
        return 0;  
    } 
} 
