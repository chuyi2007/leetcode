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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<List<Integer>> allLevels = new ArrayList<>();
        List<Integer> thisLevel = new ArrayList<>();
        int thisLevelCount = 1, nextLevelCount = 0;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            thisLevel.add(node.val);
            --thisLevelCount;
            if (node.left != null) {
                q.offer(node.left);
                ++nextLevelCount;
            }
            if (node.right != null) {
                q.offer(node.right);
                ++nextLevelCount;
            }
            if (thisLevelCount == 0) {
                thisLevelCount = nextLevelCount;
                nextLevelCount = 0;
                allLevels.add(thisLevel);
                thisLevel = new ArrayList<>();
            }
        }
        return allLevels;
    }
}
