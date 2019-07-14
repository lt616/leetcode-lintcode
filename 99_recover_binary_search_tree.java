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
    private TreeNode firstWrong;
    private TreeNode secondWrong;
    private TreeNode prev;
    public void recoverTree(TreeNode root) {
        prev = new TreeNode(Integer.MIN_VALUE);
        findWrongTree(root);
        
        int temp = firstWrong.val;
        firstWrong.val = secondWrong.val;
        secondWrong.val = temp;
    }
    
    private void findWrongTree(TreeNode node) {
        if (node == null)
            return;
        
        findWrongTree(node.left);
        if (prev.val > node.val) {
            if (firstWrong == null) {
                firstWrong = prev;
                secondWrong = node;
            } else {
                secondWrong = node;
            }
        }
        prev = node;
        
        findWrongTree(node.right);
    }
}