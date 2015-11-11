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
    int max = 0;
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        longestConsecutive(root, 0, root.val);
        return max;
    }
    
    public void longestConsecutive(TreeNode node, int cur, int parentVal) {
        if (node == null) {
            return;
        }
        if (node.val == parentVal) {
            ++cur;
        } else {
            cur = 1;
        }
        max = Math.max(cur, max);
        longestConsecutive(node.left, cur, node.val + 1);
        longestConsecutive(node.right, cur, node.val + 1);
    }
}
