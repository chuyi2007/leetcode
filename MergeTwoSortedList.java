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
        ListNode head = null, cur = null;
        while (l1 != null && l2 != null) {
            ListNode smaller = null;
            if (l1.val < l2.val) {
                smaller = l1;
                l1 = l1.next;
            }
            else {
                smaller = l2;
                l2 = l2.next;
            }
            if (head == null) {
                head = smaller;
                cur = smaller;
            }
            else {
                cur.next = smaller;
                cur = cur.next;
            }
        }
        if (head != null) {
            cur.next = l1 == null ? l2 : l1;
        }
        else {
            head = l1 == null ? l2 : l1;
        }
        return head;
    }
}

//Use a sentry
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode sen = new ListNode(0);
        ListNode head = sen;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                sen.next = l1;
                l1 = l1.next;
                sen = sen.next;
            }
            else{
                sen.next = l2;
                l2 = l2.next;
                sen = sen.next;
            }
        }
        sen.next = l1 == null ? l2 : l1;
        return head.next;
    }
}