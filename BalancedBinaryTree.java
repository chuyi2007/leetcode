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
    public boolean isBalanced(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null)    return true;
        else if(Math.abs(getLevel(root.left)-getLevel(root.right)) > 1)  return false;
        else    return isBalanced(root.left) && isBalanced(root.right);
    }
    public int getLevel(TreeNode node){
        if(node == null)    return 0;
        else return Math.max(getLevel(node.left), getLevel(node.right)) + 1;
    }
}