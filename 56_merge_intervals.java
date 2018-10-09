/* 
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considerred overlapping.
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
    public List<Interval> merge(List<Interval> intervals) { 
        List<Interval> res = new ArrayList<Interval>(); 
        if (intervals == null) {
            return res; 
        } 
        
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start; 
            } 
        }); 
        
        for (int i = 0;i < intervals.size();i ++) { 
            if (i > 0 && intervals.get(i).start <= res.get(res.size() - 1).end) { 
                Interval last = res.get(res.size() - 1); 
                res.remove(res.size() - 1); 
                res.add(new Interval(last.start, Math.max(last.end, intervals.get(i).end))); 
            } else {
                res.add(intervals.get(i)); 
            }
        } 
        
        return res; 
    } 
} 
