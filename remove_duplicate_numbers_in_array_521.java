/* 
521. Remove Duplicate Numbers in Array

Given an array of integers, remove the duplicate numbers in it.

You should:

    Do it in place in the array.
    Move the unique numbers to the front of the array.
    Return the total number of the unique numbers.

Example

Given nums = [1,3,1,4,4,2], you should:

    Move duplicate integers to the tail of nums => nums = [1,3,4,2,?,?].
    Return the number of unique integers in nums => 4.

Actually we don't care about what you place in ?, we only care about the part which has no duplicate integers.
Challenge

    Do it in O(n) time complexity.
    Do it in O(nlogn) time without extra space.

Notice

You don't need to keep the original order of the integers.
*/ 

/* Solution 01: 2-pointer */ 
public class Solution {
    /*
     * @param nums: an array of integers
     * @return: the number of unique integers
     */
    public int deduplication(int[] nums) {
        // write your code here 
        
        if (nums == null || nums.length == 0) 
            return 0; 
        
        Arrays.sort(nums); 
        
        int check_ptr = 0, unique_ptr = 0; 
        while (check_ptr < nums.length) {
            if (nums[check_ptr] != nums[unique_ptr]) 
                nums[++ unique_ptr] = nums[check_ptr]; 
            check_ptr ++; 
        } 
        
        return unique_ptr + 1; 
    }
} 

/* Solution 02: counting */ 
public class Solution {
    /*
     * @param nums: an array of integers
     * @return: the number of unique integers
     */
    public int deduplication(int[] nums) {
        // write your code here 
        
        if (nums == null || nums.length == 0) 
            return 0; 
        
        Map<Integer, Integer> numsMap = new HashMap(); 
        for (int i = 0;i < nums.length;i ++) { 
            numsMap.put(nums[i], 0); 
        } 
        
        int index = 0; 
        for (Map.Entry<Integer, Integer> entry : numsMap.entrySet()) 
            nums[index ++] = entry.getKey(); 
        
        return numsMap.size(); 
    }
} 
