/* 
95. Validate Binary Search Tree

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.
    A single node tree is a BST

Example

An example:

  2
 / \
1   4
   / \
  3   5

The above binary tree is serialized as {2,1,4,#,#,3,5} (in level order).
*/ 

/* Solution 01: DFS || Divide & Conquer */ 
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
     * @return: True if the binary tree is BST, or false
     */ 
    
    boolean isValid = true; 
    
    public boolean isValidBST(TreeNode root) {
        // write your code hereasdasdasd 
        
        if (root == null) 
            return isValid;  
        
        DFSValidBST(root); 
        
        return isValid; 
    } 
    
    private int[] DFSValidBST(TreeNode node) { 
        int[] min_max = new int[2]; 
        
        if (node.left == null) {
            min_max[0] = node.val; 
        } else {
            int[] left_res = DFSValidBST(node.left); 
            isValid = isValid && (left_res[1] < node.val); 
            min_max[0] = left_res[0];  
        }
        
        if (node.right == null) {
            min_max[1] = node.val; 
        } else {
            int[] right_res = DFSValidBST(node.right); 
            isValid = isValid && (right_res[0] > node.val); 
            min_max[1] = right_res[1]; 
        } 
        
        return min_max; 
    }
} 

/* Solution 02: traversal */ 
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
     * @return: True if the binary tree is BST, or false
     */ 
    
    boolean isValid = true; 
    public int cur; 
    public boolean isFirst = true; 
    
    public boolean isValidBST(TreeNode root) {
        // write your code hereasdasdasd 
        
        if (root == null) 
            return isValid; 
        
        checkIsValidBST(root); 
        
        return isValid; 
    } 
    
    private void checkIsValidBST(TreeNode node) { 
        
        if (node.left != null) {
            checkIsValidBST(node.left); 
        } 
        
        if (! isFirst) {
            isValid = isValid && (cur < node.val); 
        } else {
            isFirst = false; 
        } 
        cur = node.val; 
        
        if (node.right != null) {
            checkIsValidBST(node.right); 
        } 
    }

} 
