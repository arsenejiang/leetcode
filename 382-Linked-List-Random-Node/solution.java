/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// HashMap solution
/*
public class Solution {
    private HashMap<Integer, ListNode> map;
    private Random rand;

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
    
    public int getRandom() {
        return map.get(rand.nextInt(map.size())).val;
    }
}
*/

public class Solution {
    ListNode head;
    Random rand;

    public Solution(ListNode head) {
        this.head = head;
        rand = new Random();
    }
    
    public int getRandom() {
        int res = head.val;
        ListNode cur = head;
        for(int i = 1; cur.next != null; i++) {
            cur = cur.next;
            if (rand.nextInt(i + 1) == i) {
                res = cur.val;
            }
        }
        
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */