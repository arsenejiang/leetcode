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
        
        ListNode smallDummy = new ListNode(0);
        ListNode largeDummy = new ListNode(0);
        ListNode s = smallDummy, l = largeDummy;
        ListNode cur = head;
        while(cur != null) {
            if (cur.val < x) {
                s.next = cur;
                s = s.next;
                cur = cur.next;
            }
            else {
                l.next = cur;
                l = l.next;
                cur = cur.next;
            }
        }
        
        s.next = largeDummy.next;
        l.next = null;
        return smallDummy.next;
        
    }
}