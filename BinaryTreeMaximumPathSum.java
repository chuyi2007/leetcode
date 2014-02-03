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
    public int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        maxPathSum(root, max);
        return max[0];
    }
    
    public int maxPathSum(TreeNode node, int[] max) {
        if (node == null) {
            return 0;
        }
        int left = maxPathSum(node.left, max);
        int right = maxPathSum(node.right, max);
        int sum = left + right + node.val;
        max[0] = Math.max(sum, max[0]);
        sum -= Math.min(left, right);
        return sum > 0 ? sum : 0;
    }
}