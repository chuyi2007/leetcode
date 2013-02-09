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
//O(N^2), N is the smallest length between l1 and l2
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int carry = 0;
        ListNode head = null, cur = null;
        while(l1 != null || l2 != null){
            int c1 = 0, c2 = 0;
            if(l1 != null){
                c1 = l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                c2 = l2.val;
                l2 = l2.next;
            }
            int sum = carry + c1 + c2;
            if(head == null){
                head = new ListNode(sum%10);
                cur = head;
            }
            else{
                cur.next = new ListNode(sum%10);
                cur = cur.next;
            }
            carry = sum/10;
        }
        if(carry == 1)
            cur.next = new ListNode(1);
        return head;
    } 
}