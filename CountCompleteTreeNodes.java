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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int h = height(root);
        int rightH = height(root.right);
        if (h == rightH + 1) {
            return (1 << h) + countNodes(root.right);
        } else {
            return (1 << h - 1) + countNodes(root.left);
        }
    }
    
    public int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }
}
