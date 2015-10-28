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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSide = new ArrayList<>();
        rightSideView(root, 0, rightSide);
        return rightSide;
    }
    
    public void rightSideView(
        TreeNode root, 
        int level, 
        List<Integer> rightSide
    ) {
        if (root == null) {
            return;
        }
        if (rightSide.size() == level) {
            rightSide.add(root.val);
        }
        rightSideView(root.right, level + 1, rightSide);
        rightSideView(root.left, level + 1, rightSide);
    }
}
