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
        
        res.add("JFK");
        int count = tickets.length;
        String start = "JFK";
        while(count-- > 0) {
            start = map.get(start).poll();
            res.add(start);
        }
        
        return res;
    }
}