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
    public void recoverTree(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        TreeNode[] mess = new TreeNode[2];
        TreeNode[] pre = new TreeNode[1];
        recoverTree(root, pre, mess);
        int tmp = mess[0].val;
        mess[0].val = mess[1].val;
        mess[1].val = tmp;
    }
    
    //Constant Space solution
    public void recoverTree(TreeNode node, TreeNode[] pre, TreeNode[] mess){
        if(node != null){
            recoverTree(node.left, pre, mess);
            if(pre[0] != null && pre[0].val > node.val){
                if(mess[0] == null)
                    mess[0] = pre[0];
                mess[1] = node;
            }
            pre[0] = node;
            recoverTree(node.right, pre, mess);
        }
    }
    
    //O(N) solution
    public void walkThrough(TreeNode root){
        ArrayList<TreeNode> inOrder = new ArrayList<TreeNode>();
        inOrderTraverse(root, inOrder);
        int first = 0, second = inOrder.size() - 1;
        for(int i = 0;i < inOrder.size(); ++i){
            if(inOrder.get(i).val > inOrder.get(i + 1).val){
                first = i;
                break;
            }
        }
        for(int j = second; j >= 0; --j){
            if(inOrder.get(j).val < inOrder.get(j - 1).val){
                second = j;
                break;
            }
        }
        int tmp = inOrder.get(first).val;
        inOrder.get(first).val = inOrder.get(second).val;
        inOrder.get(second).val = tmp;
    }
    
    public void inOrderTraverse(TreeNode root, ArrayList<TreeNode> inOrder){
        if(root != null){
            if(root.left != null)
                inOrderTraverse(root.left, inOrder);
            inOrder.add(root);
            if(root.right != null)
                inOrderTraverse(root.right, inOrder);
        }
    }
}