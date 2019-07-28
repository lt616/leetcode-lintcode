class Pair {
    int key;
    int val;
    
    public Pair(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> skyline = new ArrayList<>();
        if (buildings == null || buildings.length == 0 || buildings[0].length == 0) {
            return skyline;
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2) {
                if (p1.key == p2.key) {
                    return p1.val - p2.val;
                }
                return p1.key - p2.key;
            }
        });
        
        for (int i = 0; i < buildings.length; i++) {
            pq.offer(new Pair(buildings[i][0], -buildings[i][2]));
            pq.offer(new Pair(buildings[i][1], buildings[i][2]));
        }
        
        PriorityQueue<Integer> skylinePQ = new PriorityQueue<>((a, b) -> b - a);
        skylinePQ.offer(0);
        int pre = -1;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            if (p.val < 0) {
                skylinePQ.offer(-p.val);
            } else {
                skylinePQ.remove(p.val);
            }
            
            if (pre != skylinePQ.peek()) {
                pre = skylinePQ.peek();
                skyline.add(new ArrayList(Arrays.asList(p.key, skylinePQ.peek())));
            }
        }
                            
        return skyline;
    }
}