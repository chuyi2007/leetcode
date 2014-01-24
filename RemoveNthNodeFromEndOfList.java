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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode sen = new ListNode(0);
        sen.next = head;
        removeNthFromEndHelper(sen, n);
        return sen.next;
    }
    
    public int removeNthFromEndHelper(ListNode head, int n){
        if (head == null) {
            return 0;
        }
        else {
            int count = removeNthFromEndHelper(head.next, n) + 1;
            if (count == n + 1) {
                head.next = head.next.next;
            }
            return count;
        }
    }
}