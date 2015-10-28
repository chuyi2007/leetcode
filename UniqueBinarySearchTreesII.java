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
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);    
    }
    
    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> nodes = new ArrayList<>();
        if (start <= end) {
            for (int i = start; i <= end; ++i) {
                List<TreeNode> lefts = generateTrees(start, i - 1);
                List<TreeNode> rights = generateTrees(i + 1, end);
                for (TreeNode left: lefts) {
                    for (TreeNode right: rights) {
                        TreeNode node = new TreeNode(i);
                        node.left = left;
                        node.right = right;
                        nodes.add(node);
                    }
                }
            }
        } else {
            nodes.add(null);
        }
        return nodes;
    }
}
