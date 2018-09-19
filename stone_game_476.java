/* 
476. Stone Game

There is a stone game.At the beginning of the game the player picks n piles of stones in a line.

The goal is to merge the stones in one pile observing the following rules:

    At each step of the game,the player can merge two adjacent piles to a new pile.
    The score is the number of stones in the new pile.

You are to determine the minimum of the total score.
Example

For [4, 1, 1, 4], in the best solution, the total score is 18:

1. Merge second and third piles => [4, 2, 4], score +2
2. Merge the first two piles => [6, 4]，score +6
3. Merge the last two piles => [10], score +10

Other two examples:
[1, 1, 1, 1] return 8
[4, 4, 5, 9] return 43
*/ 

public class Solution {
    /**
     * @param A: An integer array
     * @return: An integer
     */ 
    
    int[][] array_value; 
    int[][] array_sum; 
    boolean[][] visited; 
    
    public int stoneGame(int[] A) {
        // write your code here 
        
        int res = 0; 
        
        if (A == null || A.length == 0) {
            return res; 
        } 
        
        List<Integer> nums = new ArrayList(); 
        for (int i = 0;i < A.length;i ++) {
            nums.add(A[i]); 
        } 
        
        array_value = new int[A.length][A.length]; 
        array_sum = new int[A.length][A.length]; 
        visited = new boolean[A.length][A.length]; 
        
        int score[] = dpDFS(A, 0, A.length - 1); 
        System.out.println(score[1]); 
        
        return score[1]; 
    } 
    
    private int[] dpDFS(int[] nums, int start, int end) { 
        int[] res = new int[2]; 
        if (visited[start][end]) { 
            res[0] = array_value[start][end]; 
            res[1] = array_sum[start][end]; 
            return res; 
        }
        

        if (start == end) { 
            res[0] = nums[start]; 
            res[1] = 0; 
            
            visited[start][end] = true; 
            array_value[start][end] = res[0]; 
            array_sum[start][end] = res[1]; 
            
            return res; 
        }
        
        int min = Integer.MAX_VALUE; 
        int min_sum = 0; 
        for (int i = start;i < end;i ++) {
            int[] left_sum = dpDFS(nums, start, i); 
            int[] right_sum = dpDFS(nums, i + 1, end); 
            int sum = left_sum[0] + right_sum[0] + left_sum[1] + right_sum[1]; 
            if (sum < min) {
                min = sum; 
                min_sum = left_sum[0] + right_sum[0];  
            } 
        }  
        
        res[0] = min_sum;  
        res[1] = min; 
        
        visited[start][end] = true; 
        array_value[start][end] = res[0]; 
        array_sum[start][end] = res[1]; 
        
        return res; 
    }
} 
