/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode tail = slow.next;
        ListNode cur = tail.next;
        while(cur != null) {
            tail.next = cur.next;
            cur.next = slow.next;
            slow.next = cur;
            cur = tail.next;
        }
        
        ListNode first = head, second = slow.next;
        while(first != slow) {
            slow.next = second.next;
            second.next = first.next;
            first.next = second;
            first = second.next;
            second = slow.next;
        }
    }
}