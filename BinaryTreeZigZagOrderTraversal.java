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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<TreeNode> thisLevel = new Stack<TreeNode>();
        Stack<TreeNode> nextLevel = new Stack<TreeNode>();
        thisLevel.push(root);
        boolean flag = true;
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        while(!thisLevel.isEmpty() && thisLevel.peek() != null){
            TreeNode node = thisLevel.pop();
            if(!flag){
                if(node.right != null)
                    nextLevel.push(node.right);
                if(node.left != null)
                    nextLevel.push(node.left);
            }
            else{
                if(node.left != null)
                    nextLevel.push(node.left);
                if(node.right != null)
                    nextLevel.push(node.right);
            }
            result.add(node.val);
            if(thisLevel.isEmpty()){
                results.add(result);
                result = new ArrayList<Integer>();
                thisLevel = nextLevel;
                nextLevel = new Stack<TreeNode>();
                flag = !flag;
            }
        }
        return results;
    }
}