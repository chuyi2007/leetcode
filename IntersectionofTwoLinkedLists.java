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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int m = getListLength(headA);
        int n = getListLength(headB);
        int diff = Math.abs(m - n);
        
        ListNode longer = m > n ? headA : headB;
        ListNode shorter = m <= n ? headA : headB;
        
        for (int i = 0; i < diff; ++i) {
            longer = longer.next;
        }
        
        ListNode intersect = null;
        while(longer != null && shorter != null) {
            if (longer == shorter) {
                intersect = longer;
                break;
            }
            longer = longer.next;
            shorter = shorter.next;
        }
        return intersect;
    }
    
    public int getListLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }
}
