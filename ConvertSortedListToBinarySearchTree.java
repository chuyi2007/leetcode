/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    ListNode cur = null;
    public TreeNode sortedListToBST(ListNode head) {
        cur = head;
        int n = 0;
        while (head != null){
            ++n;
            head = head.next;
        }
        return sortedListToBST(0, n - 1);
    }
    
    public TreeNode sortedListToBST(int min, int max) {
        if (max < min) {
            return null;
        }
        int mid = min + (max - min) / 2;
        TreeNode left = sortedListToBST(min, mid - 1);
        TreeNode node = new TreeNode(cur.val);
        cur = cur.next;
        TreeNode right = sortedListToBST(mid + 1, max);
        node.left = left;
        node.right = right;
        return node;
    }
}
