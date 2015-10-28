/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            ++len;
            cur = cur.next;
        }
        if (len == 0) {
            return null;
        }
        k = len - k % len;
        cur = head;
        ListNode sentinel = new ListNode(0);
        sentinel.next = cur;
        ListNode pre = sentinel;
        while (k > 0) {
            pre = pre.next;
            --k;
        }
        sentinel.next = pre.next;
        pre.next = null;
        pre = sentinel;
        while (pre.next != null) {
            pre = pre.next;
        }
        pre.next = head;
        return sentinel.next;
    }
}
