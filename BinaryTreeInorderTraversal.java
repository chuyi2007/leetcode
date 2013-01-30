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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
    }
    
    public ArrayList<Integer> naiveRecursion(TreeNode node){
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(node == null)    return new ArrayList<Integer>();
        ArrayList<Integer> tmp = naiveRecursion(node.left);
        for(Integer i: tmp) result.add(i);
        result.add(node.val);
        tmp = naiveRecursion(node.right);
        for(Integer i: tmp) result.add(i);
        return result;
    }
}