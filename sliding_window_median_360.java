/* 
360. Sliding Window Median

Given an array of n integer, and a moving window(size k), move the window at each iteration from the start of the array, find the median of the element inside the window at each moving. (If there are even numbers in the array, return the N/2-th number after sorting the element in the window. )
Example

For array [1,2,7,8,5], moving window size k = 3. return [2,7,7]

At first the window is at the start of the array like this

[ | 1,2,7 | ,8,5] , return the median 2;

then the window move one step forward.

[1, | 2,7,8 | ,5], return the median 7;

then the window move one step forward again.

[1,2, | 7,8,5 | ], return the median 7;
Challenge

O(nlog(n)) time
*/ 

public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: An integer
     * @return: The median of the element inside the window at each moving
     */
    public List<Integer> medianSlidingWindow(int[] nums, int k) {
        // write your code here 
        
        List<Integer> res = new ArrayList(); 
        
        if (nums == null || nums.length == 0) {
            return res; 
        } 
        
        Queue<Integer> small = new PriorityQueue(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b - a; 
            }
        }); 
        Queue<Integer> big = new PriorityQueue(); 
        
        for (int i = 0;i < min(nums.length, k);i ++) {
            small.offer(nums[i]); 
        } 
        
        for (int i = 0;i < min(nums.length, k) / 2;i ++) {
            int temp = small.poll(); 
            big.offer(temp); 
        } 
        int median = small.peek(); 
        res.add(median); 
        
        for (int i = k;i < nums.length;i ++) {
            int drop = nums[i - k]; 
            int add = nums[i]; 
            
            if (drop <= median && add <= median) { 
                small.remove(drop); 
                small.offer(add); 
            } else if (drop > median && add > median) { 
                big.remove(drop); 
                big.offer(add); 
            } else if (drop <= median && add > median) { 
                small.remove(drop); 
                big.offer(add); 
                small.offer(big.poll()); 
            } else { 
                big.remove(drop); 
                small.offer(add); 
                big.offer(small.poll()); 
            } 
            
            median = small.peek(); 
            res.add(median); 
        } 
        
        return res; 
    } 
    
    private int min(int a, int b) {
        return (a < b) ? a : b; 
    }
} 
