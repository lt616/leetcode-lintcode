class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]))
                set.remove(nums[i]);
            else
                set.add(nums[i]);
        }
        return set.iterator().next();
    }
}