/* 
88. Lowest Common Ancestor of a Binary Tree

Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.

The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
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

Assume two nodes are exist in tree.
*/ 

/* Solution 01: find A, B by searching the tree then compare path */ 
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
     * @param A: A TreeNode in a Binary.
     * @param B: A TreeNode in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */ 
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here 
        
        List<TreeNode> A_path = new ArrayList(); 
        List<TreeNode> B_path = new ArrayList(); 
        
        searchNode(root, A, A_path); 
        searchNode(root, B, B_path); 

        Collections.reverse(A_path); 
        Collections.reverse(B_path); 
        
        int index = 0; 
        while (index < A_path.size() && index < B_path.size()) {
            if (A_path.get(index) != B_path.get(index)) {
                break; 
            } 
            index ++; 
        } 
        
        return A_path.get(index - 1);    
    } 
    
    private boolean searchNode(TreeNode node, TreeNode target, List<TreeNode> path) {
        if (node == null) {
            return false; 
        } 
        
        System.out.println(node.val); 
        
        if (node == target) { 
            path.add(node); 
            return true; 
        } 
        
        if (searchNode(node.left, target, path) || searchNode(node.right, target, path)) {
            path.add(node); 
            return true; 
        } 
        
        return false; 
    }
} 


/* Solution 02: divide && conquer */ 
public class Solution {
    // 在root为根的二叉树中找A,B的LCA:
    // 如果找到了就返回这个LCA
    // 如果只碰到A，就返回A
    // 如果只碰到B，就返回B
    // 如果都没有，就返回null
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null || root == node1 || root == node2) {
            return root;
        }
        
        // Divide
        TreeNode left = lowestCommonAncestor(root.left, node1, node2);
        TreeNode right = lowestCommonAncestor(root.right, node1, node2);
        
        // Conquer
        if (left != null && right != null) {
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
