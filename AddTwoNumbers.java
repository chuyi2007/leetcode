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
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, cur = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int a = 0, b = 0;
            if (l1 != null) {
                a = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                b = l2.val;
                l2 = l2.next;
            }
            int sum = a + b + carry;
            ListNode l3 = new ListNode(sum % 10);
            carry = sum / 10;
            if (head == null) {
                head = l3;
                cur = head;
            }
            else {
                cur.next = l3;
                cur = cur.next;
            }
        }
        if (carry != 0) {
            cur.next = new ListNode(carry);
        }
        return head;
    }
}