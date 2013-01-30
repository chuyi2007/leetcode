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
        if(removeNthFromEnd(head, n, n) == -1)
            return head.next;
        return head;
    }
    public int removeNthFromEnd(ListNode head, int n, int m){
        if(head == null && m == 0)
            return -1;
        else if(head == null && m != 0)
            return 0;
        int cur = removeNthFromEnd(head.next, n, m - 1) + 1;
        if(cur == 0)
            return -1;
        //find the next one
        if(cur == n + 1)
            head.next = head.next.next;
        return cur;
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode sen = new ListNode(0);
        sen.next = head;
        remove(sen, n);
        return sen.next;
    }
    
    public int remove(ListNode head, int n){
        if(head == null){
            return 0;
        }
        else{
            int size = remove(head.next, n) + 1;
            if(size == n + 1){
               head.next = head.next.next;
            }
            return size;
        }
    }
}