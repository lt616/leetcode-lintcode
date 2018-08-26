/* 
5. Kth Largest Element

Find K-th largest element in an array.
Example

In array [9,3,2,4,8], the 3rd largest element is 4.

In array [1,2,3,4,5], the 1st largest element is 5, 2nd largest element is 4, 3rd largest element is 3 and etc.
Challenge

O(n) time, O(1) extra memory.
Notice

You can swap elements in the array
*/ 

/* Solution 01: partition */ 
class Solution {
    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums) {
        if (nums == null || nums.length == 0 || k < 1 || k > nums.length){
            return -1;
        }
        return partition(nums, 0, nums.length - 1, nums.length - k);
    }
    
    private int partition(int[] nums, int start, int end, int k) {
        if (start >= end) {
            return nums[k];
        }
        
        int left = start, right = end;
        int pivot = nums[(start + end) / 2];
        
        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }
            while (left <= right && nums[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
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
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
} 
 
/* Solution 02: quick select */ 
/* Time Exceed ! */  
class Solution {
    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums) {
        // write your code here 
        
        if (nums == null || nums.length == 0 || k < 1 || k > nums.length) { 
            return -1; 
        } 
        
        int start = 0, end = nums.length - 1; 
        int index = -1; 
        int cur; 
        while (start <= end) {  
            cur = nums[end]; 
            index = start - 1; 
            for (int i = start;i < end;i ++) {
                if (nums[i] > cur) {
                    swap(nums, i, ++index);  
                } 
            } 
            swap(nums, end, ++index); 
            
            if (index == k - 1) { 
                return cur;  
            } else if (index < k - 1) {
                k -= index; 
                start = index + 1; 
            } else {
                end = index - 1; 
            }
        }
        
        return -1;   
    } 
    
    private void swap(int[] nums, int left, int right) {
        int temp = nums[right]; 
        nums[right] = nums[left]; 
        nums[left] = temp; 
    }
} 
