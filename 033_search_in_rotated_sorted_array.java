class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            
            if (nums[mid] == target)
                return mid;
            
            if (nums[mid] < target) {
                if (nums[start] > nums[mid] && target > nums[end])
                    end = mid;
                else
                    start = mid;
            } else {
                if (nums[mid] > nums[end] && nums[start] > target)
                    start = mid;
                else
                    end = mid;
            }
        }
        
        if (nums[start] == target)
            return start;
        
        if (nums[end] == target)
            return end;
        
        return -1;
    }
}