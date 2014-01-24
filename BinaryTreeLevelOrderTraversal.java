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
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        ArrayList<ArrayList<Integer>> allLevels = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> thisLevel = new ArrayList<Integer>();
        int thisLevelCount = 1, nextLevelCount = 0;
        while (!q.isEmpty() && q.peek() != null) {
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
                thisLevel = new ArrayList<Integer>();
            }
        }
        return allLevels;
    }
}