class DataStream {
    Queue<Integer> max_heap; 
    Queue<Integer> min_heap; 
    
    public DataStream() {
        max_heap = new PriorityQueue(); 
        min_heap = new PriorityQueue(new Comparator<Integer> () {
                        public int compare(Integer a, Integer b) {
                            return b - a;
                        }
                    });
    } 
    
    public void add(int num) {
        if (max_heap.size() == 0) {
            max_heap.offer(num);
            return; 
        } 
        
        if (min_heap.size() == 0) {
            if (num <= max_heap.peek()) {
                min_heap.offer(num); 
            } else {
                min_heap.offer(max_heap.poll()); 
                max_heap.offer(num); 
            } 
            return; 
        } 
        
        int min = min_heap.peek(), max = max_heap.peek(); 
        if (num > max) {
            max_heap.offer(num);  
        } else {
            min_heap.offer(num); 
        } 
        
        if (min_heap.size() - max_heap.size() == 2) {
            max_heap.offer(min_heap.poll()); 
        } else if (max_heap.size() - min_heap.size() == 2) {
            min_heap.offer(max_heap.poll()); 
        } 
    } 
    
    public int getMedian() {
        if (max_heap.size() > min_heap.size()) {
            return max_heap.peek(); 
        } else {
            return min_heap.peek(); 
        }
    }
}


public class Solution {
    /**
     * @param nums: A list of integers
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        // write your code here 
        
        if (nums == null || nums.length == 0) {
            return new int[0]; 
        } 
        
        DataStream ds = new DataStream(); 
        
        int[] res = new int[nums.length]; 
        for (int i = 0;i < nums.length;i ++) {
            ds.add(nums[i]); 
            res[i] = ds.getMedian(); 
        } 
        
        return res; 
    }
} 
