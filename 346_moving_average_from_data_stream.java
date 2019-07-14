class MovingAverage {
    private int size;
    private Queue<Integer> queue;
    private int sum;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        this.sum = 0;
        this.queue = new LinkedList<Integer>();
    }
    
    public double next(int val) {
        this.queue.add(val);
        this.sum += val;
        
        if (this.queue.size() > this.size) {
            this.sum -= this.queue.poll();
        }
        
        return ((double) sum) / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */