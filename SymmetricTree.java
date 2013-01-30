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
    public boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        //return recursion(root, root);
        LinkedList<TreeNode> q1 = new LinkedList<TreeNode>();
        LinkedList<TreeNode> q2 = new LinkedList<TreeNode>();
        q1.offer(root);
        q2.offer(root);
        while(q1.peek() != null || q2.peek() != null){
            if(q1.peek() == null || q2.peek() == null)
                return false;
            TreeNode n1 = q1.poll();
            TreeNode n2 = q2.poll();
            if(n1.val != n2.val)
                return false;
            if(n1.left != null && n2.right != null){
                q1.offer(n1.left);
                q2.offer(n2.right);
            }
            else if(!(n1.left == null && n2.right == null))
                return false;
            if(n1.right != null && n2.left != null){
                q1.offer(n1.right);
                q2.offer(n2.left);
            }
            else if(!(n1.right == null && n2.left == null))
                return false;
        }
        return true;
    }
    
    public boolean recursion(TreeNode n1, TreeNode n2){
        if(n1 == null && n2 == null)
            return true;
        else if(n1 == null || n2 == null)
            return false;
        else if(n1.val == n2.val)
            return recursion(n1.left, n2.right)
            && recursion(n1.right, n2.left);
        else
            return false;
    }
}