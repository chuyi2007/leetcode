/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode sentinel = new ListNode(0);
        ListNode pre = sentinel;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            pre = sentinel;
            cur = next;
        }
        return sentinel.next;
    }
}

public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode sortHead = null, sortTail = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode insert = cur;
            cur = cur.next;
            insert.next = null;
            if (sortHead == null) {
                sortHead = insert;
                sortTail = insert;
            }
            else if (insert.val <= sortHead.val) {
                insert.next = sortHead;
                sortHead = insert;
            }
            else if (insert.val > sortTail.val) {
                sortTail.next = insert;
                sortTail = insert;
            }
            else {
                ListNode sortCur = sortHead;
                while(sortCur.next != null) {
                    if (sortCur.next.val >= insert.val) {
                        insert.next = sortCur.next;
                        sortCur.next = insert;
                        break;
                    }
                    sortCur = sortCur.next;
                }
            }
        }
        return sortHead;
    }
}
