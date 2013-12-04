/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        return sumNumbers(root, 0);
    }
    
    public int sumNumbers(TreeNode node, int value) {
        if (node.left == null && node.right == null) {
            return value * 10 + node.val;
        }
        
        int sum = 0;
        if (node.left != null) {
            sum += sumNumbers(node.left, value * 10 + node.val);
        }
        
        if (node.right != null) {
            sum += sumNumbers(node.right, value * 10 + node.val);
        }
        
        return sum;
    }
}