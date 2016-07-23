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
        
        ListNode mid = findMid(head);
        ListNode l2 = mid.next;
        mid.next = null;
        return merge(sortList(head), sortList(l2));
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p1 = l1, p2 = l2, p = dummy;
        while(p1 != null || p2 != null) {
            if (p2 == null || p1.val <= p2.val) {
                p.next = p1;
                p1 = p1.next;
                p = p.next;
            }
            else if (p1 == null || p2.val <= p1.val) {
                p.next = p2;
                p2 = p2.next;
                p = p.next;
            }
        }
        
        return dummy.next;
    }
    
    private ListNode findMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
}