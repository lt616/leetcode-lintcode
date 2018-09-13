/* 
139. Subarray Sum Closest

Given an integer array, find a subarray with sum closest to zero. Return the indexes of the first number and last number.
Example

Given [-3, 1, 1, -3, 5], return [0, 2], [1, 3], [1, 1], [2, 2] or [0, 4].
Challenge

O(nlogn) time
*/ 

class Pair {
    int index; 
    int sum; 
    
    public Pair(int index, int sum) {
        this.index = index; 
        this.sum = sum; 
    } 
} 

public class Solution {
    /*
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */ 
    
    int min_diff; 
    int[] res; 
    
    public int[] subarraySumClosest(int[] nums) {
        // write your code here 
        
        res = new int[2]; 
        
        if (nums == null || nums.length == 0) {
            return res; 
        } 
        
        List<Pair> prefix_sum = new ArrayList(); 
        min_diff = Integer.MAX_VALUE; 
        
        int sum = 0; 
        for (int i = 0;i < nums.length;i ++) { 
            sum += nums[i]; 
            prefix_sum.add(new Pair(i, sum)); 
            
            compareWithMin(sum, -1, i); 
        } 
        
        Collections.sort(prefix_sum, new Comparator<Pair>() {
                                        public int compare(Pair p1, Pair p2) {
                                            return p1.sum - p2.sum; 
                                        }
                                    }); 
                                    
        for (int i = 0;i < nums.length - 1;i ++) { 
            Pair first = prefix_sum.get(i); 
            Pair second = prefix_sum.get(i + 1); 
            
            compareWithMin(second.sum - first.sum, first.index, second.index); 
        }
        
        return res; 
    } 
    
    private void compareWithMin(int diff, int x, int y) {
        diff = Math.abs(diff); 
        
        if (diff < min_diff) { 
            min_diff = diff; 
            
            if (x < y) {
                res[0] = x + 1; 
                res[1] = y; 
            } else {
                res[0] = y + 1; 
                res[1] = x; 
            } 
        } 
    } 
} 
