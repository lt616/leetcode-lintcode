/* 
85. Insert Node in a Binary Search Tree

Given a binary search tree and a new tree node, insert the node into the tree. You should keep the tree still be a valid binary search tree.
Example

Given binary search tree as follow, after Insert node 6, the tree should be:

  2             2
 / \           / \
1   4   -->   1   4
   /             / \ 
  3             3   6

Challenge

Can you do it without recursion?
Notice

You can assume there is no duplicate values in this tree + node.
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
    /*
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here 
        
        if (root == null) { 
            return node; 
        } 
        
        TreeNode pre = root; 
        TreeNode current = root; 
        while (true) {
            if (current.val < node.val) { 
                if (current.right == null) {
                    current.right = node; 
                    return root; 
                } 
                current = current.right; 
            } else if (current.val > node.val) {
                if (current.left == null) {
                    current.left = node; 
                    return root; 
                } 
                current = current.left; 
            } 
        } 
    }
} 
