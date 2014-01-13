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
    public boolean hasCycle(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ListNode faster = head, slower = head;
        while (faster != null && faster.next != null && slower != null) {
            faster = faster.next.next;
            slower = slower.next;
            if (faster == slower && faster != null) {
                return true;
            }
        }
        return false;
    }

    //extra space
    public boolean hasCycle(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ListNode cur = head;
        Set<ListNode> set = new HashSet<ListNode>();
        while (cur != null) {
            if (set.contains(cur)) {
                return true;
            }
            set.add(cur);
            cur = cur.next;
        }
        return false;
    }
}