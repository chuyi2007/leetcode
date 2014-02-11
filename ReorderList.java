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
    public void reorderList(ListNode head) {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            ++len;
        }
        int mid = (int) Math.ceil(len / 2.0);
        cur = head;
        ListNode pre = null;
        while (cur != null) {
            --mid;
            if (mid > 0) {
                cur = cur.next;
            }
            else {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
        }
        
        cur = head;
        while (cur != null && pre != null) {
            ListNode next1 = cur.next, next2 = pre.next;
            cur.next = pre;
            pre.next = next1;
            cur = next1;
            pre = next2;
        }
    }
}