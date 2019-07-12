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
    Map<Integer, Integer> inorderDict;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length)
            return null;
        
        this.inorderDict = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            inorderDict.put(inorder[i], i);
        }
        
        return buildBinaryTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    
    private TreeNode buildBinaryTree(int[] preorder, int[] inorder, int preorderStart, int preorderEnd, int inorderStart, int inorderEnd) {
        if (preorderStart > preorderEnd)
            return null;
        
        TreeNode node = new TreeNode(preorder[preorderStart]);
        if (preorderStart == preorderEnd) {
            return node;
        }
        
        int midIndex = inorderDict.get(preorder[preorderStart]);
        if (midIndex > inorderStart) {
            int leftTreeLength = midIndex - inorderStart - 1;
            node.left = buildBinaryTree(preorder, inorder, preorderStart + 1, preorderStart + 1 + leftTreeLength, inorderStart, midIndex - 1);
        }
        
        if (midIndex < inorderEnd) {
            int rightTreeLength = inorderEnd - midIndex - 1;
            node.right = buildBinaryTree(preorder, inorder, preorderEnd - rightTreeLength, preorderEnd, midIndex + 1, inorderEnd);
        }
        
        return node;
    }
}