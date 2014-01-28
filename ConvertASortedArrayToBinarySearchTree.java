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
    public TreeNode sortedArrayToBST(int[] num) {
        int n = num.length;
        if (n > 0) {
            int mid = (n - 1) / 2;
            TreeNode node = new TreeNode(num[mid]);
            node.left = sortedArrayToBST(Arrays.copyOfRange(num, 0, mid));
            node.right = sortedArrayToBST(Arrays.copyOfRange(num, mid + 1, n));
            return node;
        }
        else {
            return null;
        }
    }
}