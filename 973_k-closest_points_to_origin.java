class Point {
    int[] pos;
    double distance;
    
    public Point(int[] pos) {
        this.pos = new int[2];
        this.pos[0] = pos[0];
        this.pos[1] = pos[1];
        
        distance = Math.sqrt(Math.pow(pos[0], 2) + Math.pow(pos[1], 2));
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        if (points == null || points.length == 0) {
            return new int[0][2];
        }
        
        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
            public int compare(Point p1, Point p2) {
                return (p1.distance > p2.distance) ? 1 : -1;
            }
        });
        
        for (int[] point : points) {
            pq.offer(new Point(point));
        }
        
        int[][] result = new int[K][2];
        for (int i = 0; i < K; i++) {
            result[i] = pq.poll().pos;
        }
        
        return result;
    }
}