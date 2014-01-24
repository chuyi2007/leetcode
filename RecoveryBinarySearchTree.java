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
    public void recoverTree(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        TreeNode[] mess = new TreeNode[2];
        TreeNode[] pre = new TreeNode[1];
        recoverTree(root, pre, mess);
        int tmp = mess[0].val;
        mess[0].val = mess[1].val;
        mess[1].val = tmp;
    }
    
    //Constant Space solution
    public void recoverTree(TreeNode node, TreeNode[] pre, TreeNode[] mess) {
        if (node != null) {
            recoverTree(node.left, pre, mess);
            if (pre[0] != null && pre[0].val > node.val) {
                if (mess[0] == null) {
                    mess[0] = pre[0];
                }
                mess[1] = node;
            }
            pre[0] = node;
            recoverTree(node.right, pre, mess);
        }
    }
}