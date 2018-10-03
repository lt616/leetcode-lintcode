/* 
440. Backpack III

Given n kind of items with size Ai and value Vi( each item has an infinite number available) and a backpack with size m. What's the maximum value can you put into the backpack?
Example

Given 4 items with size [2, 3, 5, 7] and value [1, 5, 2, 4], and a backpack with size 10. The maximum value is 15.
Notice

You cannot divide item into small pieces and the total size of items you choose should smaller or equal to m.
*/ 

/* BEATS 100% SOLUTIONS! */ 

public class Solution {
    /**
     * @param A: an integer array
     * @param V: an integer array
     * @param m: An integer
     * @return: an array
     */
    public int backPackIII(int[] A, int[] V, int m) {
        // write your code here 
        
        if (m <= 0) {
            return 0; 
        } 
        
        int[] dp_array = new int[m + 1]; 
        dp_array[0] = 0; 
        for (int i = 1;i <= m;i ++) { 
            dp_array[i] = dp_array[i - 1]; 
            for (int j = 0;j < V.length;j ++) { 
                if (i - A[j] < 0) {
                    continue; 
                } 
                
                dp_array[i] = Math.max(dp_array[i], dp_array[i - A[j]] + V[j]); 
            } 
        } 
        
        return dp_array[m]; 
    }
} 
