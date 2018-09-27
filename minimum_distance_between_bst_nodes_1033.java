/* 
1033. Minimum Distance Between BST Nodes

Given a Binary Search Tree (BST) with the root node root, return the minimum difference between the values of any two different nodes in the tree.
Example

Input: root = {4,2,6,1,3,#,#}
Output: 1
Explanation:
Note that root is a TreeNode object, not an array.

The given tree {4,2,6,1,3,#,#} is represented by the following diagram:

          4
        /   \
      2      6
     / \    
    1   3  

while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also between node 3 and node 2.

Notice

1.The size of the BST will be between 2 and 100.
2.The BST is always valid, each node's value is an integer, and each node's value is different.
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
     * @param root: the root
     * @return: the minimum difference between the values of any two different nodes in the tree
     */ 
    
    int min_diff = Integer.MAX_VALUE; 
    int current = -1; 
    
    public int minDiffInBST(TreeNode root) {
        // Write your code here 
        
        if (root == null) {
            return 0; 
        } 
        
        findMinDiff(root); 
        
        return min_diff; 
    } 
    
    private void findMinDiff(TreeNode node) {
        if (node == null) {
            return; 
        } 
        
        findMinDiff(node.left); 
        
        if (current != -1) { 
            int diff = node.val - current; 
            min_diff = (diff < min_diff) ? diff : min_diff; 
        } 
        
        current = node.val; 
        
        findMinDiff(node.right); 
    }
} 
