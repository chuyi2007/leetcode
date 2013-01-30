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
        //current level
        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        //result
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        nodes.add(root);
        //true when left to right, false when right to left
        boolean flag = true;
        while(nodes.peek() != null){
            LinkedList<TreeNode> nextLevel = new LinkedList<TreeNode>();
            ArrayList<Integer> result = new ArrayList<Integer>();
            
            while(nodes.peek() != null){
                TreeNode current = nodes.poll();
                result.add(current.val);
                
                if(!flag){
                    if(current.right != null)    nextLevel.add(current.right);
                    if(current.left != null)   nextLevel.add(current.left);
                }
                else{
                    if(current.left != null)    nextLevel.add(current.left);
                    if(current.right != null)   nextLevel.add(current.right);
                }
            }
            
            results.add(result);
            int size = nextLevel.size();
            for(int i = 0; i < size; i++)
                nodes.add(nextLevel.pollLast());
            //nodes = nextLevel;
            flag = !flag;
        }
        return results;
    }
}