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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode sen = new ListNode(0);
        sen.next = head;
        ListNode prepre = null, pre = sen, cur = head;
        int count = 0;
        pre.next = cur;
        while (true) {
            ++count;
            if (count > m && count <= n) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            else if (count <= m) {
                prepre = pre;
                pre = cur;
                cur = cur.next;
            }
            else if (count > n) {
                prepre.next.next = cur;
                prepre.next = pre;
                break;
            }
        }
        return sen.next;
    }
}