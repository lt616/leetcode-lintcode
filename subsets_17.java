/* 
17. Subsets

Given a set of distinct integers, return all possible subsets.
Example

If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

Challenge

Can you do it in both recursively and iteratively?
Notice

    Elements in a subset must be in non-descending order.
    The solution set must not contain duplicate subsets.
*/ 


/* Solution 01: combination-based DFS */ 
import java.util.*;

public class Solution {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */ 
    
    List<List<Integer>> res = new ArrayList(); 
    
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here 
        
        if (nums == null || nums.length == 0) { 
            res.add(new ArrayList()); 
            return res; 
        } 
        
        Arrays.sort(nums); 
        
        List<Integer> buffer = new ArrayList(); 
        combinationDFS(nums, 0, buffer); 
        
        return res; 
    } 
    
    private void combinationDFS(int[] nums, int index, List<Integer> buffer) { 
        if (index == nums.length) { 
            List<Integer> new_buffer = new ArrayList(buffer); 
            Collections.copy(new_buffer, buffer); 
            res.add(new_buffer); 
            return; 
        }
        
        buffer.add(nums[index]); 
        int size = buffer.size(); 
        combinationDFS(nums, index + 1, buffer); 
            
        buffer.remove(size - 1); 
        combinationDFS(nums, index + 1, buffer); 
    } 
    
    private void printArray(List<Integer> array) {
        for (Integer num : array) {
            System.out.print(num + " "); 
        } 
        System.out.println(); 
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
    
    public List<List<Integer>> subsets(int[] nums) {
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
        
        List<Integer> new_buffer = new ArrayList(buffer);  
        Collections.copy(new_buffer, buffer); 
        res.add(new_buffer); 
        
        for (int i = index;i < nums.length;i ++) {
            buffer.add(nums[i]); 
            normalDFS(nums, i + 1, buffer); 
            buffer.remove(buffer.size() - 1); 
        }
        
    } 
    
    private void printArray(List<Integer> array) {
        for (Integer num : array) {
            System.out.print(num + " "); 
        } 
        System.out.println(); 
    }
} 
