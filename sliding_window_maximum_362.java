/* 
362. Sliding Window Maximum

Given an array of n integer with duplicate number, and a moving window(size k), move the window at each iteration from the start of the array, find the maximum number inside the window at each moving.
Example

For array [1, 2, 7, 7, 8], moving window size k = 3. return [7, 7, 8]

At first the window is at the start of the array like this

[|1, 2, 7| ,7, 8] , return the maximum 7;

then the window move one step forward.

[1, |2, 7 ,7|, 8], return the maximum 7;

then the window move one step forward again.

[1, 2, |7, 7, 8|], return the maximum 8;
Challenge

o(n) time and O(k) memory
*/ 

/* 
	EASY WRONG POINTS: 
		1. Deque 
		2. 2 7 6 4 4 2 3 8 7 9 2 8 && k == 4 
		   2 7 7 7 6 4 4 8 8 9 9 9 
*/ 

public class Solution {
    /**
     * @param nums: A list of integers.
     * @param k: An integer
     * @return: The maximum number inside the window at each moving.
     */
    public List<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here 
        
        List<Integer> res = new ArrayList(); 
        
        if (nums == null || nums.length == 0) {
            return res;   
        } 
        
        Deque<Integer> dq = new ArrayDeque(); 
        
        for (int i = 0;i < min(k, nums.length);i ++) {
            inQueue(dq, nums[i]); 
        } 
        res.add(dq.peekFirst()); 
        
        for (int i = k;i < nums.length;i ++) {
            outQueue(dq, nums[i - k]); 
            inQueue(dq, nums[i]); 
            
            res.add(dq.peekFirst());
        } 
        
        return res; 
    } 
    
    private void inQueue(Deque<Integer> dq, int num) {
        while (! dq.isEmpty() && dq.peekLast() < num) {
            dq.pollLast(); 
        } 
        
        dq.offer(num); 
    } 
    
    private void outQueue(Deque<Integer> dq, int num) {
        if (! dq.isEmpty() && dq.peekFirst() == num) {
            dq.pollFirst(); 
        } 
    } 
    
    private int min(int a, int b) {
        return (a < b) ? a : b; 
    }
} 
