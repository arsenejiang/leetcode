/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        HashSet<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        map.put(node, root);
        q.offer(node);
        visited.add(node);
        
        while(!q.isEmpty()) {
            UndirectedGraphNode n = q.poll();
            UndirectedGraphNode clone = map.get(n);
            for(UndirectedGraphNode neighbor: n.neighbors) {
                if (!visited.contains(neighbor)) {
                    q.offer(neighbor);
                    visited.add(neighbor);
                }
                
                if (!map.containsKey(neighbor)) {
                    UndirectedGraphNode cloneNeighbor = new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor, cloneNeighbor);
                }
                
                clone.neighbors.add(map.get(neighbor));
            }
        }
        
        return root;
    }
}