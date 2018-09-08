/* 
104. Merge K Sorted Lists

Merge k sorted linked lists and return it as one sorted list.

Analyze and describe its complexity.
Example

Given lists:

[
  2->4->null,
  null,
  -1->null
],

return -1->2->4->null.
*/ 

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 

public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */ 
    
    
    
    public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here 
        
        if (lists == null || lists.size() == 0) {
            return null; 
        }  
        
        Queue<ListNode> pq = new PriorityQueue(new Comparator<ListNode>() {
                                public int compare(ListNode n1, ListNode n2) {
                                    return n1.val - n2.val; 
                                }  
                            }); 
        
        for (ListNode one_list : lists) {
            if (one_list != null) {
                pq.offer(one_list); 
            } 
        } 
        
        ListNode res = new ListNode(0); 
        ListNode current = res; 
        while (! pq.isEmpty()) {
            ListNode next = pq.poll(); 
            current.next = next; 
            current = next; 
            
            next = next.next; 
            
            if (next != null) {
                pq.offer(next); 
            } 
        } 
        
        return res.next; 
    }
} 
