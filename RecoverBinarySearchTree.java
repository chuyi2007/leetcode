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
    TreeNode firstNode = null;
    TreeNode secondNode = null;
    TreeNode preNode = new TreeNode(Integer.MIN_VALUE);
    
    public void recoverTree(TreeNode root) {
        inOrderTraversal(root);
        int tmp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = tmp;
    }
    
    // the inorder traveral of tree's result should be sorted.
    // pre means the previous node in front of current node
    // [1, 2, 6, 4, 5, 3]
    // firstNode node 4, pre 6
    // secondNode node 3, pre 5
    public void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        if (firstNode == null && preNode.val >= node.val) {
            firstNode = preNode;
        }
        if (firstNode != null && preNode.val >= node.val) {
            secondNode = node;
        }
        preNode = node;
        inOrderTraversal(node.right);
    }
}
