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
        return sortedListToBST(head, 0, size - 1);
    }
    
    public TreeNode sortedListToBST(ListNode head, int min, int max){
        if(min <= max){
            //avoids overflow
            int mid = min + (max - min) / 2;
            TreeNode leftTree = sortedListToBST(head, min, mid - 1);
            TreeNode midTree = new TreeNode(head.val);
            head = head.next;
            midTree.left = leftTree;
            midTree.right = sortedListToBST(head, mid + 1, max);
            return midTree;
        }
        else    return null;
    }
}