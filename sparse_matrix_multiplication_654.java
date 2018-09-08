/* 
654. Sparse Matrix Multiplication

Given two Sparse Matrix A and B, return the result of AB.

You may assume that A's column number is equal to B's row number.
Example

A = [
  [ 1, 0, 0],
  [-1, 0, 3]
]

B = [
  [ 7, 0, 0 ],
  [ 0, 0, 0 ],
  [ 0, 0, 1 ]
]


     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                  | 0 0 1 |
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
     * @param A: a sparse matrix
     * @param B: a sparse matrix
     * @return: the result of A * B
     */
    public int[][] multiply(int[][] A, int[][] B) {
        // write your code here 
        
        int[][] res = new int[A.length][B[0].length]; 
        Map<Integer, List<Integer>> map_A = new HashMap(); 
        Map<Integer, Set<Integer>> map_B = new HashMap(); 
        
        for (int i = 0;i < A.length;i ++) {
            for (int j = 0;j < A[0].length;j ++) {
                if (A[i][j] != 0) {
                    if (! map_A.containsKey(i)) {
                        map_A.put(i, new ArrayList()); 
                    } 
                    map_A.get(i).add(j); 
                } 
            } 
        } 
        
        for (int i = 0;i < B.length;i ++) {
            for (int j = 0;j < B[0].length;j ++) {
                if (B[i][j] != 0) { 
                    if (! map_B.containsKey(j)) {
                        map_B.put(j, new HashSet()); 
                    } 
                    map_B.get(j).add(i); 
                } 
            } 
        } 
        
        for (int i = 0;i < A.length;i ++) { 
            for (int j = 0;j < B[0].length;j ++) { 
                int sum = 0; 
                
                if (! map_A.containsKey(i) || ! map_B.containsKey(j)) { 
                    res[i][j] = 0; 
                    continue; 
                }
                
                List<Integer> c_A = map_A.get(i); 
                Set<Integer> c_B = map_B.get(j); 
                
                for (Integer num : c_A) {
                    if (c_B.contains(num)) {
                        sum += A[i][num] * B[num][j]; 
                    } 
                } 
                
                res[i][j] = sum; 
            } 
        } 
        
        return res; 
    }
} 
