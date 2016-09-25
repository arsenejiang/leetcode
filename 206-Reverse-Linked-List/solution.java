/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head.next;
        ListNode tail = head;
        while(cur != null) {
            tail.next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = tail.next;
        }
        
        return dummy.next;
    }
}