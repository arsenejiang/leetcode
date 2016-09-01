/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    private HashMap<Integer, ListNode> map;
    private Random rand;

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        map = new HashMap<Integer, ListNode>();
        rand = new Random();
        ListNode cur = head;
        int i = 0;
        while(cur != null) {
            map.put(i++, cur);
            cur = cur.next;
        }
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        return map.get(rand.nextInt(map.size())).val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */