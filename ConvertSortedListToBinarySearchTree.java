/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//O(N)
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int size = 0;
        ListNode cur = head;
        while(cur != null){
            ++size;
            cur = cur.next;
        }
        ListNode[] wrapper = new ListNode[1];
        wrapper[0] = head;
        return sortedListToBST(wrapper, 0, size - 1);
    }
    
    public TreeNode sortedListToBST(ListNode[] head, int min, int max){
        if(min <= max){
            int mid = (max + min) / 2;
            TreeNode leftTree = sortedListToBST(head, min, mid - 1);
            TreeNode midTree = new TreeNode(head[0].val);
            head[0] = head[0].next;
            midTree.left = leftTree;
            midTree.right = sortedListToBST(head, mid + 1, max);
            return midTree;
        }
        else
            return null;
    }
}