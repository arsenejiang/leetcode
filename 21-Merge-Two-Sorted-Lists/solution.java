/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p1 = l1, p2 = l2;
        ListNode cur = dummy;
        while(p1 != null || p2 != null) {
            if (p2 == null || p1.val < p2.val) {
                cur.next = p1;
                p1 = p1.next;
            }    
            else {
                cur.next = p2;
                p2 = p2.next;
            }
            
            cur = cur.next;
        }
        
        return dummy.next;
    }
}