/* 
68. Binary Tree Postorder Traversal

Given a binary tree, return the postorder traversal of its nodes' values.
Example

Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3

 

return [3,2,1].
Challenge

Can you do it without recursion?
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
     * @param root: A Tree
     * @return: Postorder in ArrayList which contains node values.
     */ 
    
    List<Integer> res = new ArrayList(); 
    
    public List<Integer> postorderTraversal(TreeNode root) {
        // write your code here 
        
        if (root == null) {
            return null; 
        } 
        
        if (root.left != null) {
            postorderTraversal(root.left); 
        } 
        
        if (root.right != null) {
            postorderTraversal(root.right); 
        } 
        
        res.add(root.val); 
        
        return res; 
    }
} 


/* Solution 02: non-recusion */ 



