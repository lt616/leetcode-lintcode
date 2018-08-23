/* 
610. Two Sum - Difference equals to target

Given an array of integers, find two numbers that their difference equals to a target value.
where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are NOT zero-based.
Example

Given nums = [2, 7, 15, 24], target = 5
return [1, 2] (7 - 2 = 5)
Notice

It's guaranteed there is only one available solution
*/ 

/* 
	EASY WRONG POINTS: 
		1. Consider both cases: 
			1). a - b = c; 
			2). b - a = c. 
*/ 

/* Solution 01: Hash */ 
import java.util.*; 

public class Solution {
    /**
     * @param nums: an array of Integer
     * @param target: an integer 
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum7(int[] nums, int target) {
        // write your code here 
        
        if (nums == null || nums.length == 0) 
            return new int[0]; 
        
        Map<Integer, Integer> numsMap = new HashMap(); 
        for (int i = 0;i < nums.length;i ++) { 
            /* a - b = c */ 
            int t1 = nums[i] - target; 
            if (numsMap.containsKey(t1)) {
                return returnCollection(numsMap.get(t1) + 1, i + 1); 
            } 
            
            /* b - a = c */ 
            int t2 = nums[i] + target; 
            if (numsMap.containsKey(t2)) {
                return returnCollection(numsMap.get(t2) + 1, i + 1);  
            } 
            
            numsMap.put(nums[i], i); 
        } 
        
        return new int[0]; 
    } 
    
    private int[] returnCollection(int a, int b) {
        int[] res = new int[2]; 
        res[0] = a; 
        res[1] = b; 
        return res; 
    }
}
