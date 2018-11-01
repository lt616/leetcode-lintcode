/* 
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2

Example 2:

Input: [[7,10],[2,4]]
Output: 1
*/ 

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0; 
        } 
        
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start; 
            } 
        }); 
        
        Queue<Integer> queue = new PriorityQueue<Integer>(); 
        queue.offer(intervals[0].end); 
        
        int max_size = 1, size = 1, i = 1; 
        while(i < intervals.length) { 
            if (queue.isEmpty() || intervals[i].start < queue.peek()) { 
                size ++; 
                max_size = Math.max(max_size, size); 
                queue.offer(intervals[i].end); 
                i ++; 
            } else {
                queue.poll(); 
                size --; 
            }
        }
        
        return max_size;  
    }
} 
