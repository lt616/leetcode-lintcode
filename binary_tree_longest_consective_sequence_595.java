/* 
595. Binary Tree Longest Consecutive Sequence

Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).
Example

For example,

   1
    \
     3
    / \
   2   4
        \
         5

Longest consecutive sequence path is 3-4-5, so return 3.

   2
    \
     3
    / 
   2    
  / 
 1

Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
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
     * @return: the length of the longest consecutive sequence path
     */ 
    
    int res = 0; 
    
    public int longestConsecutive(TreeNode root) {
        // write your code here 
        
        if (root == null) {
            return 0; 
        } 
        
        findLongestPathDFS(root, 0, 0); 
        
        return res; 
    } 
    
    private void findLongestPathDFS(TreeNode root, int path_len, int parent) {
        if (root == null) {
            res = (path_len > res) ? path_len : res; 
            return; 
        } 
        
        /* If not the first one */ 
        if (path_len != 0 && (parent + 1) != root.val) {    
            
            res = (path_len > res) ? path_len : res; 
                
            /* Start from 1 */ 
            path_len = 1; 
        } else {
            path_len ++; 
        } 
        
        parent = root.val; 
        findLongestPathDFS(root.left, path_len, parent); 
        findLongestPathDFS(root.right, path_len, parent); 
    }
} 
