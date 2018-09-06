/* 
839. Merge Two Sorted Interval Lists

Merge two sorted (ascending) lists of interval and return it as a new sorted list. The new sorted list should be made by splicing together the intervals of the two lists and sorted in ascending order.
Example

Given list1 = [(1,2),(3,4)] and list2 = [(2,3),(5,6)], return [(1,4),(5,6)].
Notice

    The intervals in the given list do not overlap.
    The intervals in different lists may overlap.
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

public class Solution {
    /**
     * @param list1: one of the given list
     * @param list2: another list
     * @return: the new sorted list of interval
     */
    public List<Interval> mergeTwoInterval(List<Interval> list1, List<Interval> list2) {
        // write your code here 
        
        if (list1 == null || list1.size() == 0) {
            return list2; 
        } 
        
        if (list2 == null || list2.size() == 0) {
            return list1; 
        } 
        
        List<Interval> res = new ArrayList(); 
        
        int i = 0, j = 0; 
        while (i < list1.size() && j < list2.size()) { 
            if ((list1.get(i).start < list2.get(j).start && list1.get(i).end < list2.get(i).end) || (list1.get(i).start < list2.get(j).start)) {
                res.add(list1.get(i ++)); 
            } else { 
                res.add(list2.get(j ++)); 
            } 
            mergeOverlap(res); 
        } 
        
        for (int m = i;m < list1.size();m ++) {
            res.add(list1.get(m)); 

            mergeOverlap(res); 
        } 
        
        for (int m = j;m < list2.size();m ++) {
            res.add(list2.get(m)); 

            mergeOverlap(res); 
        } 
        
        return res; 
    } 
    
    private void mergeOverlap(List<Interval> res) {
        if (res.size() < 2) {
            return; 
        } 
        
        Interval first = res.get(res.size() - 2); 
        Interval second = res.get(res.size() - 1); 
        
        if (first.end >= second.start) {
            res.remove(res.size() - 1); 
            res.remove(res.size() - 1); 
            
            res.add(new Interval(first.start, Math.max(second.end, first.end))); 
        }
    }
} 
