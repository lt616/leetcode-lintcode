/* 
692. Sliding Window Unique Elements Sum

Given an array and a window size that is sliding along the array, find the sum of the count of unique elements in each window.
Example

Given a array nums = [1, 2, 1, 3, 3] and k = 3

First window [1, 2, 1], only 2 is unique, count is 1.
Second window [2, 1, 3], all elements unique, count is 3.
Third window [1, 3, 3], only 1 is unique, count is 1.
sum of count = 1 + 3 + 1 = 5

Return 5
*/ 

public class Solution {
    /**
     * @param nums: the given array
     * @param k: the window size
     * @return: the sum of the count of unique elements in each window
     */
    public int slidingWindowUniqueElementsSum(int[] nums, int k) {
        // write your code here 
        
        if (nums == null || nums.length == 0 || k == 0) {
            return 0; 
        } 
        
        Set<Integer> set = new HashSet(); 
        Map<Integer, Integer> map = new HashMap(); 
        
        int count = 0;        
        for (int i = 0;i < min(k, nums.length);i ++) { 
            pushInNum(nums[i], map, set); 
        } 
        count += set.size() - map.size(); 

        for (int i = 1;i + k - 1 < nums.length;i ++) { 
            pullOutNum(nums[i - 1], map, set); 
            pushInNum(nums[i + k - 1], map, set); 
            count += set.size() - map.size(); 
        } 
        
        return count; 
    } 
    
    private void pushInNum(int num, Map<Integer, Integer> map, Set<Integer> set) {
        if (set.contains(num)) {
            if (! map.containsKey(num)) {
                map.put(num, 1); 
            } else { 
                map.put(num, map.get(num) + 1); 
            } 
        } else {
            set.add(num); 
        } 
    } 
    
    private void pullOutNum(int num, Map<Integer, Integer> map, Set<Integer> set) {
        if (! map.containsKey(num)) {
            set.remove(num); 
            return; 
        } else {
            map.put(num, map.get(num) - 1); 
            if (map.get(num) == 0) {
                map.remove(num); 
            } 
        } 
    } 
    
    private int min(int a, int b) {
        return (a < b) ? a : b; 
    }
} 
