/* 
614. Binary Tree Longest Consecutive Sequence II

Given a binary tree, find the length of the longest consecutive sequence path.
The path could be start and end at any node in the tree
Example

    1
   / \
  2   0
 /
3

Return 4 // 0-1-2-3
*/ 

/* 
	EASY WRONG POINTS: 
		1. Compared with the first verison, check up & down simultaneously and 
		get the total consecutive length by up + 1 + down. 
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

class PathTreeNode {
    TreeNode node; 
    int[] path_nums; 
    boolean[] is_ascend; 
    
    PathTreeNode left; 
    PathTreeNode right; 
    
    public PathTreeNode(TreeNode node) {
        this.node = node; 
        this.path_nums = new int[3]; 
        this.is_ascend = new boolean[3]; 
        this.left = null; 
        this.right = null; 
    } 
} 

public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the length of the longest consecutive sequence path
     */ 
    
    int max_len = Integer.MIN_VALUE; 
    
    public int longestConsecutive2(TreeNode root) {
        // write your code here 
        
        if (root == null) {
            return 0; 
        } 

        findMaxPath(root); 
        
        return max_len; 
    } 
    
    private int[] findMaxPath(TreeNode node) { 
        int[] res = new int[3]; 
        
        int[] left_res, right_res; 
        int down = 0, up = 0; 
        if (node.left != null) {
            left_res = findMaxPath(node.left); 
            if (left_res[0] + 1 == node.val) {
                up = left_res[1] + 1; 
            } else if (node.val + 1 == left_res[0]) {
                down = left_res[2] + 1; 
            } 
        } 
        
        if (node.right != null) {
            right_res = findMaxPath(node.right); 
            if (right_res[0] + 1 == node.val) {
                up = (right_res[1] + 1 > up) ? right_res[1] + 1 : up; 
            } else if (node.val + 1 == right_res[0]) {
                down = (right_res[2] + 1 > down) ? right_res[2] + 1 : down; 
            } 
        } 
        
        int max = up + 1 + down; 
        res[0] = node.val; 
        res[1] = up; 
        res[2] = down; 
        
        max_len = (max > max_len) ? max : max_len; 
        
        return res; 
    }
} 
