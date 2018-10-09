/* 
Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL

Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?
*/ 

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution { 
    ListNode new_head; 
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null; 
        } 
        
        new_head = null; 
        reverseListRecursive(head).next = null; 
        
        return new_head; 
    } 
    
    private ListNode reverseListRecursive(ListNode node) {
        if (node.next == null) { 
            new_head = node; 
            return node; 
        } 
        
        reverseListRecursive(node.next).next = node; 
        return node; 
    }
} 
