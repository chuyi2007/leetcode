/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            ++len;
            cur = cur.next;
        }
        if (len == 1) {
            return head;
        }
        ListNode mid = findMid(head, len / 2);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return mergeSort(left, right);
    }
    
    public ListNode mergeSort(ListNode left, ListNode right) {
        ListNode sentinel = new ListNode(0);
        ListNode pre = sentinel;
        while (left != null && right != null) {
            ListNode next;
            if (left.val < right.val) {
                next = left.next;
                pre.next = left;
                left.next = null;
                left = next;
            } else {
                next = right.next;
                pre.next = right;
                right.next = null;
                right = next;
            }
            pre = pre.next;
        }
        pre.next = left != null ? left : right;
        return sentinel.next;
    }
    
    public ListNode findMid(ListNode head, int len) {
        while (len-- > 1) {
            head = head.next;
        }
        ListNode next = head.next;
        head.next = null;
        return next;
    }
}
