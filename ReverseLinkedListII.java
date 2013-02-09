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
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode sen = new ListNode(0);
        sen.next = head;
        ListNode prepre = sen, pre = head, cur = head.next, next = null;
        int index = 1;
        while(true){
            if(index < m){
                prepre = pre;
                pre = cur;
                cur = cur.next;
            }
            else if(index >= m && index < n){
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            else if(index == n){
                prepre.next.next = cur;
                prepre.next = pre;
                break;
            }
            ++index;
        }
        return sen.next;
    }
}

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        //my solution
        if(m == n)
            return head;
        ListNode cur = head, pre = null, start = null, end = null, next = null;
        int count = 0;
        while(count < n){
            ++count;
            if(count == m - 1){
                start = cur;
                cur = cur.next;
            }
            else if(count == m){
                end = cur;
                pre = cur;
                cur = cur.next;
            }
            else if(count >= m && count < n){
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            else if(count == n){
                next = cur.next;
                if(start != null)
                    start.next = cur;
                else
                    head = cur;
                cur.next = pre;
                end.next = next;
            }
            else{
                cur = cur.next;
            }
        }
        return head;
    }
}