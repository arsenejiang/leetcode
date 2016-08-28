public class Solution {
    // recursion
    /*
    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap();
        for(String[] ticket : tickets) {
            if (!map.containsKey(ticket[0])) {
                map.put(ticket[0], new PriorityQueue<String>());
            }
            
            map.get(ticket[0]).add(ticket[1]);
        }
        
        List<String> route = new ArrayList();
        dfs(map, route, "JFK");
        Collections.reverse(route);
        return route;
    }
    
    private void dfs(Map<String, PriorityQueue<String>> map, List<String> route, String cur) {
        while (map.containsKey(cur) && !map.get(cur).isEmpty()) {
            dfs(map, route, map.get(cur).poll());
        }
        
        route.add(cur);
    }
    */
    
    // iterative
    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap();
        for(String[] ticket : tickets) {
            if (!map.containsKey(ticket[0])) {
                map.put(ticket[0], new PriorityQueue<String>());
            }
            
            map.get(ticket[0]).add(ticket[1]);
        }
        
        Stack<String> stack = new Stack<String>();
        stack.push("JFK");
        List<String> route = new ArrayList<String>();
        while(!stack.isEmpty()) {
            while(map.containsKey(stack.peek()) && !map.get(stack.peek()).isEmpty()) {
                stack.push(map.get(stack.peek()).poll());
            }
            
            route.add(stack.pop());
        }
        
        Collections.reverse(route);
        return route;
    }
}