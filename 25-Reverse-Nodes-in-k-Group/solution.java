/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode tail = head;
        for(int i = 1; i <= k; i++) {
            if (cur == null) {
                return head;
            }
            else {
                cur = cur.next;
            }
        }
        
        int count = k - 1;
        while(count-- > 0) {
            cur = tail.next;
            tail.next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
        }
        
        ListNode newHead = tail.next;
        tail.next = reverseKGroup(newHead, k);
        return dummy.next;
    }
}