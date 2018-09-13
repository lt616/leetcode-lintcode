/* 
380. Intersection of Two Linked Lists

Write a program to find the node at which the intersection of two singly linked lists begins.
Example

The following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3

begin to intersect at node c1.
Challenge

Your code should preferably run in O(n) time and use only O(1) memory.
Notice

    If the two linked lists have no intersection at all, return null.
    The linked lists must retain their original structure after the function returns.
    You may assume there are no cycles anywhere in the entire linked structure.
*/ 

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;      
 *     }
 * }
 */

/* 
	EASY WRONG POINTS: 
		1. slow-fast pointers. 
		2. Step after confirmed that there is a cycle: set slow to start point, move slow & 
		fast in the same speed to get the crosspoint. 
*/ 

public class Solution {
    /*
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // write your code here 
        
        if (headA == null || headB == null) {
            return null; 
        } 
        
        ListNode last_A = headA; 
        while (last_A.next != null) {
            last_A = last_A.next; 
        }
        
        last_A.next = headB; 
        
        return detectLinkedListCycle(headA); 
    } 
    
    private ListNode detectLinkedListCycle(ListNode start) {
        ListNode fast = start.next, slow = start; 
        
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return null; 
            } 
            
            slow = slow.next; 
            fast = fast.next.next; 
        } 
        
        /* Now fast is cycle_len - 1 more steps than slow */ 
        fast = fast.next; 
        slow = start; 
        while (slow != fast) {
            slow = slow.next; 
            fast = fast.next; 
        } 
        
        return fast; 
    }
} 
