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
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            cur = cur.next;
            ++len;
        }
        
        if (len == 1) {
            return;
        }
        cur = head;
        int mid = (int)Math.ceil(len / 2.0);
        int index = 0;
        
        ListNode pre = null;
        ListNode next = null;
        while (cur != null) {
            if (index == mid) {
                next = cur.next;
                cur.next = null;
                pre.next = null;
                pre = cur;
                cur = next;
            }
            else if (index > mid) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            else {
                pre = cur;
                cur = cur.next;
            }
            ++index;
        }
        
        cur = head;
        ListNode next2 = null;
        while (cur != null && pre != null) {
            next = cur.next;
            next2 = pre.next;
            cur.next = pre;
            pre.next = next;
            pre = next2;
            cur = next;
        }
    }
}