/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        subTreeSum(root);
        return max;
    }
    
    public int subTreeSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = subTreeSum(root.left);
        int right = subTreeSum(root.right);
        int sum = left + root.val + right;
        max = Math.max(sum, max);
        sum -= Math.min(left, right);
        return sum > 0 ? sum : 0;
    }
}
