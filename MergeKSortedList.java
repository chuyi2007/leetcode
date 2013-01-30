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
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        for(int i = lists.size() - 1; i >=0; --i)
            if(lists.get(i) == null)
                lists.remove(i);
        ListNode head = null, cur = null;
        while(lists.size() > 0){
            ListNode min = new ListNode(Integer.MAX_VALUE);
            for(ListNode node: lists)
                if(min.val > node.val)
                    min = node;
            if(head == null){
                head = min;
                cur = head;
            }
            else{
                cur.next = min;
                cur = cur.next;
            }
            lists.remove(min);
            if(min.next != null)
                lists.add(min.next);
        }
        return head;
        
    }
}