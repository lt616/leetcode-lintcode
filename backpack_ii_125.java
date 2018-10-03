/* 
125. Backpack II

Given n items with size Ai and value Vi, and a backpack with size m. What's the maximum value can you put into the backpack?
Example

Given 4 items with size [2, 3, 5, 7] and value [1, 5, 2, 4], and a backpack with size 10. The maximum value is 9.
Challenge

O(n x m) memory is acceptable, can you do it in O(m) memory?
Notice

You cannot divide item into small pieces and the total size of items you choose should smaller or equal to m.
*/ 

/* Solution 01: DFS, TLE */ 
public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @param V: Given n items with value V[i]
     * @return: The maximum value
     */ 
    
    int max_v = Integer.MIN_VALUE; 
    
    public int backPackII(int m, int[] A, int[] V) {
        // write your code here 
        
        if (m <= 0) {
            return 0; 
        } 
        
        findMaxValue(m, A, V, 0, 0); 
        
        return max_v;  
    } 
    
    private void findMaxValue(int m, int[] A, int[] V, int index, int value) { 

        if (m < 0) {
            return; 
        }
        
        if (index == A.length) { 
            max_v = Math.max(max_v, value); 
            return; 
        } 
    
        findMaxValue(m, A, V, index + 1, value); 
        findMaxValue(m - A[index], A, V, index + 1, value + V[index]); 
    }
} 


/* Solution 02: DP */ 
public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @param V: Given n items with value V[i]
     * @return: The maximum value
     */ 
    
    public int backPackII(int m, int[] A, int[] V) {
        // write your code here 
        
        if (m <= 0) {
            return 0; 
        } 
        
        int size = A.length; 
        int[][] dp_array = new int[size + 1][m + 1]; 
        dp_array[0][0] = 0; 
        for (int i = 0;i < size;i ++) { 
            for (int j = 1;j <= m;j ++) {
                if (j - A[i] < 0) {
                    dp_array[i + 1][j] = dp_array[i][j]; 
                    continue; 
                } 
                
                dp_array[i + 1][j] = Math.max(dp_array[i][j], dp_array[i][j - A[i]] + V[i]); 
            } 
        } 
        
        return dp_array[size][m]; 
    } 
} 
