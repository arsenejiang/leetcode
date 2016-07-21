/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        
        RandomListNode cur = head;
        while(cur != null) {
            RandomListNode copy = new RandomListNode(cur.label);
            copy.next = cur.next;
            cur.next = copy;
            cur = copy.next;
        }
        
        cur = head;
        while(cur != null) {
            cur.next.random = (cur.random == null ? null : cur.random.next);
            cur = cur.next.next;
        }
        
        cur = head;
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode newCur = dummy;
        while(cur != null) {
            newCur.next = cur.next;
            newCur = cur.next;
            cur.next = cur.next.next;
            cur = cur.next;
        }
        
        return dummy.next;
    }
}