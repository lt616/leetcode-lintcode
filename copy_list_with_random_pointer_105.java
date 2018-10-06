/* 
105. Copy List with Random Pointer

A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
Challenge

Could you solve it with O(1) space?
*/ 

/* 
	EASY WRONG POINTS: 
		1. 1 -> 2 -> 3 
		=> 1 -> 1' -> 2 -> 2' -> 3 -> 3' (copy next)
		=> 1 -> 2 -> 3 (copy random) 
*/ 

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null; 
        } 
        
        RandomListNode current = head; 
        while (current != null) { 
            RandomListNode new_node = new RandomListNode(current.label); 
            new_node.next = current.next; 
            current.next = new_node; 
            current = new_node.next; 
        } 
        
        current = head; 
        RandomListNode new_head = head.next; 
        while (current != null) { 
            current.next.random = (current.random == null) ? null : current.random.next; 
            current = current.next.next; 
        } 
        
        current = head; 
        while (current != null) {
            RandomListNode temp = current.next; 
            current.next = current.next.next; 
            temp.next = (temp.next == null) ? null : temp.next.next; 
            current = current.next; 
        } 
        return new_head; 
    } 
} 
