/* Solution 01: Priority Queue */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer n1, Integer n2) {
                return n2 - n1;
            }
        });
        
        for (Integer num : nums) {
            pq.offer(num);
        }
        
        for (int i = 0; i < k - 1; i++) {
            pq.poll();
        }
        
        return pq.peek();
    }
}

/* Solution 02: Quick Select */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        return partition(nums, 0, nums.length - 1, k - 1);
    }
    
    private int partition(int[] nums, int start, int end, int k) {
        int left = start;
        int right = end;
        
        int privot = nums[start + (end - start) / 2];
        while (left <= right) {
            while (left <= right && nums[left] > privot) {
                left ++;
            }
            
            while (left <= right && nums[right] < privot) {
                right --;
            }
            
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left ++;
                right --;
            }
        }
        
        if (k <= right) {
            return partition(nums, start, right, k);
        }
        
        if (k >= left) {
            return partition(nums, left, end, k);
        }
        
        return nums[k];
    }
}
