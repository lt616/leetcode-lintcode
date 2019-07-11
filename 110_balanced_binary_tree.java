/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    boolean isBalanced;
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        
        isBalanced = true;
        getDepthTree(root);
        
        return isBalanced;
    }
    
    private int getDepthTree(TreeNode root) {
        if (root == null)
            return 0;
        
        int leftDepth = getDepthTree(root.left);
        int rightDepth = getDepthTree(root.right);
        
        if (Math.abs(leftDepth - rightDepth) > 1) isBalanced = false;
        
        return (leftDepth > rightDepth) ? leftDepth + 1 : rightDepth + 1;
    }
}