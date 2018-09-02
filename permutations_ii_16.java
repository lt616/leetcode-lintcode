/* 
16. Permutations II

Given a list of numbers with duplicate number in it. Find all unique permutations.
Example

For numbers [1,2,2] the unique permutations are:

[
  [1,2,2],
  [2,1,2],
  [2,2,1]
]

Challenge

Using recursion to do it is acceptable. If you can do it without recursion, that would be great!
*/ 

public class Solution {
    /*
     * @param :  A list of integers
     * @return: A list of unique permutations
     */ 
    
    List<List<Integer>> res = new ArrayList(); 
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        // write your code here 
        
        if (nums == null || nums.length == 0) { 
            res.add(new ArrayList()); 
            return res; 
        } 
        
        Arrays.sort(nums); 
        
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
            
            if (i > 0 && nums[i - 1] == nums[i] && ! is_visited[i - 1]) { 
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
