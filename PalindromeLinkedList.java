/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode firstHalfStart = head;
        ListNode secondHalfStart = head;
        ListNode fast = head;
        // Reverse the first half        
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            pre.next = secondHalfStart.next;
            secondHalfStart.next = secondHalfStart.next.next;
            pre.next.next = firstHalfStart;
            firstHalfStart = pre.next;
        }
        
        if (fast.next == null) {
            firstHalfStart = firstHalfStart.next;
        }
        
        secondHalfStart = secondHalfStart.next;
        
        while (secondHalfStart != null) {
            if (firstHalfStart.val != secondHalfStart.val) {
                return false;
            }
            firstHalfStart = firstHalfStart.next;
            secondHalfStart = secondHalfStart.next;
        }
        return true;
    }
}
