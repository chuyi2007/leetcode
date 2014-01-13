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
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            ++len;
            cur = cur.next;
        }
            
        int groupNum = len / k;
            
        ListNode sen = new ListNode(0);
        ListNode pre = sen;
        ListNode ppre = pre;
        pre.next = head;
        cur = head;

        for (int i = 0; i < groupNum; ++i) {
            for (int j = 0; j < k; ++j) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            ListNode ppreNext = ppre.next;
            ppreNext.next = cur;
            ppre.next = pre;
            ppre = ppreNext;
            pre = ppre;
        }
            
        return sen.next;
    }
}