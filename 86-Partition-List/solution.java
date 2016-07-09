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
        
        ListNode d1 = new ListNode(0);
        ListNode d2 = new ListNode(0);
        ListNode cur = head, cur1 = d1, cur2 = d2;
        while(cur != null) {
            if (cur.val < x) {
                cur1.next = cur;
                cur1 = cur1.next;
            }
            else {
                cur2.next = cur;
                cur2 = cur2.next;
            }
            
            cur = cur.next;
        }
        
        cur1.next = d2.next;
        cur2.next = null;
        return d1.next;
    }
}