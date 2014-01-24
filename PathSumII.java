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
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> results = 
            new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        pathSum(root, sum, path, results);
        return results;
    }
    
    public void pathSum(TreeNode root, int sum, ArrayList<Integer> path, 
    ArrayList<ArrayList<Integer>> results) {
        if (root != null) {
            sum -= root.val;
            path.add(root.val);
            if (sum == 0 && root.left == null && root.right == null) {
                results.add(new ArrayList<Integer>(path));
            }
            pathSum(root.left, sum, path, results);
            pathSum(root.right, sum, path, results);
            path.remove(path.size() - 1);
        }
    }
}