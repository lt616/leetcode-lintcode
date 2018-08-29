/* 11. Search Range in Binary Search Tree

Given a binary search tree and a range [k1, k2], return all elements in the given range.
Example

If k1 = 10 and k2 = 22, then your function should return [12, 20, 22].

    20
   /  \
  8   22
 / \
4   12
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

/* Solution 01: inorder traversal */ 
public class Solution {
    /**
     * @param root: param root: The root of the binary search tree
     * @param k1: An integer
     * @param k2: An integer
     * @return: return: Return all keys that k1<=key<=k2 in ascending order
     */ 
    
    List<Integer> res = new ArrayList(); 
    
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here 
        
        if (root == null) {
            return res; 
        } 
        
        inorderTraversal(root, k1, k2); 
        
        return res; 
    } 
    
    private void inorderTraversal(TreeNode root, int low_bound, int high_bound) {
        if (root == null) {
            return;  
        } 
        
        inorderTraversal(root.left, low_bound, high_bound); 
        
        if (low_bound <= root.val && root.val <= high_bound) {
            res.add(root.val); 
        } 
        
        inorderTraversal(root.right, low_bound, high_bound); 
    }
} 


/* Solution 02: binary search && recursion */ 
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
     * @param root: param root: The root of the binary search tree
     * @param k1: An integer
     * @param k2: An integer
     * @return: return: Return all keys that k1<=key<=k2 in ascending order
     */ 
    
    List<Integer> res = new ArrayList(); 
    
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here 
        
        if (root == null) {
            return res; 
        } 
        
        inorderTraversal(root, k1, k2); 
        
        return res; 
    } 
    
    private void inorderTraversal(TreeNode root, int low_bound, int high_bound) {
        if (root == null) {
            return;  
        } 
        
        inorderTraversal(root.left, low_bound, high_bound); 
        
        if (low_bound <= root.val && root.val <= high_bound) {
            res.add(root.val); 
        } 
        
        inorderTraversal(root.right, low_bound, high_bound); 
    }
}  
