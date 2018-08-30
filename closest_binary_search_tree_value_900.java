/* 
900. Closest Binary Search Tree Value

Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
Example

Given root = {1}, target = 4.428571, return 1.
Notice

    Given target value is a floating point.
    You are guaranteed to have only one unique value in the BST that is closest to the target.
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
     * @return: the value in the BST that is closest to the target
     */ 
    
    double min_diff = Double.MAX_VALUE;  
    int closet_v; 
    
    public int closestValue(TreeNode root, double target) {
        // write your code here 
        
        double diff = root.val - target; 
        if (diff == 0) {
            return root.val;
        } 
        
        if (Math.abs(diff) < min_diff) {
            min_diff = Math.abs(diff); 
            closet_v = root.val; 
        }
        
        
        if (diff < 0 && root.right != null) {
            closestValue(root.right, target); 
            
        } else if (diff > 0 && root.left != null) {
            closestValue(root.left, target); 
        } 
        
        return closet_v; 
    }
} 
