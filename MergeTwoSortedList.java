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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode head = null, cur = null;
        while(l1 != null || l2 != null){
            ListNode next = null;
            if(l1 == null){
                if(head == null)
                    head = l2;
                else
                    cur.next = l2;
                break;
            }
            else if(l2 == null){
                if(head == null)
                    head = l1;
                else
                    cur.next = l1;
                break;
            }
            else if(l1.val > l2.val){
                next = l2;
                l2 = l2.next;
            }
            else{
                next = l1;
                l1 = l1.next;
            }
            if(head == null){
                head = next;
                cur = head;
            }
            else{
                cur.next = next;
                cur = cur.next;
            }
        }
        return head;
    }
}