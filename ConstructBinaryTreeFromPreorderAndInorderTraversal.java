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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(inorder.length == 0) return null;
        int val = preorder[0];
        int index = 0;
        for(int i = 0; i < inorder.length; ++i)
            if(inorder[i] == val){
                index = i;
                break;
            }
        TreeNode node = new TreeNode(val);
        node.left = buildTree(Arrays.copyOfRange(preorder, 1, index + 1),
        Arrays.copyOfRange(inorder, 0, index));
        node.right = buildTree(Arrays.copyOfRange(preorder, index + 1, preorder.length),
        Arrays.copyOfRange(inorder, index + 1, inorder.length));
        return node;
    }
}