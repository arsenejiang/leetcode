/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode less = dummy;
        while(cur != null) {
            if (cur.val < x) {
                ListNode temp = less.next;
                less.next = cur;
                cur.next = temp;
            }
            
            cur = cur.next;
        }
        
        return dummy.next;
    }
}