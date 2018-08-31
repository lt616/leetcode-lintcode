/* 
135. Combination Sum

Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.
Example

Given candidate set [2,3,6,7] and target 7, a solution set is:

[7]
[2, 2, 3]

Notice

    All numbers (including target) will be positive integers.
    Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
    The solution set must not contain duplicate combinations.
*/ 

public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     */ 
    
    List<List<Integer>> res = new ArrayList(); 
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here 
        
        if (candidates == null || candidates.length == 0) {
            return res; 
        } 
        
        Set<Integer> set = new HashSet(); 
        for (int i = 0;i < candidates.length;i ++) {
            set.add(candidates[i]); 
        } 
        
        int[] non_dup_candidates = new int[set.size()]; 
        int index = -1; 
        for (Integer num : set) {
            non_dup_candidates[++ index] = num; 
        } 
        
        Arrays.sort(non_dup_candidates); 
        
        List<Integer> buffer = new ArrayList(); 
        normalDFS(non_dup_candidates, 0, buffer, 0, target); 
        
        return res; 
    } 
    
    private void normalDFS(int[] nums, int index, List<Integer> buffer, int sum, int target) { 
        if (sum == target) { 
            res.add(new ArrayList(buffer)); 
        } 
        
        if (index == nums.length || (sum + nums[index] > target)) {
            return; 
        } 
        
        buffer.add(nums[index]); 
        normalDFS(nums, index, buffer, sum + nums[index], target); 
        
        buffer.remove(buffer.size() - 1); 
        normalDFS(nums, index + 1, buffer, sum, target); 
        
        
    }
} 

/* Solution 02: combination-based DFS */ 
public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     */ 
    
    List<List<Integer>> res = new ArrayList(); 
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here 
        
        if (candidates == null || candidates.length == 0) {
            return res; 
        } 
        
        Set<Integer> set = new HashSet(); 
        for (int i = 0;i < candidates.length;i ++) {
            set.add(candidates[i]); 
        } 
        
        int[] non_dup_candidates = new int[set.size()]; 
        int index = -1; 
        for (Integer num : set) {
            non_dup_candidates[++ index] = num; 
        } 
        
        Arrays.sort(non_dup_candidates); 
        
        List<Integer> buffer = new ArrayList(); 
        combinationDFS(non_dup_candidates, 0, buffer, 0, target); 
        
        return res; 
    } 
    
    private void combinationDFS(int[] nums, int index, List<Integer> buffer, int sum, int target) { 
        if (sum == target) { 
            res.add(new ArrayList(buffer)); 
        } 
        
        for (int i = index;i < nums.length;i ++) { 
            if (sum + nums[i] > target) {
                return; 
            }
            
            buffer.add(nums[i]); 
            combinationDFS(nums, i, buffer, sum + nums[i], target); 
            buffer.remove(buffer.size() - 1); 
        }
        
        
        
    }
} 
