/* 
840. Range Sum Query - Mutable

Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

The update(i, val) function modifies nums by updating the element at index i to val.
Example

Given nums = [1, 3, 5]

sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8

Notice

1.The array is only modifiable by the update function.
2.You may assume the number of calls to update and sumRange function is distributed evenly.
*/ 


/* Solution 01: prefix sum */ 
class NumArray { 
    
    int[] prefix_sum; 
    int[] nums;

    public NumArray(int[] nums) {
        
        this.nums = nums; 
        prefix_sum = new int[nums.length]; 
        
        int sum = 0; 
        for (int i = 0;i < nums.length;i ++) {
            sum += nums[i]; 
            prefix_sum[i] = sum; 
        }
    }
    
    public void update(int i, int val) {
        int diff = val - nums[i]; 
        if (diff == 0) {
            return; 
        }
        
        for (int j = i;j < nums.length;j ++) {
            prefix_sum[j] += diff; 
        } 
        
        nums[i] = val; 
    }
    
    public int sumRange(int i, int j) {
        if (i == 0) {
            return prefix_sum[j]; 
        } 
        
        return prefix_sum[j] - prefix_sum[i - 1]; 
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */  
