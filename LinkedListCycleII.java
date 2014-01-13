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
    public ListNode detectCycle(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ListNode faster = head, slower = head;
        boolean flag = false;
        while (faster != null && faster.next != null && slower != null) {
            faster = faster.next.next;
            slower = slower.next;
            if (faster == slower && faster != null) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            return null;
        }
        while (true) {
            if (head != slower) {
                head = head.next;
                slower = slower.next;
            }
            else {
                break;
            }
        }
        return head;
    }
}