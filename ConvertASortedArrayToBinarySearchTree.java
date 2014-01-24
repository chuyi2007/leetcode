/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//O(N)
public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return sortedArrayToBST(num, 0, num.length - 1);
    }
    
    public TreeNode sortedArrayToBST(int[] num, int min, int max) {
        if (min <= max) {
            int mid = (min + max) / 2;
            TreeNode midTree = new TreeNode(num[mid]);
            midTree.left = sortedArrayToBST(num, min, mid - 1);
            midTree.right = sortedArrayToBST(num, mid + 1, max);
            return midTree;
        }
        else {
            return null;
        }
    }
}