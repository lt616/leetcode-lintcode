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
        
        for (int i = colors.length - 1;i >= 0;i --) {
            bubbleSort(colors, i); 
        } 
    } 
    
    private void bubbleSort(int[] colors, int end) {
        for (int i = 0;i < end;i ++) {
            if (colors[i] > colors[i + 1]) {
                swap(colors, i, i + 1); 
            }
        }
    }
    
    private void swap(int[] nums, int a, int b) {
        int temp = nums[b]; 
        nums[b] = nums[a]; 
        nums[a] = temp; 
    }
} 
