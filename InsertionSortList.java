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
    public ListNode insertionSortList(ListNode head) {
        ListNode cur = head;
        //new head for sorted stored list
        ListNode newHead = null;
        //new tail for sorted stored list's tail
        ListNode newTail = null;
        while (cur != null) {
            ListNode insert = cur;
            cur = cur.next;
            if (newHead == null) {
                newHead = insert;
                newTail = insert;
                newTail.next = null;
            }
            else if (insert.val < newHead.val) {
                insert.next = newHead;
                newHead = insert;
            }
            else if (insert.val > newTail.val) {
                newTail.next = insert;
                newTail = insert;
                newTail.next = null;
            }
            else {
                ListNode ccur = newHead;
                while (ccur!= null) {
                    if (ccur.next == null || ccur.next.val > insert.val) {
                        insert.next = ccur.next;
                        ccur.next = insert;
                        break;
                    }
                    else {
                        ccur = ccur.next;
                    }
                }
            }
        }
        return newHead;
    }
}