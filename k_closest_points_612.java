/* 
612. K Closest Points

Given some points and a point origin in two dimensional space, find k points out of the some points which are nearest to origin.
Return these points sorted by distance, if they are same with distance, sorted by x-axis, otherwise sorted by y-axis.
Example

Given points = [[4,6],[4,7],[4,4],[2,5],[1,1]], origin = [0, 0], k = 3
return [[1,1],[2,5],[4,4]]
*/ 

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * } * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */ 


/* Solution 01: priority queue */ 
class Node {
    double dist; 
    Point pos; 
    
    public Node(Point pos, Point origin) {
        this.pos = pos; 
        int diff_x = pos.x - origin.x; 
        int diff_y = pos.y - origin.y; 
        this.dist = Math.sqrt(diff_x * diff_x + diff_y * diff_y); 
    } 
} 

public class Solution {
    /**
     * @param points: a list of points
     * @param origin: a point
     * @param k: An integer
     * @return: the k closest points
     */
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // write your code here 
        
        Point[] res = new Point[k]; 
        
        if (points == null || points.length == 0) {
            return res; 
        } 

        Queue<Node> dist_pq = new PriorityQueue(new Comparator<Node>() {
            public int compare(Node n1, Node n2) {
                if (n1.dist == n2.dist) {
                    if (n1.pos.x == n2.pos.x) {
                        return n1.pos.y - n2.pos.y; 
                    } 
                    
                    return n1.pos.x - n2.pos.x; 
                } else if (n1.dist < n2.dist) {
                    return -1; 
                } else {
                    return 1; 
                } 
            } 
        });  
        
        for (int i = 0;i < points.length;i ++) {
            dist_pq.offer(new Node(points[i], origin)); 
        } 
        
        for (int i = 0;i < k;i ++) {
            res[i] = dist_pq.poll().pos; 
        } 
        
        return res; 
    }
} 


/* Solution 02: heapify */ 
/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * } * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */ 

public class Solution {
    /**
     * @param points: a list of points
     * @param origin: a point
     * @param k: An integer
     * @return: the k closest points
     */ 
    
    int size; 
    Point ori; 
    
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // write your code here 
        
        Point[] res = new Point[k]; 
        
        if (points == null || points.length == 0) {
            return res; 
        } 
        
        ori = origin; 
        size = points.length; 
        
        heapify(points); 
        
        int last_index = points.length; 
        for (int i = 0;i < k;i ++) {
            res[i] = points[0]; 
            swap(points, 0, -- last_index); 
            size --; 

            shiftDown(points, 0); 
        }

        return res; 
    } 
    
    private void heapify(Point[] points) { 
        for (int i = points.length / 2;i >=0;i --) {
            shiftDown(points, i); 
        }  

    } 
    
    private void shiftDown(Point[] points, int index) { 
        while (index < size) {
            int left = index * 2 + 1; 
            int right = index * 2 + 2; 
            
            Point min = points[index]; 
            int min_index = index; 
            if (left < size && comparePoints(points[left], points[min_index])) {
                min = points[left]; 
                min_index = left; 
            } 
            
            if (right < size && comparePoints(points[right], points[min_index])) {
                min = points[right]; 
                min_index = right; 
            } 
            
            if (min_index != index) {
                swap(points, min_index, index); 
                index = min_index; 
            } else {
                break; 
            }
        } 
    } 
    
    private boolean comparePoints(Point a, Point b) {
        double dist_a = getDist(a); 
        double dist_b = getDist(b); 
        
        if (dist_a != dist_b) {
            return dist_a <= dist_b; 
        } 
        
        if (a.x != b.x) {
            return a.x <= b.x; 
        } 
        
        return a.y < b.y; 
    } 
    
    private double getDist(Point p) { 
        int diff_x = p.x - ori.x; 
        int diff_y = p.y - ori.y; 
        
        return Math.sqrt(diff_x * diff_x + diff_y * diff_y);  
    }
    
    private void swap(Point[] nums, int a, int b) {
        Point temp = nums[b]; 
        nums[b] = nums[a]; 
        nums[a] = temp; 
    }
} 
