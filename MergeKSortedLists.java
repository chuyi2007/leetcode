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
        if(lists.size() == 0)
            return null;
        ArrayList<ListNode> nodes = new ArrayList<ListNode>();
        for(ListNode node: lists)
            if(node != null)
                nodes.add(node);
        ListNode head = null, current = null, min;
        while(!nodes.isEmpty()){
            min = nodes.get(0);
            for(int i = 0; i < nodes.size(); i++){
                if(nodes.get(i).val < min.val)
                    min = nodes.get(i);
            }
            
            if(head == null){
                head = min;
                current = head;
            }
            else{
                current.next = min;
                current = current.next;
            }
            
            nodes.remove(min);
            if(min.next != null){
                nodes.add(min.next);
            }
        }
        return head;
    }
}