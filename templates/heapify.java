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
