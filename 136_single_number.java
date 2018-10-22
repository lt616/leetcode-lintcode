/* 
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1

Example 2:

Input: [4,1,2,1,2]
Output: 4
*/ 

/* Solution 01: Sorting */ 
class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1; 
        } 
        
        Arrays.sort(nums); 
        for (int i = 1;i < nums.length;i += 2) {
            if (nums[i] != nums[i - 1]) {
                return nums[i - 1]; 
            }
        } 
        
        return nums[nums.length - 1]; 
    }
} 


/* Solution 02: Bit Manipulation 
Concept

    If we take XOR of zero and some bit, it will return that bit
        a⊕0=aa \oplus 0 = aa⊕0=a
    If we take XOR of two same bits, it will return 0
        a⊕a=0a \oplus a = 0a⊕a=0
    a⊕b⊕a=(a⊕a)⊕b=0⊕b=ba \oplus b \oplus a = (a \oplus a) \oplus b = 0 \oplus b = ba⊕b⊕a=(a⊕a)⊕b=0⊕b=b

So we can XOR all bits together to find the unique number. 
https://leetcode.com/problems/single-number/solution/# Solution4 
*/ 
class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1; 
        } 
        
        int sum = 0; 
        for (Integer num : nums) {
            sum ^= num; 
        } 
        
        return sum; 
    }
} 
