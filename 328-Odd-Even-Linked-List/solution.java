/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        
        ListNode cur = head;
        ListNode dummyEven = new ListNode(0);
        ListNode even = dummyEven;
        while(cur != null && cur.next != null) {
            even.next = cur.next;
            even = even.next;
            cur.next = cur.next.next;
            even.next = null;
            if (cur.next == null) {
                break;
            }
            cur = cur.next;
        }
        
        cur.next = dummyEven.next;
        return head;
    }
}