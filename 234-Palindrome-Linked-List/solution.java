/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode dummy = new ListNode(0);
        while(slow.next != null) {
            ListNode cur = slow.next;
            slow.next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
        }
        
        ListNode p1 = head;
        ListNode p2 = dummy.next;
        while(p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            
            p1 = p1.next;
            p2 = p2.next;
        }
        
        return true;
     }
}