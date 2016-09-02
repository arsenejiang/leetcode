/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        Comparator<ListNode> comp = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        };
        
        PriorityQueue<ListNode> pq = new PriorityQueue(comp);
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for(ListNode n : lists) {
            if (n != null) {
                pq.offer(n);
            }
        }
        
        while(!pq.isEmpty()) {
            ListNode n = pq.poll();
            cur.next = n;
            cur = cur.next;
            if (n.next != null) {
                pq.offer(n.next);
            }
        }
        
        return dummy.next;
    }
}