/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
//O(N^3)
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return generateTrees(1, n);
    }
    
    public ArrayList<TreeNode> generateTrees(int start, int end){
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        if(start <= end){
            for(int i = start; i <= end; ++i){
                ArrayList<TreeNode> left = generateTrees(start, i - 1);
                ArrayList<TreeNode> right = generateTrees(i + 1, end);
                for(TreeNode l: left)
                    for(TreeNode r: right){
                        TreeNode node = new TreeNode(i);
                        node.left = l;
                        node.right = r;
                        result.add(node);
                    }
            }
        }
        else
            result.add(null);
        return result;
    }
}