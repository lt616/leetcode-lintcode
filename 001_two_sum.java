class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        
        int[] res = new int[2];
        Map<Integer, Integer> dict = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (dict.containsKey(target - nums[i])) {
                res[0] = dict.get(target - nums[i]);
                res[1] = i;
                return res;
            }
            dict.put(nums[i], i);
        }
        return res;
    }
}