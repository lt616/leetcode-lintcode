/* 
Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input: [1,2,0]
Output: 3

Example 2:

Input: [3,4,-1,1]
Output: 2

Example 3:

Input: [7,8,9,11,12]
Output: 1

Note:

Your algorithm should run in O(n) time and uses constant extra space.
*/ 

/* Solution 01: using array, O(n), O(n) */ 
class Solution {
    public int firstMissingPositive(int[] nums) {
        int[] pos_nums = new int[nums.length + 1]; 
        pos_nums[0] = 1; 
        for (int i = 0;i < nums.length;i ++) {
            if (nums[i] > 0 && nums[i] <= nums.length) {
                pos_nums[nums[i]] = 1; 
            } 
        } 
        
        for (int i = 0;i < pos_nums.length;i ++) {
            if (pos_nums[i] == 0) {
                return i; 
            } 
        } 
        
        return nums.length + 1; 
    }
} 


/* Solution 02: Sort Array, O(n logn), O(1) */ 
class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1; 
        } 
        
        Arrays.sort(nums); 
        
        int current = 0; 
        for (int i = 0;i < nums.length;i ++) { 
            if (nums[i] <= 0) {
                continue; 
            }
            
            if (nums[i] > current + 1) { 
                return current + 1; 
            } 
            current = nums[i]; 
        } 
        
        return current + 1; 
    }
} 


/* Solution 03: Hash */ 
class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>(); 
        for (int i = 0;i < nums.length;i ++) {
            set.add(nums[i]); 
        } 
        
        for (int i = 1;i <= nums.length;i ++) {
            if (! set.contains(i)) {
                return i; 
            } 
        } 
        
        return nums.length + 1; 
    }
} 
