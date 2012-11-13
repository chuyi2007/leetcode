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
    public int maxDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Count max = new Count();
        max.val = 0;
        depthSearch(root, max, 0);
        return max.val;
    }
    
    public void depthSearch(TreeNode root, Count max, int count){
        if(root == null){
            if(count > max.val)
                max.val = count;
        }
        else{
            depthSearch(root.left, max, count + 1);
            depthSearch(root.right, max, count + 1);
        }
    }
}