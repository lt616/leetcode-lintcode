/* 
175. Invert Binary Tree

Invert a binary tree.
Example

  1         1
 / \       / \
2   3  => 3   2
   /       \
  4         4

Challenge

Do it in recursion is acceptable, can you do it without recursion?
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
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void invertBinaryTree(TreeNode root) {
        // write your code here 
        
        invertDFS(root); 
    } 
    
    private void invertDFS(TreeNode node) {
        
        /* Base case */ 
        if (node == null) {
            return; 
        } 
        
        invertDFS(node.left); 
        invertDFS(node.right); 
                
        TreeNode temp = node.left; 
        node.left = node.right; 
        node.right = temp; 

        return; 
    }
} 
