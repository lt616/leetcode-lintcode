class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        
        if (nums.length == 1)
            return nums[0];
        
        return Math.max(robMaxMoney(nums, 0, nums.length - 2), robMaxMoney(nums, 1, nums.length - 1));
    }
    
    private int robMaxMoney(int[] nums, int start, int end) {
        int[] dpArray = new int[end - start + 2];
        dpArray[0] = 0;
        dpArray[1] = nums[start];
        
        for (int i = 1; i < dpArray.length - 1; i++) {
            dpArray[i + 1] = Math.max(dpArray[i - 1] + nums[i + start], dpArray[i]);
        }
        
        return dpArray[dpArray.length - 1];
    }
}