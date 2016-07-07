/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head;
        ListNode prev = dummy;
        while(cur != null) {
            while(cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            
            if (cur != prev.next) {
                prev.next = cur.next;
                cur = prev.next;
            }
            else {
                prev = cur;
                cur = cur.next;
            }
        }
        
        return dummy.next;
    }
}