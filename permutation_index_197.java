/* 
197. Permutation Index

Given a permutation which contains no repeated number, find its index in all the permutations of these numbers, which are ordered in lexicographical order. The index begins at 1.
Example

Given [1,2,4], return 1. 
*/ 


/* Solution 01: permutation-based DFS [time exceed] */ 
public class Solution {
    /**
     * @param A: An array of integers
     * @return: A long integer
     */ 
    
    int rank = 0; 
    int res = 0; 
    
    public long permutationIndex(int[] A) {
        // write your code here 
        
        if (A == null || A.length == 0) {
            return 1; 
        } 
        
        Set<Integer> is_visited = new HashSet(); 
        List<Integer> buffer = new ArrayList(); 
        
        int[] nums = new int[A.length]; 
        for (int i = 0;i < A.length;i ++) {
            nums[i] = A[i]; 
        } 
        
        Arrays.sort(nums); 
        
        permutationDFS(nums, A, is_visited, buffer); 
        return res; 
    } 
    
    private void permutationDFS(int[] nums, int[] target, Set<Integer> is_visited, List<Integer> buffer) {
        if (res != 0) {
            return; 
        }

        if (is_visited.size() == nums.length) { 
            rank ++; 
            if (checkSamePermutation(target, buffer)) {
                res = rank; 
            } 
            
            return; 
        } 
        
        for (int i = 0;i < nums.length;i ++) {
            if (is_visited.contains(nums[i])) {
                continue; 
            } 
            
            is_visited.add(nums[i]); 
            buffer.add(nums[i]); 
            
            permutationDFS(nums, target, is_visited, buffer); 
            
            is_visited.remove(nums[i]); 
            buffer.remove(buffer.size() - 1); 
        }
    } 
    
    private boolean checkSamePermutation(int[] target, List<Integer> buffer) {
        for (int i = 0;i < target.length;i ++) {
            if (target[i] != buffer.get(i)) {
                return false; 
            } 
        } 
        
        return true; 
    }
} 


/* Solution 02: mathematic problem: rank += index(A[i]) * (size - 1 - i)! */ 
public class Solution {
    /**
     * @param A: An array of integers
     * @return: A long integer
     */ 
    
    int rank = 0; 
    int res = 0; 
    
    public long permutationIndex(int[] A) {
        // write your code here 
        
        if (A == null || A.length == 0) {
            return 1; 
        } 
        
        int[] nums = new int[A.length]; 
        for (int i = 0;i < A.length;i ++) {
            nums[i] = A[i]; 
        } 
        
        Arrays.sort(nums); 

        boolean[] is_visited = new boolean[A.length]; 
        
        Map<Integer, Integer> nums_indexs = new HashMap(); 
        Map<Integer, Integer> nums_indexs_origin = new HashMap(); 
        for (int i = 0;i < nums.length;i ++) {
            nums_indexs.put(nums[i], i); 
            nums_indexs_origin.put(nums[i], i); 
            is_visited[i] = false; 
        } 
        
        long[] ladder = ladderMultiple(A.length); 

        
        long rank = 1; 
        for (int i = 0;i < A.length;i ++) { 
            int index = nums_indexs.get(A[i]); 
            rank += index * ladder[A.length - 1 - i]; 
            
            int index_origin = nums_indexs_origin.get(A[i]); 
            is_visited[index_origin] = true; 
            
            for (int j = index_origin + 1;j < A.length;j ++) {
                if (is_visited[j]) {
                    continue; 
                } 
                nums_indexs.put(nums[j], nums_indexs.get(nums[j]) - 1); 
            }
        } 
        
        return rank; 
    } 
    
    private long[] ladderMultiple(int n) {
        long[] res = new long[n + 1]; 
        long temp = 1; 
        for (int i = 1;i <= n;i ++) {
            temp *= (long) i; 
            res[i] = temp; 
        } 
        
        return res; 
    }
} 
