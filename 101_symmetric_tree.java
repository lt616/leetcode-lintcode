/* Solution 01: DFS */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        return isMirror(root.left, root.right);
    }
    
    private boolean isMirror(TreeNode leftTree, TreeNode rightTree) {
        if (leftTree == null && rightTree == null) 
            return true;
        
        if (leftTree == null || rightTree == null)
            return false;
        
        if (leftTree.val != rightTree.val)
            return false;
        
        return isMirror(leftTree.left, rightTree.right) && isMirror(leftTree.right, rightTree.left);
    }
}



/* Solution 02: BFS */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < levelSize;i ++) {
                TreeNode current = queue.poll();
                if (current == null) {
                    level.add(-1);
                } else {
                    level.add(current.val);
                    queue.add(current.left);
                    queue.add(current.right);
                }
            }
            if (!isPalindrome(level))
                return false;
        }
        
        return true;
    }
    
    private boolean isPalindrome(List<Integer> level) {
        int start = 0;
        int end = level.size() - 1;
        while (start < end) {
            if (level.get(start) != level.get(end))
                return false;
            start ++;
            end --;
        }
        return true;
    }
}