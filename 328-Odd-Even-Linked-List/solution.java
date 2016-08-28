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
        
        ListNode oddDummyHead = new ListNode(0);
        ListNode evenDummyHead = new ListNode(0);
        ListNode cur = head, oddCur = oddDummyHead, evenCur = evenDummyHead;
        while(true) {
            oddCur.next = cur;
            evenCur.next = cur.next;
            oddCur = oddCur.next;
            evenCur = evenCur.next;
            if (cur.next == null || cur.next.next == null) {
                break;
            }
            cur = cur.next.next;
        }
        
        oddCur.next = evenDummyHead.next;
        return oddDummyHead.next;
    }
}