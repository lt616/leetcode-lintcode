/* Solution 01: Prefix-sum */
class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
    
        int[] sums = new int[nums.length];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sums[i] = (i == 0) ? nums[i] : sums[i - 1] + nums[i];
            if (sums[i] == k) {
                count ++;
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j ++) {
                if (sums[j] - sums[i] == k) {
                    count ++;
                } 
            }
        }
        
        return count;
    }
}


/* Solution 02: Prefiix-sum without space */
class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j ++) {
                sum += nums[j];
                if (sum == k) {
                    count ++;
                } 
            }
        }
        
        return count;
    }
}


/* Solution 03: Prefix-sum with hashmap */
class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
    
        Map<Integer, Integer> map = new HashMap<>();
        int[] sums = new int[nums.length];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sums[i] = (i == 0) ? nums[i] : sums[i - 1] + nums[i];
            if (sums[i] == k) {
                count ++;
            }
            if (map.containsKey(sums[i] - k)) {
                count += map.get(sums[i] - k);
            }
            
            int sumCount = map.getOrDefault(sums[i], 0);
            map.put(sums[i], sumCount + 1);
        }
        
        return count;
    }
}
