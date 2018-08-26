/* 
67. Binary Tree Inorder Traversal

Given a binary tree, return the inorder traversal of its nodes' values.
Example

Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3

 

return [1,3,2].
Challenge

Can you do it without recursion?
*/ 

/* 
	EASY WRONG POINTS: 
		1. First push the node and all its left nodes into stack, till the left 
		most node. Pop each element in the stack, store the value, and check if 
		there is a right subtree of current node. If there is one, repeat the 
		process: first all left nodes, then right ones. 
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

class Pair {
    TreeNode node; 
    boolean isSearched; 
    
    public Pair(TreeNode node, boolean isSearched) {
        this.node = node; 
        this.isSearched = isSearched; 
    }
}


public class Solution {
    /**
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // write your code here 
        
        List<Integer> res = new ArrayList(); 
        
        if (root == null) { 
            return null; 
        } 
        
        Stack<TreeNode> stack = new Stack(); 
        
        TreeNode node = root; 
        while (node != null) {
            stack.push(node); 
            node = node.left; 
        } 
        
        while (! stack.empty()) {
            TreeNode current = stack.pop(); 
            
            res.add(current.val); 
            
            if (current.right != null) {
                /* Push all left nodes of the right subtree into stack */ 
                node = current.right; 
                while (node != null) {
                    stack.push(node); 
                    node = node.left; 
                } 
            } 
        } 
        
        return res; 
    }
}



