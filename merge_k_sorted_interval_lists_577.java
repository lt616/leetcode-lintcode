/* 
577. Merge K Sorted Interval Lists

Merge K sorted interval lists into one sorted interval list. You need to merge overlapping intervals too.
Example

Given

[
  [(1,3),(4,7),(6,8)],
  [(1,2),(9,10)]
]

Return

[(1,3),(4,8),(9,10)]
*/ 

/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */ 

class Node {
    Interval i; 
    int list_index; 
    int inlist_index; 
    
    public Node(Interval i, int list_index, int inlist_index) {
        this.i = i; 
        this.list_index = list_index; 
        this.inlist_index = inlist_index; 
    } 
} 

public class Solution {
    /**
     * @param intervals: the given k sorted interval lists
     * @return:  the new sorted interval list
     */
    public List<Interval> mergeKSortedIntervalLists(List<List<Interval>> intervals) {
        // write your code here 
        
        if (intervals == null) {
            return null; 
        } 
        
        List<Interval> res = new ArrayList(); 
        Queue<Node> pq = new PriorityQueue(new Comparator<Node>() {
                            public int compare(Node n1, Node n2) {
                                return n1.i.start - n2.i.start; 
                            } 
                    }); 
                    
        for (int i = 0;i < intervals.size();i ++) {
            if (intervals.get(i).size() > 0) {
                pq.offer(new Node(intervals.get(i).get(0), i, 0)); 
            } 
        } 
        
        while (! pq.isEmpty()) {
            Node current = pq.poll(); 
            mergeIntervals(res, current.i); 
            
            if (current.inlist_index + 1 < intervals.get(current.list_index).size()) {
                pq.offer(new Node(intervals.get(current.list_index).get(current.inlist_index + 1), current.list_index, current.inlist_index + 1)); 
            } 
        } 
        
        return res; 
    } 
    
    private void mergeIntervals(List<Interval> intervals, Interval i) {
        if (intervals.size() == 0) {
            intervals.add(i); 
            return; 
        } 
        
        Interval last = intervals.get(intervals.size() - 1); 
        if (last.end >= i.start) {
            intervals.remove(intervals.size() - 1); 
            intervals.add(new Interval(last.start, max(last.end, i.end))); 
        } else {
            intervals.add(i); 
        }
        
        return; 
    } 
    
    private int max(int a, int b) {
        return (a > b) ? a : b; 
    }
} 
