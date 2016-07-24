/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        
        Set<ListNode> visited = new HashSet<ListNode>();
        ListNode p1 = headA, p2 = headB;
        while(p1 != null || p2 != null) {
            if (p1 != null) {
                if (visited.contains(p1)) {
                    return p1;
                }
                else {
                    visited.add(p1);
                    p1 = p1.next;
                }
            }
            
            if (p2 != null) {
                if (visisted.contains(p2)) {
                    return p2;
                }
                else {
                    visited.add(p2);
                    p2 = p2.next;
                }
            }
        }
        
        return null;
    }
}