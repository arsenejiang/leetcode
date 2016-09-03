/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head .next == null) {
            return head;
        }
        
        ListNode prev = head;
        ListNode cur = head.next;
        while(cur != null) {
            if (cur.val == prev.val) {
                prev.next = cur.next;
                cur = cur.next;
            }
            else {
                prev = prev.next;
                cur = cur.next;
            }
        }
        
        return head;
    }
}