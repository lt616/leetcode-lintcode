public class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here 
        
        if (colors == null || colors.length == 0) {
            return; 
        } 
        
        int start = 0, end = colors.length - 1; 
        quickSort(colors, start, end); 
    } 
    
    private void quickSort(int[] nums, int start, int end) { 
        if (start >= end) { 
            return; 
        } 

        int left = start, right = end; 
        int mid = start + (end - start) / 2; 
        int privot = nums[mid]; 
        
        while (left <= right) { 
            while (left <= right && nums[left] < privot) {
                left ++; 
            } 
            
            while (left <= right && nums[right] > privot) {
                right --; 
            } 
            
            if (left <= right) {
                swap(nums, left, right); 
                left ++; 
                right --; 
            } 
        } 
        
        quickSort(nums, start, left - 1); 
        quickSort(nums, left, end); 
    } 
    
    private void swap(int[] nums, int a, int b) {
        int temp = nums[b]; 
        nums[b] = nums[a]; 
        nums[a] = temp; 
    }
} 
