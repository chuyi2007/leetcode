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
//Use a sentry
public class Solution {
    public ListNode partition(ListNode head, int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode small = new ListNode(0), big = new ListNode(0);
        ListNode sen = small, pivot = big;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
                head = head.next;
                small.next = null;
            }
            else {
                big.next = head;
                big = big.next;
                head = head.next;
                big.next = null;
            }
        }
        small.next = pivot.next;
        return sen.next;
    }
}