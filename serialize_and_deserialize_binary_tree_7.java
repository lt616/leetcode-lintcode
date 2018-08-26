/* 
7. Serialize and Deserialize Binary Tree

Design an algorithm and write code to serialize and deserialize a binary tree. Writing the tree to a file is called 'serialization' and reading back from the file to reconstruct the exact same binary tree is 'deserialization'.
Example

An example of testdata: Binary tree {3,9,20,#,#,15,7}, denote the following structure:

  3
 / \
9  20
  /  \
 15   7

Our data serialization use bfs traversal. This is just for when you got wrong answer and want to debug the input.

You can use other method to do serializaiton and deserialization.
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
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here 
        
        if (root == null) {
            return ""; 
        } 
        
        Queue<TreeNode> queue = new LinkedList(); 
        queue.offer(root); 
        StringBuilder serialization = new StringBuilder(); 
        
        while (! queue.isEmpty()) {
            int level_size = queue.size(); 
            for (int i = 0;i < level_size;i ++) {
                TreeNode current = queue.poll(); 
                if (current != null) {
                    serialization.append(current.val + ","); 
                } else {
                    serialization.append("#" + ","); 
                    continue; 
                }
                 
            
                if (current.left != null) {
                    queue.offer(current.left); 
                } else { 
                    queue.offer(null); 
                } 
                
                if (current.right != null) {
                    queue.offer(current.right);  
                } else {
                    queue.offer(null); 
                }                
            }
        } 
        
        return serialization.toString();  
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here 
        
        if (data.equals("")) {
            return null; 
        }
        
        String[] nodes_string = data.split(","); 
        
        int i = 0;   
        Queue<TreeNode> queue = new LinkedList(); 
        TreeNode root = new TreeNode(Integer.parseInt(nodes_string[0]));  
        queue.offer(root); 
        while (! queue.isEmpty()) {
            TreeNode current = queue.poll(); 
            TreeNode left, right; 
            
            if (nodes_string[++ i].equals("#")) {
                left = null; 
            } else {
                left = new TreeNode(Integer.parseInt(nodes_string[i])); 
                queue.offer(left); 
            } 
            
            if (nodes_string[++ i].equals("#")) {
                right = null; 
            } else {
                right = new TreeNode(Integer.parseInt(nodes_string[i])); 
                queue.offer(right); 
            } 
            
            current.left = left; 
            current.right = right; 
        } 
        return root; 
    }
} 
