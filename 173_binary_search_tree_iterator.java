/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {
    private Stack<Integer> stack;
    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        binaryTreeInDescendingOrder(root);
    }
    
    private void binaryTreeInDescendingOrder(TreeNode root) {
        if (root == null)
            return;
        
        binaryTreeInDescendingOrder(root.right);
        this.stack.push(root.val);
        binaryTreeInDescendingOrder(root.left);
    }
    
    /** @return the next smallest number */
    public int next() {
        return this.stack.pop();
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return ! this.stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */