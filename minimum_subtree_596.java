/* 
596. Minimum Subtree

Given a binary tree, find the subtree with minimum sum. Return the root of the subtree.
Example

Given a binary tree:

     1
   /   \
 -5     2
 / \   /  \
0   2 -4  -5 

return the node 1.
Notice

LintCode will print the subtree which root is your return node.
It's guaranteed that there is only one subtree with minimum sum and the given binary tree is not an empty tree.
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
     * @param root: the root of binary tree
     * @return: the root of the minimum subtree
     */ 
    
    public TreeNode min_node = null;  
    public int min_node_val = Integer.MAX_VALUE; 
    
    public TreeNode findSubtree(TreeNode root) {
        // write your code here 
        
        findMinSubtreeSum(root); 
        
        return min_node; 
    } 
    
    private int findMinSubtreeSum(TreeNode node) { 
        if (node == null) {
            return 0; 
        } 
        
        int sum = findMinSubtreeSum(node.left) + findMinSubtreeSum(node.right) + node.val; 
        if (sum < min_node_val) {
            min_node = node; 
            min_node_val = sum; 
        } 
        
        return sum; 
    }
}
