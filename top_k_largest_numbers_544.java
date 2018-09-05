/* 
544. Top k Largest Numbers

Given an integer array, find the top k largest numbers in it.
Example

Given [3,10,1000,-99,4,100] and k = 3.
Return [1000, 100, 10].
*/ 

/* Solution 01: quick select */ 
public class Solution {
    /**
     * @param nums: an integer array
     * @param k: An integer
     * @return: the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        // write your code here 
        
        if (nums == null || nums.length == 0 || k == 0 || k > nums.length) {
            return new int[0]; 
        } 
        
        int[] res = new int[k]; 
        
        int start = 0, end = nums.length - 1; 
        int privot_index, left = 0, right; 
        while (start < end) { 
            left = start; 
            right = end; 
            privot_index = (start + end) / 2; 
            System.out.println(left + ", " + right + ", " + k); 
            int privot = nums[privot_index]; 
            while (left <= right) { 
                while (left <= right && nums[left] > privot) {
                    left ++; 
                } 
            
                while (left <= right && nums[right] < privot) {
                    right --; 
                } 
            
                if (left <= right) {
                    swap(nums, left, right); 
                    left ++; 
                    right --; 
                } 
            } 
            
            System.out.println(left + ", "  + right + ", " + start + ", " + end);  
            
            if (k <= right) {
                end = right; 
            } else if (k >= left) {
                start = left; 
            } 
        }  
        
        int[] temp = new int[k]; 
        for (int i = 0;i < k;i ++) {
            temp[i] = nums[i]; 
        } 
        
        Arrays.sort(temp); 
        
        for (int i = 0;i < k;i ++) {
            res[k - i - 1] = temp[i]; 
        }
        
        return res; 
    } 
    
    private void swap(int[] nums, int a, int b) {
        int temp = nums[b]; 
        nums[b] = nums[a]; 
        nums[a] = temp; 
    }
} 


/* Solution 02: heap */ 
public class Solution {
    /**
     * @param nums: an integer array
     * @param k: An integer
     * @return: the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        // write your code here 
        
        if (nums == null || nums.length == 0 || k == 0 || k > nums.length) {
            return new int[0]; 
        } 
        
        int[] res = new int[k]; 
        Queue<Integer> pq = new PriorityQueue<Integer>((x, y) -> y - x); 
        
        for (int i = 0;i < nums.length;i ++) {
            pq.offer(nums[i]); 
        } 
        
        for (int i = 0;i < k;i ++) {
            res[i] = pq.poll(); 
        }
        
        return res; 
    } 
} 
