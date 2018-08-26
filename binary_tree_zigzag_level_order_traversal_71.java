/* 
71. Binary Tree Zigzag Level Order Traversal

Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
Example

Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7

 

return its zigzag level order traversal as:

[
  [3],
  [20,9],
  [15,7]
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
     * @param root: A Tree
     * @return: A list of lists of integer include the zigzag level order traversal of its nodes' values.
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here 
        
        List<List<Integer>> res = new ArrayList(); 
        
        if (root == null) {
            return res; 
        } 
        
        Queue<TreeNode> queue = new LinkedList();  
        queue.add(root); 
        
        int count = 0; 
        while (! queue.isEmpty()) {
            List<Integer> new_level = new ArrayList(); 
            int level_size = queue.size(); 
            for (int i = 0;i < level_size;i ++) {
                TreeNode current = queue.poll(); 
                new_level.add(current.val); 
                
                if (current.left != null) {
                    queue.offer(current.left); 
                } 
                
                if (current.right != null) {
                    queue.offer(current.right); 
                } 
            } 
            
            if (count % 2 == 1) {
                Collections.reverse(new_level); 
            } 
            
            res.add(new_level); 
            count ++; 
        } 
        
        return res; 
    }
} 
