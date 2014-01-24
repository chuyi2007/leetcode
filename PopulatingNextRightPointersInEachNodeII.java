/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root != null) {
            if (root.left != null && root.right != null) {
                root.left.next = root.right;
            }
            else if (root.left != null) {
                root.left.next = connectToRight(root.next);
            }
            
            if (root.right != null) {
                root.right.next = connectToRight(root.next);
            }

            //connect right first!
            //this is important
            connect(root.right);
            connect(root.left);
        }
    }
    
    public TreeLinkNode connectToRight(TreeLinkNode root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            return root.left;
        }
        if (root.right != null) {
            return root.right;
        }
        return connectToRight(root.next);
    }
}