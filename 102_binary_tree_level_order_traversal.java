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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        if (root == null) {
            return res;
        }
        
        while (! queue.isEmpty()) {
            List<Integer> levelRes = new ArrayList<>();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentTree = queue.poll();
                if (currentTree == null) {
                    continue;
                }
                levelRes.add(currentTree.val);
                if (currentTree.left != null)
                    queue.add(currentTree.left);
                if (currentTree.right != null)
                    queue.add(currentTree.right);
            }
            res.add(levelRes);
        }
        
        return res;
    }
}