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
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for(int i = 1; i < m; i++) {
            prev = prev.next;
        }
        
        ListNode cur, end;
        if (prev.next != null && prev.next.next != null) {
            end = prev.next;
            cur = prev.next.next;
        }
        else {
            return dummy.next;
        }
        
        int num = n - m;
        for(int i = 1; i <= n - m; i++) {
            end.next = cur.next;
            cur.next = prev.next;
            prev.next = cur;
            cur = end.next;
        }
        
        return dummy.next;
    }
}