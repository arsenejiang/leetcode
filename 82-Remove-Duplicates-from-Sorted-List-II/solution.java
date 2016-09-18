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
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while(prev.next != null) {
            ListNode cur = prev.next;
            int val = cur.val;
            if (cur.next == null || cur.val != cur.next.val) {
                prev = prev.next;
            }
            else {
                while(cur != null && cur.val == val) {
                    cur = cur.next;
                }
                prev.next = cur;
            }
        }
        
        return dummy.next;
    }
}