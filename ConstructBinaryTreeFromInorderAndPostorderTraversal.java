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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }
        int n = postorder.length;
        int cur = postorder[n - 1];
        int pivot = 0;
        for (int i = 0; i < n; ++i) {
            if (cur == inorder[i]) {
                pivot = i;
                break;
            }
        }
        TreeNode node = new TreeNode(cur);
        node.left = buildTree(Arrays.copyOfRange(inorder, 0, pivot), Arrays.copyOfRange(postorder, 0, pivot));
        node.right = buildTree(Arrays.copyOfRange(inorder, pivot + 1, n), Arrays.copyOfRange(postorder, pivot, n - 1));
        return node;
    }
}
