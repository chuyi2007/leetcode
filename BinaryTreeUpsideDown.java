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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }   
        TreeNode curLeft = root.left;
        TreeNode curRight = root.right;
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        curLeft.left = root.right;
        curLeft.right = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }
}
