/* 
15. Permutations

Given a list of numbers, return all possible permutations.
Example

For nums = [1,2,3], the permutations are:

[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

Challenge

Do it without recursion.
Notice

You can assume that there is no duplicate numbers in the list.
*/ 

public class Solution {
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */ 
    
    List<List<Integer>> res = new ArrayList(); 
    
    public List<List<Integer>> permute(int[] nums) {
        // write your code here 
        
        if (nums == null || nums.length == 0) { 
            res.add(new ArrayList()); 
            return res; 
        } 
        
        List<Integer> buffer = new ArrayList(); 
        
        boolean[] is_visited = new boolean[nums.length];
        for (int i = 0;i < nums.length;i ++) {
            is_visited[i] = false; 
        }
        
        permuteDFS(nums, buffer, is_visited); 
        
        return res; 
    } 
    
    private void permuteDFS(int[] nums, List<Integer> buffer, boolean[] is_visited) {
        if (buffer.size() == nums.length) {
            res.add(new ArrayList(buffer)); 
        } 
        
        for (int i = 0;i < nums.length;i ++) { 
            if (is_visited[i]) {
                continue; 
            }
            
            is_visited[i] = true; 
            buffer.add(nums[i]); 
            
            permuteDFS(nums, buffer, is_visited); 
            
            is_visited[i] = false; 
            buffer.remove(buffer.size() - 1); 
        }
    }
} 
