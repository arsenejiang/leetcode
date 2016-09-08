/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode m = slow.next;
        slow.next  = null;
        return merge(sortList(head), sortList(m));
    }
    
    public ListNode merge(ListNode m, ListNode n) {
        ListNode dummy = new ListNode(0);
        ListNode m1 = m, n1 = n;
        ListNode cur = dummy;
        while(m1 != null || n1 != null) {
            if (m1 == null) {
                cur.next = n1;
                n1 = n1.next;
            }
            else if (n1 == null) {
                cur.next = m1;
                m1 = m1.next;
            }
            else if (m1.val < n1.val) {
                cur.next = m1;
                m1 = m1.next;
            }
            else {
                cur.next = n1;
                n1 = n1.next;
            }
        }
        
        return dummy.next;
    }
}