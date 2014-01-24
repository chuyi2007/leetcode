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
    public ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null) {
            return head;
        }
        ListNode sen = new ListNode(0);
        sen.next = head;
        ListNode prepre = sen, pre = head, cur = head.next;
        while (cur != null) {
            ListNode next = cur.next;
            prepre.next = cur;
            cur.next = pre;
            pre.next = next;
            if (next != null) {
                prepre = pre;
                pre = next;
                cur = next.next;
            }
            else {
                break;
            }
        }
        return sen.next;
    }
}