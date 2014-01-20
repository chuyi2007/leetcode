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
    //level order use extra space
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        LinkedList<TreeLinkNode> list = new LinkedList<TreeLinkNode>();
        list.offer(root);
        int count = 1;
        while (list.peek() != null) {
            for (int i = 0; i < count; ++i) {
                TreeLinkNode node = list.pop();
                if(i == count - 1) {
                    node.next = null;
                }
                else {
                    node.next = list.peek();
                }
                list.offer(node.left);
                list.offer(node.right);
            }
            count *= 2;
        }
    }
}