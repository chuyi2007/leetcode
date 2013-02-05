/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Back Tracking max, Recursion with return value of sum
public class Solution {
    public int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        maxPathSum(root, max);
        return max[0];
    }
    
    public int maxPathSum(TreeNode node, int[] max){
        if(node != null){
            int left = maxPathSum(node.left, max);
            int right = maxPathSum(node.right, max);
            int sum = left + right + node.val;
            if(sum > max[0])
                max[0] = sum;
            sum -= Math.min(left, right);
            if(sum > 0)
                return sum;
            else
                return 0;
        }
        else
            return 0;
    }
}