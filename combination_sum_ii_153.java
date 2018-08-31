/* 
153. Combination Sum II

Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.
Example

Given candidate set [10,1,6,7,2,1,5] and target 8,

A solution set is:

[
  [1,7],
  [1,2,5],
  [2,6],
  [1,1,6]
]

Notice

    All numbers (including target) will be positive integers.
    Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
    The solution set must not contain duplicate combinations.
*/ 

public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */ 
    
    List<List<Integer>> res = new ArrayList(); 
    
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here 
        
        if (num == null || num.length == 0) {
            return res; 
        } 
        
        Arrays.sort(num); 
        
        List<Integer> buffer = new ArrayList(); 
        combinationDFS(num, 0, buffer, target); 
        
        return res; 
    } 
    
    private void combinationDFS(int[] num, int index, List<Integer> buffer, int target) {
        if (target == 0) {
            res.add(new ArrayList(buffer)); 
        } 
        
        for (int i = index;i < num.length;i ++) { 
            if (target - num[i] < 0) {
                return; 
            }
            
            if (i != index && num[i - 1] == num[i]) {
                continue; 
            } 
            
            buffer.add(num[i]); 
            combinationDFS(num, i + 1, buffer, target - num[i]); 
            buffer.remove(buffer.size() - 1); 
        }
    }
} 
