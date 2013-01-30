public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode cur = head;
        if(cur == null || n == 0)   return head;
        int size = 0;
        while(cur != null){
            cur = cur.next;
            ++size;
        }
        int k = n % size;
        if(k == 0)  return head;
        k = size - k;
        cur = head;
        ListNode pre = null;
        while(cur.next != null){
            --k;
            if(k == 0){
                pre = cur.next;
                cur.next = null;
                cur = pre;
            }
            else
                cur = cur.next;
        }
        cur.next = head;
        return pre;
    }
}