/* 
Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:

Input: [-1,-100,3,99] and k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]

Note:

    Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
    Could you do it in-place with O(1) extra space?
*/ 


/* Solution 01: Brute Force */ 
class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return; 
        } 
        
        while (k > 0) {
            shiftRight(nums); 
            k --; 
        } 
    } 
    
    private void shiftRight(int[] nums) {
        int temp = nums[nums.length - 1]; 
        for (int i = nums.length - 1;i > 0;i --) {
            nums[i] = nums[i - 1]; 
        } 
        nums[0] = temp; 
    }
} 


/* Solution 02: Cyclic Replacement */ 
class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return; 
        } 
        
        k = k % nums.length; 
        
        int count = 0; 
        for (int i = 0;i < k;i ++) {
            int index = i; 
            int current = nums[index]; 
            while (true) { 
                count ++; 
                int next = nums[(index + k) % nums.length]; 
                nums[(index + k) % nums.length] = current; 
                current = next; 
                index = (index + k) % nums.length; 
                if (index == i) {
                    break; 
                }
            } 
            
            if (count == nums.length) {
                break; 
            } 
        } 
    } 
} 


/* Solution 03: Reverse 
	Original List                   : 1 2 3 4 5 6 7
	After reversing all numbers     : 7 6 5 4 3 2 1
	After reversing first k numbers : 5 6 7 4 3 2 1
	After revering last n-k numbers : 5 6 7 1 2 3 4 --> Result
*/ 
public class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
} 
