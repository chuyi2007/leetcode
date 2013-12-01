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
    public ListNode sortList(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (head == null) {
            return null;
        }
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            ++len;
        }
        if (len == 1) {
            return head;
        }
        
        ListNode[] nodes = splitList(head, len);
        
        ListNode left = sortList(nodes[0]);
        ListNode right = sortList(nodes[1]);
        
        return mergeSort(left, right);
    }
    
    public ListNode mergeSort(ListNode left, ListNode right) {
        ListNode sentinel = new ListNode(0);
        ListNode cur = sentinel;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            }
            else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        if (left != null) {
            cur.next = left;
        }
        if (right != null) {
            cur.next = right;
        }
        return sentinel.next;
    }
    
    public ListNode[] splitList(ListNode head, int len) {
        int mid = len / 2;
        
        ListNode[] parts = new ListNode[2];
        
        ListNode cur = head;
        
        for (int i = 0; i < mid - 1; ++i) {
            cur = cur.next;
        }
        
        parts[0] = head;
        parts[1] = cur.next;
        cur.next = null;
        
        return parts;
    }
}