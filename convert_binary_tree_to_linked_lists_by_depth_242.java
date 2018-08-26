/* 
242. Convert Binary Tree to Linked Lists by Depth

Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
Example

Given binary tree:

    1
   / \
  2   3
 /
4

return

[
  1->null,
  2->3->null,
  4->null
]
*/ 

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */ 


public class Solution {
    /**
     * @param root the root of binary tree
     * @return a lists of linked list
     */
    public List<ListNode> binaryTreeToLists(TreeNode root) {
        // Write your code here 
        

        
        List<ListNode> res = new ArrayList(); 
        if (root == null) {
            return res;     
        } 
        
        Queue<TreeNode> queue = new LinkedList(); 
        queue.add(root); 
        
        while (! queue.isEmpty()) {
            int level_size = queue.size(); 
            ListNode pre_node = null; 
            for (int i = 0;i < level_size;i ++) {
                TreeNode current = queue.poll(); 
                ListNode node = new ListNode(current.val); 
                if (i == 0) { 
                    res.add(node); 
                    pre_node = node; 
                } else {
                    pre_node.next = node; 
                    pre_node = node; 
                }
                
                if (current.left != null) {
                    queue.offer(current.left); 
                } 
                
                if (current.right != null) {
                    queue.offer(current.right); 
                }
            }
        } 
        
        return res; 
    }
} 
