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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        nodes.add(root);
        while(nodes.peek() != null){
            LinkedList<TreeNode> tmp = new LinkedList<TreeNode>();
            ArrayList<Integer> result = new ArrayList<Integer>();
            while(nodes.peek() != null){
                TreeNode current = nodes.pop();
                if(current.left != null)    tmp.add(current.left);
                if(current.right != null)   tmp.add(current.right);
                result.add(current.val);
            }
            results.add(result);
            nodes = tmp;
        }
        return results;
    }
}