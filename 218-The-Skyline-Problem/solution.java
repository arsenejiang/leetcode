public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<int[]>();
        if (buildings == null || buildings.length == 0 || buildings[0].length < 3) {
            return res;
        }
        
        Comparator<Edge> comp = new Comparator<Edge>() {
            @Override
            public int compare(Edge a, Edge b) {
                if (a.x != b.x) {
                    return a.x - b.x;
                }
                
                if (a.isLeft == true && b.isLeft == true) {
                    return b.y - a.y;
                }
                else if (a.isLeft != true && b.isLeft != true) {
                    return a.y - b.y;
                }
                else {
                    return a.isLeft ? -1 : 1;
                }
            }
        };
        
        List<Edge> edges = new ArrayList<Edge>();
        for(int[] building : buildings) {
            edges.add(new Edge(building[0], building[2], true));
            edges.add(new Edge(building[1], building[2], false));
        }
        Collections.sort(edges, comp);
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        int prev = 0;
        for(Edge e: edges) {
            if (e.isLeft) {
                pq.offer(e.y);
            }
            else {
                pq.remove(e.y);
            }
            
            int cur = pq.peek();
            if (cur != prev) {
                res.add(new int[]{e.x, cur});
                prev = cur;
            }
        }
        
        return res;
    }
    
    class Edge{
        int x;
        int y;
        boolean isLeft;
        Edge(int x, int y, boolean isLeft) {
            this.x = x;
            this.y = y;
            this.isLeft = isLeft;
        }
    }
}