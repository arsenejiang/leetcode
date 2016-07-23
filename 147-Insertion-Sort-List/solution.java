/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode cur = head.next;
        ListNode prev = head;
        while(cur != null) {
            if (prev.val <= cur.val) {
                prev = cur;
                cur = cur.next;
                continue;
            }
            
            ListNode pos = dummy;
            while(pos.next.val <= cur.val) {
                pos = pos.next;
            }
            
            prev.next = cur.next;
            cur.next = pos.next;
            pos.next = cur;
            cur = prev.next;
        }
        
        return dummy.next;
    }
}