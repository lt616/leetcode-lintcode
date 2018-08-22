/* 
604. Window Sum

Given an array of n integer, and a moving window(size k), move the window at each iteration from the start of the array, find the sum of the element inside the window at each moving.
Example

For array [1,2,7,8,5], moving window size k = 3.
1 + 2 + 7 = 10
2 + 7 + 8 = 17
7 + 8 + 5 = 20
return [10,17,20]
*/ 

public class Solution {
    /**
     * @param nums: a list of integers.
     * @param k: length of window.
     * @return: the sum of the element inside the window at each moving.
     */
    public int[] winSum(int[] nums, int k) {
        // write your code here 
        
        int size = nums.length; 
        
        if (nums == null || size == 0) 
            return new int[0]; 
        
        int sum = 0; 
        int[] res = new int[size - k + 1]; 
        for (int i = 0;i < k;i ++) { 
            sum += nums[i]; 
        } 
        res[0] = sum; 
        
        /* 2-points */ 
        int first = 0; 
        int last = k; 
        while (last < size) {
            sum += nums[last] - nums[first]; 
            res[first + 1] = sum; 
            first ++; 
            last ++; 
        }
        
        return res; 
    }
}
