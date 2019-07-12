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
    private int maxPath;
    public int maxPathSum(TreeNode root) {
        this.maxPath = Integer.MIN_VALUE;
        findMaxPathSum(root);
        return this.maxPath;
    }
    
    private int findMaxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftPath = findMaxPathSum(root.left);
        int rightPath = findMaxPathSum(root.right);
        
        int path = Math.max(leftPath, 0) + Math.max(rightPath, 0) + root.val;
        this.maxPath = (path > maxPath) ? path : this.maxPath;
        
        return Math.max(Math.max(leftPath, rightPath), 0) + root.val;
    }
}