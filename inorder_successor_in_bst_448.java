/* 
448. Inorder Successor in BST

Given a binary search tree (See Definition) and a node in it, find the in-order successor of that node in the BST.

If the given node has no in-order successor in the tree, return null.
Example

Given tree = [2,1] and node = 1:

  2
 /
1

return node 2.

Given tree = [2,1,3] and node = 2:

  2
 / \
1   3

return node 3.
Challenge

O(h), where h is the height of the BST.
Notice

It's guaranteed p is one node in the given tree. (You can directly compare the memory address to find p)
*/ 

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */ 

/* Solution 01: Recursion */ 
public class Solution {
    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */ 
    
    boolean ifTarget = false; 
    TreeNode successor = null; 
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here 
        
        if (root == null || p == null) {
            return null; 
        } 
        
        /* Inorder traversal using recursion */ 
        inorderBST(root, p); 
        return successor; 
    } 
    
    private void inorderBST(TreeNode node, TreeNode p) { 
        if (node.left != null) {
            inorderBST(node.left, p); 
        } 
        
        if (ifTarget) { 
            successor = node; 
            ifTarget = false; 
        }
 
        if (node == p) { 
            ifTarget = true; 
        } 
        
        if (node.right != null) {
           inorderBST(node.right, p);  
        }  
    }
} 


/* Solution 01: non-recursion & stack */ 
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


public class Solution {
    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */ 
    
    boolean ifTarget = false; 
    TreeNode successor = null; 
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here 
        
        if (root == null || p == null) {
            return null; 
        } 
        
        Stack<TreeNode> stack = new Stack(); 
        
        /* Inorder traversal using BFS & stack */ 
        TreeNode node = root; 
        while (node != null) {
            stack.push(node); 
            node = node.left; 
        } 
        
        while (! stack.empty()) {
            TreeNode current = stack.pop(); 
            
            TreeNode current_right = current.right; 
            while (current_right != null) {
                stack.push(current_right); 
                current_right = current_right.left; 
            }
            
            if (current == p) {
                break; 
            } 
        } 
        
        if (stack.empty()) {
            return null; 
        } else {
            return stack.pop(); 
        } 
    } 
    

} 


