/* 
943. Range Sum Query - Immutable

Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
Example

Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3

Notice

    You may assume that the array does not change.
    There are many calls to sumRange function.
*/ 

class NumArray {
    
    int[] prefix_sum; 
    
    public NumArray(int[] nums) {
        
        if (nums == null || nums.length == 0) {
            return; 
        } 
        
        prefix_sum = new int[nums.length]; 
        
        int sum = 0; 
        for (int i = 0;i < nums.length;i ++) {
            sum += nums[i]; 
            prefix_sum[i] = sum; 
        }
    }
    
    public int sumRange(int i, int j) { 
        int first; 
        if (i == 0) {
            first = 0; 
        } else {
            first = prefix_sum[i - 1]; 
        } 

        return prefix_sum[j] - first; 
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */ 
