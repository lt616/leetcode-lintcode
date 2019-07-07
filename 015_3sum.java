class Solution {
    List<List<Integer>> res;
    
    public List<List<Integer>> threeSum(int[] nums) {
        res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length; i ++) {
            // Find twoSum == 0 - current
            findTwoSum(nums, i + 1, nums.length - 1, 0 - nums[i]);
            
            while (i + 1 < nums.length && nums[i + 1] == nums[i])
                i ++;
        }
        
        return res;
    }
    
    private void findTwoSum(int[] nums, int start, int end, int target) {
        int left = start;
        int right = end;
        // System.out.println("target " + target);
        while (left < right) {
            // System.out.println("left " + nums[left]);
            // System.out.println("right " + nums[right]);
            
            // System.out.println(nums[left] + nums[right]);
            if (nums[left] + nums[right] == target) {
                List<Integer> subRes = new ArrayList<>();
                subRes.add(0 - target);
                subRes.add(nums[left]);
                subRes.add(nums[right]);
                res.add(subRes);
                while (left + 1 < nums.length && nums[left + 1] == nums[left])
                    left ++;
                left ++;
                right --;
            } else if (nums[left] + nums[right] < target) {
                while (left + 1 < nums.length && nums[left + 1] == nums[left])
                    left ++;
                left ++;
            } else {
                right --;
            }
        }
    }
}