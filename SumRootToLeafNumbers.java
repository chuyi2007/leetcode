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
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return sumNumbers(root, 0);
    }
    
    public int sumNumbers(TreeNode root, int pre) {
        int sum = root.val + pre * 10;
        if (root.left == null && root.right == null) {
            return sum;
        }
        int left = 0, right = 0;
        if (root.left != null)
            left = sumNumbers(root.left, sum);
        if (root.right != null)
            right = sumNumbers(root.right, sum);
        return left + right;
    }
}
