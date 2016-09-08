/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        ListNode mid = findMid(head);
        if (mid == null) {
            return null;
        }
        else {
            TreeNode root = new TreeNode(mid.val);
            root.left = sortedListToBST(head);
            root.right = sortedListToBST(mid.next);
            return root;
        }
    }
    
    private ListNode findMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        
        if (prev != null) {
            prev.next = null;
        }
        
        return slow;
    }
}