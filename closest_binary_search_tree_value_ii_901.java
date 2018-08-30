/* 
901. Closest Binary Search Tree Value II

Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.
Example

Given root = {1}, target = 0.000000, k = 1, return [1].
Challenge

Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?
Notice

    Given target value is a floating point.
    You may assume k is always valid, that is: k ≤ total nodes.
    You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
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
     * @param root: the given BST
     * @param target: the given target
     * @param k: the given k
     * @return: k values in the BST that are closest to the target
     */
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        // write your code here 
      
        List<Integer> res = new ArrayList(); 
        
        Stack<Integer> smaller_values = new Stack(); 
        Stack<Integer> bigger_values = new Stack(); 
        
        inorderTraversal(root, target, smaller_values, false); 
        inorderTraversal(root, target, bigger_values, true); 
        
        while (k > 0) {
            if (smaller_values.isEmpty()) {
                res.add(bigger_values.pop()); 
            } else if (bigger_values.isEmpty()) {
                res.add(smaller_values.pop()); 
            } else {
                if ((target - smaller_values.peek()) < (bigger_values.peek() - target)) {
                    res.add(smaller_values.pop()); 
                } else {
                    res.add(bigger_values.pop()); 
                }
            } 
            
            k --; 
        } 
        
        return res; 
    } 
    
    private void inorderTraversal(TreeNode root, double target, Stack<Integer> buffer, boolean is_reverse) {
        if (root == null) {
            return; 
        } 
        
        TreeNode next = (is_reverse) ? root.right : root.left; 
        inorderTraversal(next, target, buffer, is_reverse); 
        
        if ((! is_reverse && root.val > target) || (is_reverse && root.val <= target)) {
            return; 
        } 
        
        buffer.push(root.val); 
        
        next = (is_reverse) ? root.left : root.right;  
        inorderTraversal(next, target, buffer, is_reverse); 
    } 
} 
