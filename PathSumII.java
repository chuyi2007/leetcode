/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> possiblePath = new ArrayList<>();
        pathSum(paths, possiblePath, root, sum);
        return paths;
    }
    
    public void pathSum(
        List<List<Integer>> paths,
        List<Integer> possiblePath,
        TreeNode node,
        int sum
    ) {
        if (node == null) {
            return;
        }
        possiblePath.add(node.val);
	sum -= node.val;
        if (node.left == null && node.right == null && sum == 0) {
            paths.add(new ArrayList<>(possiblePath));
        }
        pathSum(paths, possiblePath, node.left, sum);
        pathSum(paths, possiblePath, node.right, sum);
        possiblePath.remove(possiblePath.size() - 1);
    }
}
