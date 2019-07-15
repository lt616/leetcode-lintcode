/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        ListNode start = new ListNode(-1);
        ListNode current = start;
        
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>(){
            public int compare(ListNode n1, ListNode n2) {
                return n1.val - n2.val;
            }
        });
        
        for (int i = 0; i < lists.length; i++)
            if (lists[i] != null) queue.add(lists[i]);
        
        while (! queue.isEmpty()) {
            ListNode node = queue.poll();
            current.next = node;
            current = node;
            
            if (node.next != null)
                queue.add(node.next);
        }
        
        return start.next;
    }
}