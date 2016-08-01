public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList();
        if (buildings == null || buildings.length == 0 || buildings[0].length == 0) {
            return res;
        }
        
        List<Edge> edges = new ArrayList();
        for(int i = 0; i < buildings.length; i++) {
            edges.add(new Edge(buildings[i][0], buildings[i][2], true));
            edges.add(new Edge(buildings[i][1], buildings[i][2], false));
        }
        
        Comparator<Edge> comp = new Comparator<Edge>() {
            @Override
            public int compare(Edge a, Edge b) {
                if (a.x != b.x) {
                    return a.x - b.x;
                }
                
                // when both are left, higher height go first to prevent unnecessary peek change
                if (a.isLeft && b.isLeft) {
                    return b.height - a.height;
                }
                
                // when both are not left, lower height go first to prevent unnecessary peek change
                if (!a.isLeft && !b.isLeft) {
                    return a.height - b.height;
                }
                
                // left goes first to avoid peek goes to 0
                return a.isLeft ? -1 : 1;
            }
        };
        
        Collections.sort(edges, comp);
        PriorityQueue<Integer> pq = new PriorityQueue(11, Collections.reverseOrder());
        pq.offer(0);
        int prev = 0;
        for(Edge e : edges) {
            if (e.isLeft) {
                pq.offer(e.height);
            }
            else {
                pq.remove(e.height);
            }
            
            int cur = pq.peek();
            
            // compare cur peek with prev skyline, and add into result if they are different
            if (cur != prev) {
                res.add(new int[]{e.x, cur});
                prev = cur;
            }
        }
        
        return res;
    }
}

class Edge {
    int x;
    int height;
    boolean isLeft;
    Edge(int x, int height, boolean isLeft) {
        this.x = x;
        this.height = height;
        this.isLeft = isLeft;
    }
}