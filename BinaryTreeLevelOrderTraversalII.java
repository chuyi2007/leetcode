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
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> allLevels = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> oneLevel = new ArrayList<Integer>();
        Queue<TreeNode> curLevel = new LinkedList<TreeNode>();
        curLevel.offer(root);
        Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
        while (!curLevel.isEmpty() && curLevel.peek() != null) {
            TreeNode node = curLevel.poll();
            if (node.left != null) {
                nextLevel.offer(node.left);
            }
            if (node.right != null) {
                nextLevel.offer(node.right);
            }
            oneLevel.add(node.val);
            if (curLevel.isEmpty()) {
                curLevel = nextLevel;
                nextLevel = new LinkedList<TreeNode>();
                allLevels.add(0, oneLevel);
                oneLevel = new ArrayList<Integer>();
            }
        }
        return allLevels;
    }
}

//Recursion solution, O(N^2)
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        int max = getMaxLevel(root);
        for (int i = max - 1; i >= 0; --i) {
            ArrayList<Integer> result = new ArrayList<Integer>();
            findSameLevel(root, i, result);
            results.add(result);
        }
        return results;
    }
    
    public int getMaxLevel(TreeNode root) {
        if (root!= null) {
            return Math.max(getMaxLevel(root.left), getMaxLevel(root.right)) + 1;
        }
        else {
            return 0;
        }
    }
    
    public void findSameLevel(TreeNode root, int level, ArrayList<Integer> result){
        if (root != null) {
            if (level > 0) {
                findSameLevel(root.left, level - 1, result);
                findSameLevel(root.right, level - 1, result);
            }
            else {
                result.add(root.val);
            }
        }
    }
}