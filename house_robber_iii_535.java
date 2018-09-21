/* 
535. House Robber III

The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.
Example

  3
 / \
2   3
 \   \ 
  3   1

Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.

    3
   / \
  4   5
 / \   \ 
1   3   1

Maximum amount of money the thief can rob = 4 + 5 = 9.
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
     * @param root: The root of binary tree.
     * @return: The maximum amount of money you can rob tonight
     */ 
    
    Map<TreeNode, Integer> dp_list_true; 
    Map<TreeNode, Integer> dp_list_false; 
    
    public int houseRobber3(TreeNode root) {
        // write your code here 
        
        if (root == null) {
            return 0; 
        } 
        
        dp_list_true = new HashMap<TreeNode, Integer>(); 
        dp_list_false = new HashMap<TreeNode, Integer>(); 
        int max = findMaxMoneyDP(root, false); 
        
        return max; 
    } 
    
    private int findMaxMoneyDP(TreeNode node, boolean is_prev_robbed) { 
        if (node == null) {
            return 0; 
        } 
        
        if (is_prev_robbed) {
            if (dp_list_true.containsKey(node)) {
                return dp_list_true.get(node); 
            } 
        } else {
            if(dp_list_false.containsKey(node)) {
                return dp_list_false.get(node); 
            }            
        }

        
        int max_money = Integer.MIN_VALUE; 
        if (is_prev_robbed) {
            max_money = max(max_money, findMaxMoneyDP(node.left, false) + findMaxMoneyDP(node.right, false)); 
        } else {
            max_money = max(max_money, findMaxMoneyDP(node.left, false) + findMaxMoneyDP(node.right, false)); 
            max_money = max(max_money, findMaxMoneyDP(node.left, true) + findMaxMoneyDP(node.right, true) + node.val); 
        } 
        
        if (is_prev_robbed) {
            dp_list_true.put(node, max_money); 
        } else {
            dp_list_false.put(node, max_money); 
        }
        
        return max_money; 
    } 
    
    private int max(int a, int b) {
        return (a > b) ? a : b; 
    }
} 
