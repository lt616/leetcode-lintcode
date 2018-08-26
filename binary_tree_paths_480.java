/* 
480. Binary Tree Paths

Given a binary tree, return all root-to-leaf paths.
Example

Given the following binary tree:

   1
 /   \
2     3
 \
  5

All root-to-leaf paths are:

[
  "1->2->5",
  "1->3"
]
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
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */ 
    
    List<String> res = new ArrayList(); 
    List<Integer> buffer = new ArrayList(); 
    
    public List<String> binaryTreePaths(TreeNode root) {
        // write your code here 
        
        if (root == null) {
            return res; 
        } 
        
        searchPathDFS(root); 
        return res; 
    } 
    
    private void searchPathDFS(TreeNode node) { 
        
        buffer.add(node.val); 
        if (node.left == null && node.right == null) { 
            /* Print path into string */ 
            StringBuilder path = new StringBuilder(); 
            for (int i = 0;i < buffer.size() - 1;i ++) {
                path.append(buffer.get(i)); 
                path.append("->"); 
            } 
            path.append(buffer.get(buffer.size() - 1)); 
            res.add(path.toString()); 
        } 
        if (node.left != null) {
            searchPathDFS(node.left);            
        }
        if (node.right != null) {
            searchPathDFS(node.right);             
        } 
        buffer.remove(buffer.size() - 1);    
    }
} 
