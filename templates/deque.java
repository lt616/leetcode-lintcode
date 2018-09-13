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
