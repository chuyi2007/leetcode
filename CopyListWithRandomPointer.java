/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        if (head == null) {
            return null;
        }
        
        RandomListNode result = new RandomListNode(0);
        RandomListNode rCur = result;
        RandomListNode cur = head;
        HashMap<Integer, RandomListNode> map = new HashMap<Integer, RandomListNode>();
        while (cur != null) {
            rCur.next = new RandomListNode(cur.label);
            map.put(rCur.next.label, rCur.next);
            cur = cur.next;
            rCur = rCur.next;
        }
        
        cur = head;
        rCur = result;
        while (cur != null) {
            if (cur.random != null) {
                rCur.next.random = map.get(cur.random.label);
            }
            cur = cur.next;
            rCur = rCur.next;
        }
        return result.next;
    }
}