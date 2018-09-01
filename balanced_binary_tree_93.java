/* 
93. Balanced Binary Tree

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
Example

Given binary tree A = {3,9,20,#,#,15,7}, B = {3,#,20,15,7}

A)  3            B)    3 
   / \                  \
  9  20                 20
    /  \                / \
   15   7              15  7

The binary tree A is a height-balanced binary tree, but B is not.
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
 */

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */ 
    
    boolean is_valid = true; 
    
    public boolean isBalanced(TreeNode root) {
        // write your code here 
        
        if (root == null) {
            return true; // ?? 
        } 
        
        validateBalancedDFS(root); 
        
        return is_valid; 
    } 
    
    private int validateBalancedDFS(TreeNode node) {
        if (node == null) { 
            return 0; 
        } 
        
        int left_depth = validateBalancedDFS(node.left); 
        int right_depth = validateBalancedDFS(node.right); 
        
        is_valid = (is_valid && (Math.abs(left_depth - right_depth) <= 1)); 
        
        return (left_depth < right_depth) ? right_depth + 1 : left_depth + 1; 
    }
} 
