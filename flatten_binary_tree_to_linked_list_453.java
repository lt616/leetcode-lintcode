/* 
453. Flatten Binary Tree to Linked List

Flatten a binary tree to a fake "linked list" in pre-order traversal.

Here we use the right pointer in TreeNode as the next pointer in ListNode.
Example

              1
               \
     1          2
    / \          \
   2   5    =>    3
  / \   \          \
 3   4   6          4
                     \
                      5
                       \
                        6

Challenge

Do it in-place without any extra memory.
Notice

Don't forget to mark the left child of each node to null. Or you will get Time Limit Exceeded or Memory Limit Exceeded.
*/ 


/* 
    EASY WRONG POINTS: 
        1. When manipluating left subtree, right subtree of current node is removed, 
        therefore have to save right subtree first. 
*/ 


/* Solution 01: recursion */ 
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
 */

public class Solution {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */ 
    
    TreeNode last = null; 
    
    public void flatten(TreeNode root) {
        // write your code here 
        
        if (root == null) {
            return;  
        }
        
        last = root; 
        TreeNode right = root.right; 
        flattenTreeDFS(root.left); 
        flattenTreeDFS(right);  
    } 
    
    private void flattenTreeDFS(TreeNode node) {
        if (node == null) {
            return; 
        } 
        
        last.left = null; 
        last.right = node; 
        last = node; 
        TreeNode right = node.right; 
        
        flattenTreeDFS(node.left);  
        flattenTreeDFS(right);  
    }
} 


