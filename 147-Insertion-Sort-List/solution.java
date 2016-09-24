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
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = head;
        ListNode cur = head.next;
        while(cur != null) {
            ListNode start = dummy;
            while(start != prev && cur.val >= start.next.val) {
                start = start.next;
            }
            
            if (start != prev) {
                prev.next = cur.next;
                cur.next = start.next;
                start.next = cur;
            }
            else {
                prev = cur;
            }
            
            cur = prev.next;
        }
        
        return dummy.next;
    }
}