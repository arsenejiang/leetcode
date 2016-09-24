/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return head;
        }
        
        if (m == n) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        int total = n - m + 1;
        while(m-- > 1) {
            prev = prev.next;
        }
        
        ListNode end = prev.next;
        while(total-- > 1) {
            ListNode cur = end.next;
            end.next = cur.next;
            cur.next = prev.next;
            prev.next = cur;
        }
        
        return dummy.next;
    }
}