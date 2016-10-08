/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) {
            return head;
        }
        
        ListNode cur = head;
        int count = 0;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        
        k = k % count;
        if (k == 0) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        cur = head;
        ListNode prev = dummy;
        k = k - 1;
        while(k-- > 0) {
            cur = cur.next;
        }
        
        while(cur.next != null) {
            cur = cur.next;
            prev = prev.next;
        }
        
        cur.next = dummy.next;
        dummy.next = prev.next;
        prev.next = null;
        
        return dummy.next;
    }
}