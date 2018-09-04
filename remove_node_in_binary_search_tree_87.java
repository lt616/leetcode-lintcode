/* 
87. Remove Node in Binary Search Tree

Given a root of Binary Search Tree with unique value for each node. Remove the node with given value. If there is no such a node with given value in the binary search tree, do nothing. You should keep the tree still a binary search tree after removal.
Example

Given binary search tree:

    5
   / \
  3   6
 / \
2   4

Remove 3, you can either return:

    5
   / \
  2   6
   \
    4

or

    5
   / \
  4   6
 /
2
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
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */ 
    
    TreeNode res; 
    
    public TreeNode removeNode(TreeNode root, int value) {
        // write your code here 
        
        if (root == null) {
            return null; 
        } 
        
        res = root; 
        removeNodeDFS(root, null, value); 
        
        return res;  
    } 
    
    private void removeNodeDFS(TreeNode node, TreeNode parent, int value) {
        if (node == null) {
            return; 
        } 
        
        if (node.val != value) {
            removeNodeDFS(node.left, node, value); 
            removeNodeDFS(node.right, node, value); 
            
            return; 
        } 
        
        TreeNode new_node = null;
        if (node.left == null) {
            new_node = node.right; 
        } else if (node.right == null) {
            new_node = node.left; 
        } else {
            TreeNode temp = node.left; 
            while (temp.right != null) {
                temp = temp.right; 
            } 
            temp.right = node.right; 
            new_node = node.left; 
        } 
        
        if (parent == null) {
            res = new_node; 
            return; 
        }
        
        if (parent.left == node) {
            parent.left = new_node; 
        } else {
            parent.right = new_node; 
        }
    }
} 
