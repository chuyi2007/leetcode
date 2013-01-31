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