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
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<String>();
        }
        List<String> result = new ArrayList<>();
        buildPath(root, "", result);
        return result;
    }
    
    public void buildPath(TreeNode root, String path, List<String> result) {
        if (root.left == null && root.right == null) {
            result.add(path + root.val);
        }
        if (root.left != null) {
            buildPath(root.left, path + root.val + "->", result);
        }
        if (root.right != null) {
            buildPath(root.right, path + root.val + "->", result);
        }
    }
}
