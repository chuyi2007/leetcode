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
    public int minDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return minDepth(root, 0);
    }
    
    public int minDepth(TreeNode root, int count){
        if(root == null)
            return count;
        else if(root.left == null && root.right == null)
            return count + 1;
        else if(root.left == null)
            return minDepth(root.right, count + 1);
        else if(root.right == null)
            return minDepth(root.left, count + 1);
        else
            return Math.min(minDepth(root.left, count + 1), minDepth(root.right, count + 1));
    }
}