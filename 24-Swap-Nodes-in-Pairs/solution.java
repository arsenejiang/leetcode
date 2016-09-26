/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while(prev.next != null && prev.next.next != null) {
            ListNode cur = prev.next.next;
            prev.next.next = cur.next;
            cur.next = prev.next;
            prev.next = cur;
            prev = prev.next.next;
        }
        
        return dummy.next;
    }
}