class Solution {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        
        int fastPtr = nums[0];
        int slowPtr = nums[0];
        do {
            slowPtr = nums[slowPtr];
            fastPtr = nums[fastPtr];
            fastPtr = nums[fastPtr];
        } while (slowPtr != fastPtr);
        
        fastPtr = nums[0];
        while (slowPtr != fastPtr) {
            slowPtr = nums[slowPtr];
            fastPtr = nums[fastPtr];
        }
        
        return fastPtr;        
    }
}