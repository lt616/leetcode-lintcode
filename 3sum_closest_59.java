/* 
59. 3Sum Closest

Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers.
Example

For example, given array S = [-1 2 1 -4], and target = 1. The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Challenge

O(n^2) time, O(1) extra space
Notice

You may assume that each input would have exactly one solution.
*/ 

public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target: An integer
     * @return: return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers, int target) {
        // write your code here 
        
        if (numbers == null || numbers.length == 0) {
            return -1; 
        } 
        
        Arrays.sort(numbers); 
        
        int min_diff = Integer.MAX_VALUE; 
        int max_sum = -1; 
        
        for (int i = 0;i < numbers.length;i ++) {
            while (i > 0 && i < numbers.length - 1 && numbers[i] == numbers[i - 1]) {
                i ++; 
            } 
            
            int t = target - numbers[i];  
            int start = i + 1, end = numbers.length - 1; 
            while (start < end) {
                int sum = numbers[start] + numbers[end]; 
                int diff = Math.abs(sum - t);
                if (sum == t) { 
                    return sum + numbers[i]; 
                } else if (sum < t) { 
                    while (start < end - 1 && numbers[start + 1] == numbers[start]) {
                        start ++; 
                    } 
                    start ++; 
                } else if (sum > t) {
                    while (start < end - 1 && numbers[end - 1] == numbers[end]) {
                        end --; 
                    } 
                    end --; 
                } 
                
                max_sum = (diff < min_diff) ? sum + numbers[i] : max_sum; 
                if (diff < min_diff) {
                    max_sum = sum + numbers[i]; 
                    min_diff = diff; 
                } 
            }
        }
        
        return max_sum; 
    }
} 
