/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
//O(N)
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode pre = sentinel;
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                ListNode cur = head.next;
                while (cur != null && head.val == cur.val) {
                    cur = cur.next;
                }
                pre.next = cur;
                head = cur;
            }
            else {
                pre = head;
                head = head.next;
            }
        }
        return sentinel.next;
    }
}
