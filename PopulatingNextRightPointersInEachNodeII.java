/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
//constant space solution
public class Solution {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root != null){
            if(root.left != null && root.right != null){
                root.left.next = root.right;
                root.right.next = connectToRight(root.next);
            }
            else if(root.left != null){
                root.left.next = connectToRight(root.next);
            }
            else if(root.right != null){
                root.right.next = connectToRight(root.next);
            }
            connect(root.right);
            connect(root.left);
        }
    }
    
    public TreeLinkNode connectToRight(TreeLinkNode root){
        while(root != null){
            if(root.left != null)
                return root.left;
            if(root.right != null)
                return root.right;
            root = root.next;
        }
        return null;
    }
}

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
//O(N) space solution
public class Solution {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        LinkedList<TreeLinkNode> list = new LinkedList<TreeLinkNode>();
        list.offer(root);
        int count = 1;
        while(list.peek() != null){
            int tmp = 0;
            for(int i = 0; i < count; ++i){
                TreeLinkNode node = list.pop();
                if(i == count - 1)
                    node.next = null;
                else
                    node.next = list.peek();
                if(node.left != null){
                    list.offer(node.left);
                    ++tmp;
                }
                if(node.right != null){
                    list.offer(node.right);
                    ++tmp;
                }
            }
            count = tmp;
        }
    }
}