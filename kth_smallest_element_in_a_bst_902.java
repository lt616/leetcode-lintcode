/* 
902. Kth Smallest Element in a BST

Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
Example

Given root = {1,#,2}, k = 2, return 2.
Challenge

What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
Notice

You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
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

class NewTreeNode {
    public int val; 
    public int rank; 
    public NewTreeNode left, right; 
    
    public NewTreeNode(int val, int rank) {
        this.val = val; 
        this.rank = rank; 
        this.left = this.right = null; 
    }
}

public class Solution {
    /**
     * @param root: the given BST
     * @param k: the given k
     * @return: the kth smallest element in BST
     */ 
    
    public int current_rank = 0; 
    public int res; 
    
    public int kthSmallest(TreeNode root, int k) {
        // write your code here 
    
        findkthSmallest(root, k); 
        
        return res;  
    } 
    
    private void findkthSmallest(TreeNode root, int k) { 
        if (root.left != null) {
            findkthSmallest(root.left, k); 
        } 
        
        if (++ current_rank == k) {
            res = root.val; 
            return; 
        } 
        
        if (root.right != null) {
            findkthSmallest(root.right, k); 
        } 
    }
} 

/* Solution 02: build new tree */ 
class NewTreeNode {
    public int val; 
    public int rank; 
    public NewTreeNode left, right; 
    
    public NewTreeNode(int val, int rank) {
        this.val = val; 
        this.rank = rank; 
        this.left = this.right = null; 
    }
}

public class Solution {
    /**
     * @param root: the given BST
     * @param k: the given k
     * @return: the kth smallest element in BST
     */ 
    
    public int current_rank = 0; 
    
    public int kthSmallest(TreeNode root, int k) {
        // write your code here 
        
        NewTreeNode new_root = buildNewTree(root); 
        
        return findkthSmallest(new_root, k); 
    } 
    
    private NewTreeNode buildNewTree(TreeNode root) {
        if (root == null) {
            return null; 
        } 
        
        NewTreeNode new_left = buildNewTree(root.left); 
        
        NewTreeNode new_node = new NewTreeNode(root.val, ++ current_rank); 

        NewTreeNode new_right = buildNewTree(root.right); 

        new_node.left = new_left; 
        new_node.right = new_right; 
        
        return new_node; 
    }
    
    private int findkthSmallest(NewTreeNode root, int k) { 
        if (root.rank == k) {
            return root.val; 
        } 
        
        if (root.rank < k) {
            return findkthSmallest(root.right, k); 
        } else {  
            return findkthSmallest(root.left, k); 
        } 
    }
} 
