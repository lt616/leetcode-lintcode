/* 
578. Lowest Common Ancestor III

Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.
The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
Return null if LCA does not exist.
Example

For the following binary tree:

  4
 / \
3   7
   / \
  5   6

LCA(3, 5) = 4

LCA(5, 6) = 7

LCA(6, 7) = 7
Notice

node A or node B may not exist in tree.
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

    TreeNode res = null; 

    /*
     * @param root: The root of the binary tree.
     * @param A: A TreeNode
     * @param B: A TreeNode
     * @return: Return the LCA of the two nodes.
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here 
        if (A == B) {
            return A; 
        } 
        
        if (root == null) {
            return null; 
        } 
        
        DFS(root, A, B); 
        
        return res; 
    } 
    
    private TreeNode DFS(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) { 
            //System.out.println(root.val); 
            return null; 
        } 
        TreeNode right = DFS(root.right, A, B); 
        TreeNode left = DFS(root.left, A, B); 
        
        if ((root == A && (left == B || right == B)) || (root == B && (left == A || right == A))) { 
            res = root; 
            return root; 
        } 
        
        if ((left == A && right == B) || (left == B && right == A)) {
            res = root; 

            return root; 
        } 
        
        if (root == A || root == B) {
            return root; 
        }
        
        if (left != null) {
            return left; 
        } 
        
        if (right != null) {
            return right; 
        } 
        
        return null;         
    }
} 
