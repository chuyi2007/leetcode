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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        int count = 1;
        int nextCount = 0;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentLevel = new ArrayList<>();
        while(!q.isEmpty() && q.peek() != null) {
            TreeNode node = q.poll();
            if (node.left != null) {
                nextCount++;
                q.offer(node.left);
            }
            if (node.right != null) {
                nextCount++;
                q.offer(node.right);
            }
            count--;
            currentLevel.add(node.val);
            if (count == 0) {
                result.add(0, currentLevel);
                currentLevel = new ArrayList<>();
                count = nextCount;
                nextCount = 0;
            }
        }
        return result;
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
        } else {
            return 0;
        }
    }
    
    public void findSameLevel(TreeNode root, int level, ArrayList<Integer> result){
        if (root != null) {
            if (level > 0) {
                findSameLevel(root.left, level - 1, result);
                findSameLevel(root.right, level - 1, result);
            } else {
                result.add(root.val);
            }
        }
    }
}
