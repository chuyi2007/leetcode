/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode sen = new ListNode(0);
        sen.next = head;
        ListNode pre = sen, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            if (next != null) {
                pre.next = next;
                cur.next = next.next;
                next.next = cur;
            }
            pre = cur;
            cur = cur.next;
        }
        return sen.next;
    }
}
