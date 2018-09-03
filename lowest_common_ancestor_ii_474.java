/* 
474. Lowest Common Ancestor II

Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.

The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.

The node has an extra attribute parent which point to the father of itself. The root's parent is null.
Example

For the following binary tree:

  4
 / \
3   7
   / \
  5   6

LCA(3, 5) = 4

LCA(5, 6) = 7

LCA(6, 7) = 7
*/ 

/**
 * Definition of ParentTreeNode:
 * 
 * class ParentTreeNode {
 *     public ParentTreeNode parent, left, right;
 * }
 */

/* 
	EASY WRONG POINTS: 
		1. Be careful with the bound of array, starting point & endng point. 
		2. Sepecial case: A == B. 
*/ 

public class Solution {
    /*
     * @param root: The root of the tree
     * @param A: node in the tree
     * @param B: node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
        // write your code here 
        
        if (root == null || A == null || B == null) {
            return null; 
        } 
        
        if (A == B) {
            return A; 
        }
        
        /* Find all parents of A, B into two arrays, match the last same one reversly */ 
        List<ParentTreeNode> path_A = new ArrayList(); 
        path_A.add(A); 
        findAllParents(A, path_A); 
        
        List<ParentTreeNode> path_B = new ArrayList(); 
        path_B.add(B); 
        findAllParents(B, path_B); 
        
        int size_A = path_A.size(), size_B = path_B.size(); 
        List<ParentTreeNode> path_small, path_large; 
        int diff; 
        if (size_A < size_B) {
            path_small = path_A; 
            path_large = path_B; 
            diff = size_B - size_A; 
        } else {
            path_small = path_B; 
            path_large = path_A; 
            diff = size_A - size_B; 
        } 
        
        for (int i = 0;i < path_small.size();i ++) {
            if (path_small.get(i) == path_large.get(diff + i)) {
                return path_small.get(i); 
            }
        }
        
        return null; 
    } 
    
    private void findAllParents(ParentTreeNode node, List<ParentTreeNode> path) {
        if (node.parent == null) { 
            return; 
        } 
        
        path.add(node.parent); 
        findAllParents(node.parent, path); 
    }
} 
