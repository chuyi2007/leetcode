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
    int count = 0;
    int current = 0;
    public int kthSmallest(TreeNode root, int k) {
        inOrderTraversal(root, k);
        return current;
    }
    
    public void inOrderTraversal(TreeNode root, int k) {
        if (count == k || root == null) {
            return;
        }
        inOrderTraversal(root.left, k);
        count++;
        if (k == count) {
            current = root.val;
            return;
        }
        inOrderTraversal(root.right, k);
    }
    
    //Or change the structure of the tree, and store the left child's count
}
