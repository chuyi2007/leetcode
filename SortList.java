/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            ++len;
        }
        if (len <= 1) {
            return head;
        }
        ListNode[] nodes = splitList(head, len);
        ListNode left = sortList(nodes[0]);
        ListNode right = sortList(nodes[1]);
        return mergeSort(left, right);
    }
    
    public ListNode mergeSort(ListNode left, ListNode right) {
        ListNode sen = new ListNode(0);
        ListNode pre = sen;
        while (left != null && right != null) {
            if (left.val > right.val) {
                pre.next = right;
                right = right.next;
            }
            else {
                pre.next = left;
                left = left.next;
            }
            pre = pre.next;
        }
        pre.next = left == null ? right : left;
        return sen.next;
    }
    
    public ListNode[] splitList(ListNode head, int len) {
        ListNode[] nodes = new ListNode[2];
        ListNode cur = head;
        int mid = len / 2;
        for (int i = 0; i < mid - 1; ++i) {
            cur = cur.next;
        }
        nodes[0] = head;
        nodes[1] = cur.next;
        cur.next = null;
        return nodes;
    }
}