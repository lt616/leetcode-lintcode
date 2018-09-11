/* 
406. Minimum Size Subarray Sum

Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return -1 instead.
Example

Given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has the minimal length under the problem constraint.
Challenge

If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
*/ 

/* 
	EASY WRONG POINTS: 
		1. Be clear with the logical flow. 
		2. Still need to compare min_len vs new_len. 
		3. Optimization: j don't need to step back. 
*/ 

/* Solution 01: only-forwarding j by myself */ 
public class Solution {
    /**
     * @param nums: an array of integers
     * @param s: An integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // write your code here 
        
        if (nums == null || nums.length == 0) {
            return -1; 
        } 
        
        int min_len = Integer.MAX_VALUE; 
        boolean is_valid = false; 
        
        int i = 0, j = 0; 
        int sum = 0; 
        for (i = 0;i < nums.length;i ++) { 
            while (j < nums.length && sum < s) { 
                sum += nums[j]; 
                j ++; 
            } 
            
            if (sum >= s) { 
                is_valid = true; 
                min_len = min(min_len, j - i); 
            }
            
            sum -= nums[i]; 
        } 
        
        return (is_valid) ? min_len : -1;  
    } 
    
    private int min(int a, int b) {
        return (a < b) ? a : b; 
    }
} 


/* Solution 02: only-forwarding j template */ 
public class Solution {
    /**
     * @param nums: an array of integers
     * @param s: an integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // write your code here
        int j = 0, i = 0;
        int sum =0;
        int ans = Integer.MAX_VALUE;
        for(i = 0; i < nums.length; i++) {
            while(j < nums.length && sum < s) {
                sum += nums[j];
                j ++;
            }
            if(sum >=s) {
                ans = Math.min(ans, j - i);
            }
            sum -= nums[i];
        }
        if(ans == Integer.MAX_VALUE)
            ans = -1;
        return ans;
    }
} 
