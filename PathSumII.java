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
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> results 
        = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        pathSum(results, result, root, sum);
        return results;
    }
    
    public void pathSum(ArrayList<ArrayList<Integer>> results, ArrayList<Integer> result,
    TreeNode root, int sum){
        if(root != null){
            if(root.left == null && root.right == null){
                if(sum == root.val){
                    ArrayList<Integer> tmp = new ArrayList<Integer>();
                    tmp.addAll(result);
                    tmp.add(root.val);
                    results.add(tmp);
                }
            }
            else{
                result.add(root.val);
                pathSum(results, result, root.left, sum - root.val);
                pathSum(results, result, root.right, sum - root.val);
                result.remove(result.size() - 1);
            }
        }
    }
}