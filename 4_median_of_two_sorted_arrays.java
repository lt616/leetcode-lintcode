/* 
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0

Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
*/ 

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size = nums1.length + nums2.length; 
        int first, second; 
        if (size % 2 == 0) {
            first = size / 2 - 1; 
            second = size / 2; 
        } else {
            first = size / 2; 
            second = -1; 
        } 
        
        int sum = 0, i = 0, j = 0, index = -1; 
        while (i < nums1.length || j < nums2.length) {
            int num; 
            if (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    num = nums1[i]; 
                    i ++; 
                } else {
                    num = nums2[j]; 
                    j ++; 
                } 
            } else {
                if (i < nums1.length) {
                    num = nums1[i]; 
                    i ++; 
                } else {
                    num = nums2[j]; 
                    j ++; 
                }
            }
            
            if (++ index == first || index == second) {
                sum += num; 
            }
        } 
        
        return (second == -1) ? (double) sum : (double) sum / 2;  
    }
} 
