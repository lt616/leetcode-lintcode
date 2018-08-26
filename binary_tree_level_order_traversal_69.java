/* 
69. Binary Tree Level Order Traversal

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
Example

Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7

 

return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]

Challenge

Challenge 1: Using only 1 queue to implement it.

Challenge 2: Use DFS algorithm to do it.
*/ 

/* Solution 01: BFS */ 
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


class Pair {
    int depth; 
    TreeNode node; 
    
    public Pair(int depth, TreeNode node) {
        this.depth = depth; 
        this.node = node; 
    } 
} 


public class Solution {
    /**
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here 
        List<List<Integer>> res = new ArrayList(); 
        
        if (root == null) {
            return res; 
        }
        
        Queue<Pair> queue = new LinkedList(); 
        queue.add(new Pair(0, root)); 
        
        while (! queue.isEmpty()) { 
            Pair current = queue.element(); 
            queue.remove(); 
            
            if (current.node.left != null) {
                queue.add(new Pair((current.depth + 1), current.node.left));                
            }

            if (current.node.right != null) {
                queue.add(new Pair((current.depth + 1), current.node.right)); 
            }
            
            if (res.size() > current.depth) {
                List<Integer> temp = res.get(current.depth); 
                temp.add(current.node.val); 
                res.set(current.depth, temp); 
            } else {
                List<Integer> new_level = new ArrayList();  
                new_level.add(current.node.val); 
                res.add(new_level); 
            } 
        } 
        
        return res; 
    }
} 


/* Solution 02: DFS */ 
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


class Pair {
    int depth; 
    TreeNode node; 
    
    public Pair(int depth, TreeNode node) {
        this.depth = depth; 
        this.node = node; 
    } 
} 


public class Solution {
    /**
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     */ 
    
    List<List<Integer>> res = new ArrayList(); 
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here 
        
        if (root == null) {
            return res; 
        }

        levelOrderTraversalDFS(root, 0); 
        
        return res; 
    } 
    
    private void levelOrderTraversalDFS(TreeNode node, int depth) { 
        
        if (res.size() > depth) {
            List<Integer> temp = res.get(depth); 
            temp.add(node.val); 
            res.set(depth, temp); 
        } else { 
            List<Integer> new_level = new ArrayList(); 
            new_level.add(node.val); 
            res.add(new_level); 
        } 
        
        if (node.left != null) {
            levelOrderTraversalDFS(node.left, depth + 1); 
        } 
        
        if (node.right != null) {
            levelOrderTraversalDFS(node.right, depth + 1); 
        } 
    }
} 
