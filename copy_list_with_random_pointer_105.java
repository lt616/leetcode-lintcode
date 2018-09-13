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
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here 
        
        if (head == null) {
            return null; 
        } 
        

        
        copyNext(head); 
        
        RandomListNode res = head.next; 
        copyRandom(head); 
        
        return res; 
    } 
    
    private void copyNext(RandomListNode node) {
        RandomListNode new_node = new RandomListNode(node.label); 
        
        RandomListNode next = node.next; 
        node.next = new_node; 
        new_node.next = next; 
        
        if (next != null) {
            copyNext(next); 
        } 
    } 
    
    private void copyRandom(RandomListNode node) {
        RandomListNode new_node = node.next; 
        RandomListNode next = new_node.next; 
        
        if (node.random == null) {
            new_node.random = null; 
        } else { 
            new_node.random = node.random.next; 
        } 
        
        if (next == null) {
            new_node.next = null; 
            return; 
        }
        
        new_node.next = next.next; 
        copyRandom(next); 
    }
} 
