/* 
Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]

Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]

Note:

    Each element in the result should appear as many times as it shows in both arrays.
    The result can be in any order.

Follow up:

    What if the given array is already sorted? How would you optimize your algorithm?
    What if nums1's size is small compared to nums2's size? Which algorithm is better?
    What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
*/ 

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0]; 
        } 
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); 
        for (Integer num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1); 
        } 
        
        List<Integer> res = new ArrayList<Integer>(); 
        for (Integer num : nums2) {
            if (map.containsKey(num)) {
                res.add(num); 
                map.put(num, map.get(num) - 1); 
                if (map.get(num) == 0) {
                    map.remove(num); 
                } 
            } 
        } 
        
        int[] res_array = new int[res.size()]; 
        for (int i = 0;i < res.size();i ++) {
            res_array[i] = res.get(i); 
        } 
        
        return res_array; 
    }
} 
