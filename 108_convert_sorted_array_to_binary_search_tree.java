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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        
        return arrayToBST(nums, 0, nums.length - 1);
    }
    
    private TreeNode arrayToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        
        if (start == end) {
            TreeNode node = new TreeNode(nums[start]);
            node.left = null;
            node.right = null;
            return node;
        }
        
        int mid = (start + end) / 2;
        TreeNode leftTree = arrayToBST(nums, start, mid - 1);
        TreeNode rightTree = arrayToBST(nums, mid + 1, end);
        TreeNode node = new TreeNode(nums[mid]);
        node.left = leftTree;
        node.right = rightTree;
        
        return node;
    }
}