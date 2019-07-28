class Pair {
    int key;
    int val;
    
    public Pair(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        
        PriorityQueue<Pair> intervalPQ = new PriorityQueue<>((a, b) -> a.key - b.key);
        for (int[] interval : intervals) {
            intervalPQ.offer(new Pair(interval[0], interval[1]));
        }
            
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Pair interval;
        while (!intervalPQ.isEmpty()) {
            interval = intervalPQ.poll();
            if (!pq.isEmpty() && pq.peek() <= interval.key) {
                pq.poll();
            }
            pq.offer(interval.val);
        }
        return pq.size();
    }
}