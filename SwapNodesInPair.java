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
    public ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode cur = head;
        boolean flag = true;
        while(cur != null){
            ListNode cur1 = cur;
            cur = cur.next;
            if(cur != null){
                ListNode cur2 = cur;
                cur = cur.next;
                if(cur == null||cur.next == null)
                    cur1.next = cur;
                else
                    cur1.next = cur.next;
                cur2.next = cur1;
                if(flag){
                    head = cur2;
                    flag = false;
                }
            }
        }
        return head;
    }
}

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
    public ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode sen = new ListNode(0);
        sen.next = head;
        if(head == null)
            return head;
        ListNode prepre = sen, pre = head, cur = head.next;
        while(cur != null){
            ListNode next = cur.next;
            prepre.next = cur;
            cur.next = pre;
            pre.next = next;
            if(next != null){
                prepre = pre;
                pre = next;
                cur = next.next;
            }
            else{
                break;
            }
        }
        return sen.next;
    }
}