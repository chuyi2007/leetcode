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
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        //This is for situation that head node is deleted
        ListNode sen = new ListNode(0);
        sen.next = head;
        ListNode cur = head, pre = sen;
        boolean dup = false;
        while(cur != null){
            while(cur.next != null && cur.val == cur.next.val){
                cur = cur.next;
                dup = true;
            }
            if(dup){
                pre.next = cur.next;
                cur = cur.next;
            }
            else{
                pre = cur;
                cur = cur.next;
            }
            dup = false;
        }
        return sen.next;
        //Constant space solution
        /*
        ListNode cur = head;
        head = null;
        if(cur == null || cur.next == null)
            return cur;
        ListNode pos = cur.next;
        ListNode pre = null;
        Boolean flag = false;
        while(pos != null){
            if(cur.val == pos.val){
                pos = pos.next;
                flag = true;
            }
            else{
                if(flag){
                    if(pre != null) pre.next = pos;
                    cur = pos;
                }
                else{ 
                    if(head == null)    head = cur;
                    pre = cur;
                    cur = cur.next;
                }
                
                pos = pos.next;
                flag = false;
            }
        }
        if(flag){
            if(pre != null) pre.next = null;
            else return null;
        }
        else{
            if(head == null) return cur;
        }
        return head;
        */
    }
}