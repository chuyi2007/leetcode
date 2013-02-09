/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Use a queue, no recursion, reverse at the last, O(N)
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        nodes.add(root);
        while(nodes.peek() != null){
            LinkedList<TreeNode> tmp = new LinkedList<TreeNode>();
            ArrayList<Integer> result = new ArrayList<Integer>();
            while(nodes.peek() != null){
                TreeNode current = nodes.pop();
                if(current.left != null)
		    tmp.add(current.left);
                if(current.right != null)
		   tmp.add(current.right);
                result.add(current.val);
            }
            results.add(result);
            nodes = tmp;
        }
        ArrayList<ArrayList<Integer>> finalResult = new ArrayList<ArrayList<Integer>>();
        for(int i = results.size() - 1; i>=0; i--)
            finalResult.add(results.get(i));
        return finalResult;
    }
}

//Recursion solution, O(N^2)
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        int max = getMaxLevel(root);
        for(int i = max - 1; i >= 0; --i){
            ArrayList<Integer> result = new ArrayList<Integer>();
            findSameLevel(root, i, result);
            results.add(result);
        }
        return results;
    }
    
    public int getMaxLevel(TreeNode root){
        if(root!= null)
            return Math.max(getMaxLevel(root.left), getMaxLevel(root.right)) + 1;
        else
            return 0;
    }
    
    public void findSameLevel(TreeNode root, int level, ArrayList<Integer> result){
        if(root != null){
            if(level > 0){
                findSameLevel(root.left, level - 1, result);
                findSameLevel(root.right, level - 1, result);
            }
            else{
                result.add(root.val);
            }
        }
    }
}