class RecentCounter {
    private Queue<Integer> requestQueue;
    public RecentCounter() {
        this.requestQueue = new LinkedList<>();
    }
    
    public int ping(int t) {
        this.requestQueue.add(t);
        while (! this.requestQueue.isEmpty() && this.requestQueue.peek() < t - 3000)
            this.requestQueue.poll();
        return this.requestQueue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */