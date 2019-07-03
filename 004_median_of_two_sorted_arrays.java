/* Solution 01: Brute force O(m + n) */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size = nums1.length + nums2.length;
        boolean isOdd = (size % 2 == 1);
        int medianSum = 0;
        int m = 0;
        int n = 0;
        for (int i = 0; i < size; i++) {
            int current;
            if (m >= nums1.length || (n < nums2.length && nums1[m] >= nums2[n])) {
                current = nums2[n];
                n ++;
            } else {
                current = nums1[m];
                m ++;
            }
            
            if (isOdd) {
                if (i == size / 2) {
                    medianSum += current;
                }
            } else {
                if (i == size / 2 || i == size / 2 - 1) {
                    medianSum += current;
                }
            }
        }
        
        double median = (double) medianSum;
        System.out.println(median);
        return (isOdd) ? median : median / 2;
    }
}

/* Solution 02: Binary search O(log(min(m, n))) */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0)
            return 0;
        
        if (nums1.length == 0) 
            return findMedianSingleArray(nums2);
        
        if (nums2.length == 0)
            return findMedianSingleArray(nums1);
        
        int start = 0;
        int end = nums1.length;
        int size = nums1.length + nums2.length;
        while (start + 1 < end) {
            int i = (start + end) / 2;
            int j = size / 2 - i;
            if (j < 0) {
                end = i;
                continue;
            }
            
            if (j >= nums2.length) {
                start = i;
                continue;
            }
            
            
            if (isMedian(nums1, nums2, i, j, size)) {
                return getMedian(nums1, nums2, i, j, size);
            } else {
                if (findLargerValue(nums1, nums2, i, j)) {
                    end = i;
                } else {
                    start = i;
                }
            }
        }
        
        /* if start is median */
        int i = start;
        int j = size / 2 - i;
        if (j >= 0) {
            if (isMedian(nums1, nums2, i, j, size)) 
                return getMedian(nums1, nums2, i, j, size);
        }
        
        /* if end is median */
        i = end;
        j = size / 2 - i;
        if (j >= 0) {
            if (isMedian(nums1, nums2, i, j, size)) 
                return getMedian(nums1, nums2, i, j, size);
        }
        
        return 0;
    }
    
    private boolean isMedian(int[] nums1, int[] nums2, int i, int j, int size) {
        int maxLeft = findValue(nums1, i - 1, nums2, j - 1, true);
        int minRight = findValue(nums1, i, nums2, j, false);
        return (maxLeft <= minRight);
    }
    
    private double getMedian(int[] nums1, int[] nums2, int i, int j, int size) {
        int maxLeft = findValue(nums1, i - 1, nums2, j - 1, true);
        int minRight = findValue(nums1, i, nums2, j, false);
        
        if (size % 2 == 1) {
            return (double) minRight;
        } else {
            return ((double) maxLeft + minRight) / 2;
        }
    }
    
    private double findMedianSingleArray(int[] nums) {
        int mid = nums.length / 2;
        if (nums.length % 2 == 1) {
            return (double) nums[mid];
        } else {
            return ((double) nums[mid - 1] + nums[mid]) / 2;
        }
    }
    
    private int findValue(int[] nums1, int i, int[] nums2, int j, boolean isMax) {
        if (i < 0 || i >= nums1.length) 
            return nums2[j];
        
        if (j < 0 || j >= nums2.length)
            return nums1[i];
        
        if (isMax) 
            return (nums1[i] > nums2[j]) ? nums1[i] : nums2[j];
        else
            return (nums1[i] < nums2[j]) ? nums1[i] : nums2[j];
    }
    
    private boolean findLargerValue(int[] nums1, int[] nums2, int i, int j) {
        if (i < 0 || i >= nums1.length) 
            return false;
        
        if (j < 0 || j >= nums2.length)
            return true;
        
        return (nums1[i] >= nums2[j]);
    }
    
    
}