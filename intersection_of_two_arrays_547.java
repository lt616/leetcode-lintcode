/* 
547. Intersection of Two Arrays

Given two arrays, write a function to compute their intersection.
Example

Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
Challenge

Can you implement it in three different algorithms?
Notice

    Each element in the result must be unique.
    The result can be in any order.
*/ 


/* Solution 01: sort & merge */ 
public class Solution {
    /**
     * @param nums1: an integer array
     * @param nums2: an integer array
     * @return: an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // write your code here 
        
        Arrays.sort(nums1); 
        Arrays.sort(nums2); 
        
        Set<Integer> set = new HashSet(); 
        
        int i = 0, j = 0; 
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                set.add(nums1[i]); 
                i ++; 
                j ++; 
            } else if (nums1[i] < nums2[j]) {
                i ++; 
            } else {
                j ++; 
            } 
        } 
        
        int index = -1; 
        int[] res = new int[set.size()]; 
        for (Integer num : set) {
            res[++ index] = num; 
        } 
        
        return res; 
    }
} 


/* Solution 02: hash */ 
public class Solution {
    /**
     * @param nums1: an integer array
     * @param nums2: an integer array
     * @return: an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // write your code here 
        
        Set<Integer> set = new HashSet(); 
        for (int i = 0;i < nums1.length;i ++) {
            set.add(nums1[i]); 
        } 
        
        Set<Integer> res_set = new HashSet(); 
        for (int i = 0;i < nums2.length;i ++) {
            if (set.contains(nums2[i])) {
                res_set.add(nums2[i]); 
            } 
        } 
        
        int[] res = new int[res_set.size()]; 
        int index = -1; 
        for (Integer num : res_set) {
            res[++ index] = num; 
        } 
        
        return res; 
    }
} 


/* Solution 03: 2-pointer */ 
public class Solution {
    /**
     * @param nums1: an integer array
     * @param nums2: an integer array
     * @return: an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // write your code here 
        
        Set<Integer> set = new HashSet(); 
        
        Arrays.sort(nums1); 
        Arrays.sort(nums2); 
        
        int i = 0, j = 0; 
        while (i < nums1.length && j < nums2.length) {
            while (i > 0 && i < nums1.length && nums1[i] == nums1[i - 1]) {
                i ++; 
            } 
            
            while (j > 0 && j < nums2.length && nums2[j] == nums2[j - 1]) {
                j ++; 
            } 
            
            if (i >= nums1.length || j >= nums2.length) {
                break; 
            }
            
            if (nums1[i] == nums2[j]) {
                set.add(nums1[i]); 
                i ++; 
                j ++; 
            } else if (nums1[i] < nums2[j]) {
                i ++; 
            } else {
                j ++; 
            } 
        } 
        
        int index = -1; 
        int[] res = new int[set.size()]; 
        for (Integer num : set) {
            res[++ index] = num; 
        } 
        
        return res; 
    }
} 
