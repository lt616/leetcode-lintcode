/* 
Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
Example

Input: [1,2,2]
Output:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

Challenge

Can you do it in both recursively and iteratively?
Notice

    Each element in a subset must be in non-descending order.
    The ordering between two subsets is free.
    The solution set must not contain duplicate subsets.
*/ 


/* Solution 01: combination DFS */ 
/* Solution 02: normal DFS */ 
import java.util.*;

public class Solution {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */ 
    
    List<List<Integer>> res = new ArrayList(); 
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here 
        
        if (nums == null || nums.length == 0) {
            res.add(new ArrayList()); 
            return res; 
        } 
        
        Arrays.sort(nums); 
        
        List<Integer> buffer = new ArrayList(); 
        combinationDFS(nums, 0, buffer, true); 
        
        return res; 
    } 
    
    private void combinationDFS(int[] nums, int index, List<Integer> buffer, boolean add_prev) {
        if (index == nums.length) {
            res.add(new ArrayList(buffer)); 
            return; 
        } 
        
        if (! add_prev && nums[index] == nums[index - 1]) { 
            combinationDFS(nums, index + 1, buffer, false); 
            return; 
        }
        
        buffer.add(nums[index]); 
        combinationDFS(nums, index + 1, buffer, true); 
        
        buffer.remove(buffer.size() - 1); 
        combinationDFS(nums, index + 1, buffer, false);  
    }
} 


/* Solution 02: normal DFS */ 
import java.util.*;

public class Solution {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */ 
    
    List<List<Integer>> res = new ArrayList(); 
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here 
        
        if (nums == null || nums.length == 0) {
            res.add(new ArrayList()); 
            return res; 
        } 
        
        Arrays.sort(nums); 
        
        List<Integer> buffer = new ArrayList(); 
        normalDFS(nums, 0, buffer); 
        
        return res; 
    } 
    
    private void normalDFS(int[] nums, int index, List<Integer> buffer) {
        res.add(new ArrayList(buffer)); 
        
        for (int i = index;i < nums.length;i ++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue; 
            }
            
            buffer.add(nums[i]);  
            normalDFS(nums, i + 1, buffer); 
            buffer.remove(buffer.size() - 1); 
        }
    }
} 
