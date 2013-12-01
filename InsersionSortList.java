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
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ListNode hhead = null;
        while (head != null) {
            ListNode insert = head;
            head = head.next;
            
            if (hhead == null || insert.val < hhead.val ) {
                insert.next = hhead;
                hhead = insert;
            }
            else {
                ListNode cur = hhead;
                while (cur != null) {
                    if (cur.next == null || insert.val < cur.next.val) {
                        insert.next = cur.next;
                        cur.next = insert;
                        break;
                    }
                    else {
                        cur = cur.next;
                    }
                }
            }
            
        }
        
        return hhead;
    }
}