/* Solution 01: Normal rotating array */
class Solution {
    int[] dpArray;
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) 
            return 0;
        
        this.dpArray = new int[nums.length + 1];
        this.dpArray[0] = 0;
        this.dpArray[1] = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            this.dpArray[i + 1] = Math.max(this.dpArray[i - 1] + nums[i], this.dpArray[i]);
        }
        
        return this.dpArray[nums.length];
    }
}

/* Solution 02: Reduced memory rotatin array */
class Solution {
    int[] dpArray;
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) 
            return 0;
        
        this.dpArray = new int[2];
        this.dpArray[0] = 0;
        this.dpArray[1] = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            this.dpArray[(i + 1) % 2] = Math.max(this.dpArray[(i - 1) % 2] + nums[i], this.dpArray[i % 2]);
        }
        
        return this.dpArray[nums.length % 2];
    }
}
