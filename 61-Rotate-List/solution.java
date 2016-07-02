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
        if (head == null || k == 0) {
            return head;
        }
        
        ListNode p = head;
        int size = 1;
        while(p.next != null) {
            size++;
            p = p.next;
        }
        
        k = k % size;
        if (k == 0) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode tail = head, prev = head;
        while(k-->0) {
            tail = tail.next;
        }
        
        while(tail.next != null) {
            prev = prev.next;
            tail = tail.next;
        }
        
        tail.next = dummy.next;
        dummy.next = prev.next;
        prev.next = null;
        
        return dummy.next;
    }
}