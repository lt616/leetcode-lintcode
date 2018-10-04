/* 
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*/ 

/* Solution 01: Linked list with dummy code */ 
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2; 
        } 
        
        if (l2 == null) {
            return l1; 
        } 
        
        int overflow = 0; 
        ListNode dummy = new ListNode(0); 
        ListNode current = dummy; 
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + overflow; 
            overflow = (sum > 9) ? 1 : 0; 
            ListNode new_node = new ListNode(sum % 10); 
            current.next = new_node; 
            
            current = current.next; 
            l1 = l1.next; 
            l2 = l2.next; 
        } 
        
        if (l1 != null) { 
            while (overflow == 1 && l1 != null) { 
                int sum = l1.val + overflow; 
                overflow = (sum > 9) ? 1 : 0; 
                ListNode new_node = new ListNode(sum % 10); 
                current.next = new_node; 
                
                current = current.next; 
                l1 = l1.next; 
            } 
            current.next = l1; 
        } 
        
        if (l2 != null) { 
            while (overflow == 1 && l2 != null) { 
                int sum = l2.val + overflow; 
                overflow = (sum > 9) ? 1 : 0; 
                ListNode new_node = new ListNode(sum % 10); 
                current.next = new_node; 
                
                current = current.next; 
                l2 = l2.next; 
            } 
            
            current.next = l2; 
        } 
        
        if (overflow == 1) {
            ListNode new_node = new ListNode(1); 
            current.next = new_node; 
        }
        
        return dummy.next; 
    }
} 


/* Solution 02: Linked list cleaned up */ 
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2; 
        } 
        
        if (l2 == null) {
            return l1; 
        } 
        
        int overflow = 0; 
        ListNode dummy = new ListNode(0); 
        ListNode current = dummy; 
        while (l1 != null || l2 != null) {
            int x = (l1 == null) ? 0 : l1.val; 
            int y = (l2 == null) ? 0 : l2.val; 
            int sum = x + y + overflow; 
            overflow = (sum > 9) ? 1 : 0; 
            
            ListNode new_node = new ListNode(sum % 10); 
            current.next = new_node; 
            current = new_node; 
            
            l1 = (l1 == null) ? null : l1.next; 
            l2 = (l2 == null) ? null : l2.next; 
        } 
        
        if (overflow == 1) {
            ListNode new_node = new ListNode(overflow); 
            current.next = new_node; 
        }
        
        return dummy.next; 
    }
} 
