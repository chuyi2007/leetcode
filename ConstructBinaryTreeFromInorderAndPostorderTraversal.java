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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(inorder.length == 0) return null;
        int val = postorder[postorder.length - 1];
        int index = 0;
        for(int i = 0; i < inorder.length; ++i)
            if(inorder[i] == val){
                index = i;
                break;
            }
        TreeNode node = new TreeNode(val);
        node.left = buildTree(Arrays.copyOfRange(inorder, 0, index), 
        Arrays.copyOfRange(postorder, 0, index));
        node.right = buildTree(Arrays.copyOfRange(inorder, index + 1, inorder.length),
        Arrays.copyOfRange(postorder, index, postorder.length - 1));
        return node;
    }  
}