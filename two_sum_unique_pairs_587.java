/* 
587. Two Sum - Unique pairs

Given an array of integers, find how many unique pairs in the array such that their sum is equal to a specific target number. Please return the number of pairs.
Example

Given nums = [1,1,2,45,46,46], target = 47
return 2

1 + 46 = 47
2 + 45 = 47
*/ 

/* Solution 01: Hash */ 
public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: An integer
     * @return: An integer
     */
    public int twoSum6(int[] nums, int target) {
        // write your code here 
        
        int aver_flag = 0, same_flag = 0; 
        
        Set<Integer> numsSet = new HashSet(); 
        for (int i = 0;i < nums.length;i ++) { 
            numsSet.add(nums[i]); 
            if (nums[i] == target) {
                same_flag ++; 
            } 
            if (nums[i] * 2 == target) {
                aver_flag ++; 
            } 
        } 
        
        int count = 0, count_plus = 0; 
        for (Integer num : numsSet) {
            if (numsSet.contains(target - num)) { 
                if ((num == target && same_flag > 1) || (num * 2 == target && aver_flag > 1)) { 
                    count_plus ++; 
                } else {
                    count ++;   
                } 
            } 
        } 
        
        
        return count / 2 + count_plus;  
    } 
} 

/* Solution 02: 2-pointer */ 

/* BEAT 100% SUBMISSIONS! */ 

public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: An integer
     * @return: An integer
     */
    public int twoSum6(int[] nums, int target) {
        // write your code here 
        
        if (nums == null || nums.length == 0) 
            return 0; 
        
        Arrays.sort(nums); 
        
        int first_ptr = 0, second_ptr = nums.length - 1; 
        int sum = 0, count = 0; 
        while (first_ptr < second_ptr) { 
            sum = nums[first_ptr] + nums[second_ptr]; 
            if (sum == target) { 
                count ++;
                
                first_ptr ++; 
                while (first_ptr < second_ptr && nums[first_ptr] == nums[first_ptr - 1]) {
                    first_ptr ++; 
                } 
                
                second_ptr --; 
                while (second_ptr > first_ptr && nums[second_ptr] == nums[second_ptr + 1]) {
                    second_ptr --; 
                } 
            } else if (sum < target) { 
                first_ptr ++; 
                while (first_ptr < second_ptr && nums[first_ptr] == nums[first_ptr - 1]) {
                    first_ptr ++; 
                } 
            } else { 
                second_ptr --; 
                while (second_ptr > first_ptr && nums[second_ptr] == nums[second_ptr + 1]) {
                    second_ptr --; 
                }
            }
        } 
        
        return count; 
    } 
}


