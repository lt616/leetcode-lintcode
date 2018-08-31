/* 
33. N-Queens

The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
Example

There exist two distinct solutions to the 4-queens puzzle:

[
  // Solution 1
  [".Q..",
   "...Q",
   "Q...",
   "..Q."
  ],
  // Solution 2
  ["..Q.",
   "Q...",
   "...Q",
   ".Q.."
  ]
]

Challenge

Can you do it without recursion?
*/ 

public class Solution {
    /*
     * @param n: The number of queens
     * @return: All distinct solutions
     */ 
    
    List<List<Integer>> res = new ArrayList(); 

    public List<List<String>> solveNQueens(int n) {
        // write your code here 
        List<List<String>> res_string = new ArrayList();         
        if (n == 0) {
            return res_string; 
        } 
        
        /* Permute queens' location and validate */ 
        List<Integer> buffer = new ArrayList(); 
        boolean[] is_visited = new boolean[n]; 
        for (int i = 0;i < n;i ++) {
            is_visited[i] = false; 
        }
        
        permuteDFS(n, buffer, is_visited); 
        
        /* Translate result index to string */ 
        for (List<Integer> one_res : res) {  

            List<String> one_res_string_list = new ArrayList(); 
            
            for (int i = 0;i < n;i ++) { 
                StringBuilder one_res_string = new StringBuilder(); 
                for (int j = 0;j < n;j ++) {
                    if (one_res.get(i) == j) {
                        one_res_string.append('Q'); 
                    } else {
                        one_res_string.append('.'); 
                    }
                } 
                one_res_string_list.add(one_res_string.toString()); 
            } 
            res_string.add(one_res_string_list); 
        }
        
        return res_string; 
    } 
    
    private void permuteDFS(int n, List<Integer> buffer, boolean[] is_visited) {
        if (buffer.size() == n) { 
            res.add(new ArrayList(buffer)); 
        } 
        
        for (int i = 0;i < n;i ++) { 
            if (is_visited[i]) { 
                continue; 
            } 
            
            boolean is_valid = true; 
            for (int j = 0;j < buffer.size();j ++) { 
                int diff_x = buffer.size() - j; 
                int diff_y = i - buffer.get(j); 
                if (diff_x == diff_y || diff_x + diff_y == 0) {
                    is_valid = false; 
                    break; 
                }
            } 
            if (! is_valid) {
                continue; 
            } 
            
            buffer.add(i); 
            is_visited[i] = true; 
            
            permuteDFS(n, buffer, is_visited); 
            
            is_visited[i] = false; 
            buffer.remove(buffer.size() - 1); 
        } 
    }
} 
