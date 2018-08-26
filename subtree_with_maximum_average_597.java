/* 
597. Subtree with Maximum Average

Given a binary tree, find the subtree with maximum average. Return the root of the subtree.
Example

Given a binary tree:

     1
   /   \
 -5     11
 / \   /  \
1   2 4    -2 

return the node 11.
Notice

LintCode will print the subtree which root is your return node.
It's guaranteed that there is only one subtree with maximum average.
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

/* 
	EASY WRONG POINTS: 
		1. Double.MIN_VALUE is the smallest positive double, therefore the real 
		smallest double is Double.MAX_VALUE. 
*/ 

public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the root of the maximum average of subtree
     */ 
     
    public double max_aver =  - Double.MAX_VALUE; 
    public TreeNode max_node = null; 
    
    public TreeNode findSubtree2(TreeNode root) {
        // write your code here 
        
        if (root == null) 
            return null; 
        
        findMaxAverDFS(root); 
        
        return max_node; 
    } 
    
    private int[] findMaxAverDFS(TreeNode node) {
        int[] res = new int [2]; 
        
        /* Base case */ 
        if (node == null) {
            res[0] = 0; 
            res[1] = 0; 
            return res; 
        }
        
        int[] res_left = findMaxAverDFS(node.left); 
        int[] res_right = findMaxAverDFS(node.right); 
        
        res[0] = res_left[0] + res_right[0] + 1; 
        res[1] = res_left[1] + res_right[1] + node.val; 
        
        double aver = (double)res[1] / res[0]; 
        // System.out.println(aver + ", " + res[0] + ", " + res[1]);  
        if (aver > max_aver) {
            max_aver = aver; 
            max_node = node; 
        } 
        
        return res; 
        
    }
} 
