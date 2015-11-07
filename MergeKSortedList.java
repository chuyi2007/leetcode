/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> q = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });
        ListNode sentinel = new ListNode(0);
        ListNode pre = sentinel;
        for (ListNode node: lists) {
            if (node != null) {
                q.offer(node);
            }
        }
        while (!q.isEmpty()) {
            pre.next = q.poll();
            pre = pre.next;
            if (pre.next != null) {
                q.offer(pre.next);
            }
        }
        return sentinel.next;
    }
}
