/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    //no extra space
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root != null) {
            if(root.left != null) {
                root.left.next = root.right;
                if(root.next != null) {
                    root.right.next = root.next.left;
                }
            }
            connect(root.left);
            connect(root.right);
        }
    }
}