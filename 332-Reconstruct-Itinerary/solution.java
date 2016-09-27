public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> res = new ArrayList<String>();
        if (tickets == null || tickets.length == 0 || tickets[0].length != 2) {
            return res;
        }
        
        HashMap<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
        for(String[] str : tickets) {
            if (!map.containsKey(str[0])) {
                map.put(str[0], new PriorityQueue<String>());
            }
            
            map.get(str[0]).offer(str[1]);
        }
        
        Stack<String> stack = new Stack<String>();
        stack.push("JFK");
        while(!stack.isEmpty()) {
            while(map.containsKey(stack.peek()) && !map.get(stack.peek()).isEmpty()) {
                stack.push(map.get(stack.peek()).poll());
            }
            
            res.add(stack.pop());
        }
        
        Collections.reverse(res);
        return res;
    }
}